package it.unicam.cs.pa.jlife104936.view;

import it.unicam.cs.pa.jlife104936.controller.Controller;
import javafx.fxml.FXML;

public class Buttons {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void print() {
        System.out.println(controller.getBoard().toString());
    }

    private void test() {
        if (this.controller == null){
            System.out.println("pdio");
        }
    }


    @FXML
    private void handlePlay() {
      test();
    }
}
