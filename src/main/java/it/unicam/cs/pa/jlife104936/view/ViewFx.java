package it.unicam.cs.pa.jlife104936.view;

import it.unicam.cs.pa.jlife104936.controller.Controller;
import it.unicam.cs.pa.jlife104936.model.Cell;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

public class ViewFx {

    protected Controller controller;
    private final FileChooser fileChooser = new FileChooser();

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private GridPane gridPane;


    public void initGrid() {
        int rows = controller.getBoard().getRows();
        int cols = controller.getBoard().getCols();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                addSquare(i, j);
            }
        }
    }

    private void addSquare(int row, int col) {
        Pane square = new Pane();
        Cell cell = controller.getBoard().getCell(row, col);

        square.setPrefSize(25, 25);
        square.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        square.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            cell.setStatus(!cell.isAlive());
            setSquareStyle(square, cell);
        });

        setSquareStyle(square, cell);
        gridPane.add(square, row, col);
    }

    private void setSquareStyle(Pane square, Cell cell) {
        if (cell.isAlive()) {
            square.setStyle("-fx-background-color: lightblue");
        } else {
            square.setStyle("-fx-background-color: steelblue");
        }
    }

    @FXML
    private void handlePlay() {
        controller.applyRules();
        initGrid();
    }

    @FXML
    private void handleClear() {
        controller.clearBoard();
        initGrid();
    }

    @FXML
    private void handleRandom() {
        controller.randomBoard();
        initGrid();
    }

    @FXML
    private void handleSave() {
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("JSON files", "*.json");
        fileChooser.setTitle("Save a game");
        fileChooser.getExtensionFilters().add(filter);
        File saveFile = fileChooser.showSaveDialog(null);

        if (saveFile != null) {
            controller.saveBoard(saveFile);
        }
    }

    @FXML
    private void handleLoad() {
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("JSON files", "*.json");
        fileChooser.setTitle("Load a game");
        fileChooser.getExtensionFilters().add(filter);
        File openFile = fileChooser.showOpenDialog(null);

        if (openFile != null) {
            controller.loadBoard(openFile);
            initGrid();
        }
    }
}
