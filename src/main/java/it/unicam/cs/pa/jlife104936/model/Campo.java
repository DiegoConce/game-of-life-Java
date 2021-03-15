package it.unicam.cs.pa.jlife104936.model;

public interface Campo {

    void fillBoard();

    Cellula getCell(int rows, int cols);

    void setCell(int rows, int cols, Cellula cell);

    int getRows();

    int getCols();
}
