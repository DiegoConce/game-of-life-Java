package it.unicam.cs.pa.jlife104936.model;


public class Board implements Campo{
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
        System.out.println("posizione: riga " + cols + " col " + rows);
        return this.cells[fixedRow(rows)][fixedCol(cols)];
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

    @Override
    public String toString() {

        StringBuilder a = new StringBuilder();

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                a.append(cells[i][j] + " ");
            }
            a.append("\n");
        }

        return "Board{" +
                "rows=" + rows +
                ", cols=" + cols +
                ", cells=\n" + a +
                '}';
    }
}
