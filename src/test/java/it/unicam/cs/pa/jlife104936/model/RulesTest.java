package it.unicam.cs.pa.jlife104936.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {
    Board boardTest = new Board(5, 5);
    Board nextBoard;
    Rules rulesTest = new Rules();

    @Test
    void nextGen() {
        setUp();
        nextBoard = rulesTest.nextGen();
        assertTrue(nextBoard.getCell(2, 2).isAlive());
        assertTrue(nextBoard.getCell(2, 1).isAlive());
        assertTrue(nextBoard.getCell(2, 3).isAlive());
    }

    private void setUp() {
        boardTest.getCell(2, 2).setStatus(true);
        boardTest.getCell(1, 2).setStatus(true);
        boardTest.getCell(3, 2).setStatus(true);
        rulesTest.setBoard(boardTest);
    }
}