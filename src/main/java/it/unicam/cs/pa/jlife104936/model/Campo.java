package it.unicam.cs.pa.jlife104936.model;

public interface Campo {

    void fillBoard();

    Cellula getCell(int rows, int cols);

    int getRows();

    int getCols();
}
