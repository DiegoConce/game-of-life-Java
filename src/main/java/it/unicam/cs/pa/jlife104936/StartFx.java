package it.unicam.cs.pa.jlife104936;

import it.unicam.cs.pa.jlife104936.controller.Controller;
import it.unicam.cs.pa.jlife104936.view.ViewFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartFx extends Application {
    private ViewFx view;
    private Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View.fxml"));
        AnchorPane root = loader.load();

        controller.randomBoard();
        view = loader.getController();
        view.setController(controller);
        view.initGrid();

        primaryStage.setTitle("jlife");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
