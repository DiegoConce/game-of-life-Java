package it.unicam.cs.pa.jlife104936.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller ctrTest = new Controller();

    @Test
    void clearBoard() {
        ctrTest.clearBoard();

        for (int i = 0; i < ctrTest.getBoard().getRows(); i++) {
            for (int j = 0; j < ctrTest.getBoard().getCols(); j++) {
                assertFalse(ctrTest.getBoard().getCell(i,j).isAlive());
            }
        }
    }

}