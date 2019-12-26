package Forgot_password;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;


public class forgot_password {
    public void start() {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Forgot Password");
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();

        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);

        String css = getClass().getResource("forgot_password.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Set the scene in primary stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Set the horizontal gap between columns
        gridPane.setHgap(5);

        // Set the vertical gap between rows
        gridPane.setVgap(5);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        // Add Header
        Label headerLabel = new Label("Forgot Password");
        headerLabel.setAlignment(Pos.TOP_CENTER);
        headerLabel.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,3,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(10, 0,10,0));

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Email");
        nameField.setFocusTraversable(false);
        nameField.setPrefHeight(30);
        gridPane.add(nameField, 1,1);

        // Add Submit Button
        Button submitButton = new Button("Send Verification Link");
        submitButton.setDefaultButton(true);
        submitButton.setMaxWidth(Double.MAX_VALUE);
        submitButton.setAlignment(Pos.CENTER);
        gridPane.add(submitButton, 1, 4);
        GridPane.setHalignment(submitButton, HPos.CENTER);


        submitButton.setOnAction(event -> {
            if(nameField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Email");
                return;
            }
            new Resources.AlertBox.showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Successfully!","Receive link?");

        });

    }

}