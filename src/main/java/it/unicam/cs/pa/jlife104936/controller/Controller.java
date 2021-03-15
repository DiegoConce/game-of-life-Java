package it.unicam.cs.pa.jlife104936.controller;

import it.unicam.cs.pa.jlife104936.model.*;

import java.io.File;
import java.util.Random;

public class Controller implements IController {
    private Board board;
    private Rules rules = new Rules();
    private final FileManager fileManager = new FileManager();
    BoardPatterns patterns = new BoardPatterns();

    public Controller() {
        this.board = new Board(30, 15); //30 15
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void applyRules() {
        rules.setBoard(this.board);
        this.board = rules.nextGen();
    }

    @Override
    public void clearBoard() {
        for (int i = 0; i < getBoard().getRows(); i++) {
            for (int j = 0; j < getBoard().getCols(); j++) {
                getBoard().getCell(i, j).setStatus(false);
            }
        }
    }

    @Override
    public void randomBoard() {
        Random rnd = new Random();

        for (int i = 0; i < getBoard().getRows(); i++) {
            for (int j = 0; j < getBoard().getCols(); j++) {
                getBoard().getCell(i, j).setStatus(rnd.nextBoolean());
            }
        }
    }

    @Override
    public void saveBoard(File file) {
        fileManager.save(getBoard(), file);
    }

    @Override
    public void loadBoard(File file) {
        this.board = (Board) fileManager.load(file);
    }

    @Override
    public void loadSpaceship() {
        clearBoard();
        patterns.setBoard(board);
        this.board = patterns.spaceShip();
    }

    @Override
    public void loadPentomio() {
        clearBoard();
        patterns.setBoard(board);
        this.board = patterns.pentomio();
    }

    @Override
    public void loadToad() {
        clearBoard();
        patterns.setBoard(board);
        this.board = patterns.toad();
    }
}
