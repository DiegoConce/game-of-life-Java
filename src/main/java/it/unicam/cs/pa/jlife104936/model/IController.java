package it.unicam.cs.pa.jlife104936.model;

import java.io.File;

public interface IController {

    Campo getBoard();

    void applyRules();

    void clearBoard();

    void randomBoard();

    void saveBoard(File file);

    void loadBoard(File file);
}
