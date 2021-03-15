package it.unicam.cs.pa.jlife104936.model;



public class Board implements Campo {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        fillBoard();
    }

    @Override
    public void fillBoard() {
        cells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    @Override
    public Cell getCell(int rows, int cols) {
        return this.cells[fixedRow(rows)][fixedCol(cols)];
    }

    @Override
    public void setCell(int rows, int cols, Cellula cell) {
        this.cells[fixedRow(rows)][fixedCol(cols)] = (Cell) cell;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    private int fixedRow(int row) {
        return (row + getRows()) % getRows();
    }

    private int fixedCol(int col) {
        return (col + getCols()) % getCols();
    }

}
