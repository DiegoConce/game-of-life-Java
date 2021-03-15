package it.unicam.cs.pa.jlife104936.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board boardTest = new Board(5, 5);
    Cell cellTest = new Cell();

    @Test
    void fillBoard() {
        for (int i = 0; i < boardTest.getRows(); i++) {
            for (int j = 0; j < boardTest.getCols(); j++) {
                assertFalse(boardTest.getCell(i, j).isAlive());
            }
        }
    }

    @Test
    void getCell() {
        cellTest.setStatus(true);
        boardTest.setCell(1, 1, cellTest);
        assertTrue(boardTest.getCell(1, 1).isAlive());
    }

    @Test
    void getRows() {
        assertEquals(5, boardTest.getRows());
    }

    @Test
    void getCols() {
        assertEquals(5, boardTest.getCols());
    }
}