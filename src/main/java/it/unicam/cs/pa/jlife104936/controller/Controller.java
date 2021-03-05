package it.unicam.cs.pa.jlife104936.controller;

import it.unicam.cs.pa.jlife104936.model.Board;
import it.unicam.cs.pa.jlife104936.model.Rules;

public class Controller {
    private Board board;
    private Rules rules = new Rules();

    public Controller() {
        this.board = new Board(5, 5);
    }

    public Board getBoard() {
        return board;
    }

    public void init() {
        board.getCell(0, 0).setStatus(true);
        board.getCell(1, 0).setStatus(true);
        board.getCell(2, 0).setStatus(true);
    }

    public void applyRules(){
        rules.setBoard(this.board);
        this.board = rules.apply2Rules();
    }
}
