package it.unicam.cs.pa.jlife104936.model;

import java.util.ArrayList;
import java.util.List;

public class Rules implements Regola {

    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void applyRules() {

    }

    public Board apply2Rules() {
        Board nextBoard = new Board(board.getRows(), board.getCols());
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Cell cell = board.getCell(i, j);

                int numOfNeighbours = countAliveNeightbours(i, j);

                if (cell.isAlive() && numOfNeighbours < 2)
                    nextBoard.getCell(i, j).setStatus(false);
                else if (cell.isAlive() && numOfNeighbours > 3)
                    nextBoard.getCell(i, j).setStatus(false);
                else if (cell.isAlive() && numOfNeighbours == 2 || numOfNeighbours == 3)
                    nextBoard.getCell(i, j).setStatus(true);
            }
        }
        return nextBoard;
    }

    public int countAliveNeightbours(int row, int col) {
        int count = 0;
        for (Cell cell : getVicini(row, col)) {
            if (cell.isAlive())
                count++;
        }
        return count;
    }

    public List<Cell> getVicini(int row, int col) {
        int nord = row - 1;
        int est = col + 1;
        int sud = row + 1;
        int ovest = col - 1;

        List<Cell> neightboursCell = new ArrayList<>();

        neightboursCell.add(board.getCell(nord, ovest));
        neightboursCell.add(board.getCell(nord, col));
        neightboursCell.add(board.getCell(nord, est));
        neightboursCell.add(board.getCell(row, est));
        neightboursCell.add(board.getCell(sud, est));
        neightboursCell.add(board.getCell(sud, col));
        neightboursCell.add(board.getCell(sud, ovest));
        neightboursCell.add(board.getCell(row, ovest));

        return neightboursCell;
    }
}
