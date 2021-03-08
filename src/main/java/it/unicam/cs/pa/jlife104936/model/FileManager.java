package it.unicam.cs.pa.jlife104936.model;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager implements IFileManager {
    private final Gson gson;

    public FileManager() {
        this.gson = new Gson();
    }


    @Override
    public void save(Campo board, File file) {
        Writer writer;
        try {
            writer = new FileWriter(file);
            String stringBoard = gson.toJson(board);
            writer.write(stringBoard);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Campo load(File file) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String fileString = readFile(file.getPath());

            Board boardLoaded = gson.fromJson(fileString, Board.class);
            br.close();
            return boardLoaded;
        } catch (JsonParseException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
