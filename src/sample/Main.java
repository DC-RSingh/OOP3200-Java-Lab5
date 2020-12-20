package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Set the Window Title
        primaryStage.setTitle("Java Lab 5");

        // Create the GridPane Object
        GridPane gridPane = new GridPane();

        // Create the Scene with the GridPane
        Scene scene = new Scene(gridPane, 320, 480);

        // Set the Scene of the Stage
        primaryStage.setScene(scene);

        // Show the Stage/Window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
