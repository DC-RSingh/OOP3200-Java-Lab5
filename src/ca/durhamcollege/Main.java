/* OOP3200. F2020. Main.java
 *  A simple JavaFX app that calculates BMI based on the metric units
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

    public static int SCENE_WIDTH = 690;
    public static int SCENE_HEIGHT = 480;


    /**
     * Get the BMI Scale for the given BMI result.
     * @param bmi The intended bmi.
     * @return A string representing the BMI Scale of the result.
     */
    private static String getBMIScale(final double bmi)
    {
        String scale = "Not a Valid BMI";
        if (bmi < 18.5)
        {
            scale = "Underweight";
        }
        else if (bmi >= 18.5 && bmi <= 24.9)
        {
            scale = "Normal";
        }
        else if (bmi >= 25.0 && bmi <= 29.9)
        {
            scale =  "Overweight";
        }
        else
        {
            scale = "Obese";
        }

        return scale;
    }

    /**
     * Calculate the BMI from a given height and weight.
     * @param height The intended height.
     * @param weight The intended weight.
     * @return A double with the BMI result (rounded to 1 decimal place).
     */
    private static double calculateBMI(final double height, final double weight)
    {
        double bmi = weight / ( height * height );
        return (double)Math.round(bmi * 10.0)/10.0;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Set the Window Title
        primaryStage.setTitle("Java Lab 5");
        primaryStage.setResizable(false);

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

        // Action Event that calculates BMI when the button is clicked
        btnCalculateBMI.setOnAction(actionEvent ->
        {
            double height = 0;
            double weight = 0;

            boolean isValid = true;

            // Parse doubles from the TextField text
            try
            {
                height = Double.parseDouble(txtMyHeight.getText());
                weight = Double.parseDouble(txtMyWeight.getText());

            }
            catch (NumberFormatException e)
            {
                isValid = false;
            }

            // If Either height or weight is less than or equal to 0
            if (height <= 0 || weight <= 0)
            {
                isValid = false;
            }

            // If both height and weight are valid, proceed with calculation and update text
            if (isValid)
            {
                double bmi = calculateBMI(height, weight);

                // Set BMI Label Text to BMI Scale
                lblBMI.setText(getBMIScale(bmi));
                lblBMI.setStyle("-fx-text-fill: green;");

                // Set BMI Text Field Text to BMI Value
                txtBMI.setText(String.valueOf(bmi));

                // Set Label
                txtBMI.setStyle("-fx-text-inner-color: green");
            }
            // Else, update text with error message
            else
            {
                lblBMI.setText("Invalid Input");
                lblBMI.setStyle("-fx-text-fill: red");
                txtBMI.setText("Enter positive decimal numbers");
                txtBMI.setStyle("-fx-text-inner-color: red");
            }
        });

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
