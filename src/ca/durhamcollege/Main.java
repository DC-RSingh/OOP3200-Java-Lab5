/* OOP3200. F2020. Main.java
 *  A simple app that calculates BMI based on the metric units
 *  entered (kilograms for weight and metres for height).
 *
 *	Author:		Raje Singh, Angus Wai
 *	StudentIDs:	100776793 & 100719558
 *	Version:	2020.12
 *	Date:		December 20, 2020
 */
package ca.durhamcollege;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static int SCENE_WIDTH = 640;
    public static int SCENE_HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Set the Window Title
        primaryStage.setTitle("Java Lab 5");

        // Create the GridPane Object
        // Setting the Style of the GridPane
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-font-size: 20pt; -fx-font-family: 'Agency FB'; -fx-alignment: center;");

        // Height Label
        Label lblMyHeight = new Label("My Height (metres):");

        // Creating the TextField control for Height
        // Setting the Prompt/Placeholder text of the text field
        TextField txtMyHeight = new TextField();
        txtMyHeight.setPromptText("Your height in metres");


        // Weight Label and TextField
        Label lblMyWeight = new Label("My Weight (kilograms):");

        TextField txtMyWeight = new TextField();
        txtMyWeight.setPromptText("Your weight in kilograms");

        // Calculated BMI Label
        // Set to the user's BMI Results (Underweight, Normal, Overweight, Obese)
        Label lblBMI = new Label("");

        // Create the TextField object that holds the calculated BMI
        // Set it to disabled so the user can't actually enter it
        TextField txtBMI = new TextField();
        txtBMI.setDisable(true);

        // Create a Button object
        Button btnCalculateBMI = new Button("Calculate BMI");
        btnCalculateBMI.setPrefWidth(SCENE_WIDTH);

        // Add the Controls to the GridPane
        gridPane.add(lblMyHeight, 0, 0);
        gridPane.add(txtMyHeight, 1, 0);

        gridPane.add(lblMyWeight, 0, 1);
        gridPane.add(txtMyWeight, 1, 1);

        gridPane.add(lblBMI, 0, 2);
        gridPane.add(txtBMI, 1, 2);

        // Have the button take up two columns but only 1 row
        gridPane.add(btnCalculateBMI, 0, 3, 2, 1);


        // Create the Scene with the GridPane
        Scene scene = new Scene(gridPane, SCENE_WIDTH, SCENE_HEIGHT);

        // Set the Scene of the Stage
        primaryStage.setScene(scene);

        // Show the Stage/Window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
