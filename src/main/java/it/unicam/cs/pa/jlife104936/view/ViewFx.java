package it.unicam.cs.pa.jlife104936.view;

import it.unicam.cs.pa.jlife104936.controller.Controller;
import it.unicam.cs.pa.jlife104936.model.Cell;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ViewFx {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private GridPane gridPane;

    public void initButtons() {
        Buttons buttons = new Buttons();
        buttons.setController(controller);
        buttons.print();
    }

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

}
