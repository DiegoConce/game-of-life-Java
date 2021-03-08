package it.unicam.cs.pa.jlife104936.model;

import java.io.File;

public interface IFileManager {

    void save(Campo board, File file);

    Campo load(File file);
}
