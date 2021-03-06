package it.unicam.cs.pa.jlife104936.model;

public class BoardPatterns implements Patterns {
    Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public Board spaceShip() {
        board.getCell(13, 6).setStatus(true);
        board.getCell(13, 7).setStatus(true);
        board.getCell(13, 8).setStatus(true);

        board.getCell(14, 8).setStatus(true);
        board.getCell(15, 8).setStatus(true);
        board.getCell(16, 8).setStatus(true);

        board.getCell(14, 5).setStatus(true);
        board.getCell(17, 7).setStatus(true);
        board.getCell(17, 5).setStatus(true);
        return board;
    }

    @Override
    public Board pentomio() {
        board.getCell(12, 7).setStatus(true);
        board.getCell(13, 7).setStatus(true);
        board.getCell(14, 7).setStatus(true);
        board.getCell(15, 7).setStatus(true);
        board.getCell(16, 7).setStatus(true);
        return board;
    }

    @Override
    public Board toad() {
        board.getCell(13, 8).setStatus(true);
        board.getCell(14, 8).setStatus(true);
        board.getCell(15, 8).setStatus(true);

        board.getCell(14, 7).setStatus(true);
        board.getCell(15, 7).setStatus(true);
        board.getCell(16, 7).setStatus(true);
        return board;
    }
}
