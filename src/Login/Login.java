package Login;

import javafx.application.Application;
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

public class Login extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Login");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
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
        gridPane.setPadding(new Insets(20, 20, 20, 20));

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
        Label headerLabel = new Label("Login Form");
        Button help_forget = new Button("Help forget my password");

        headerLabel.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);

        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Laabel
        Label nameLabel = new Label("User Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Your Username");
        nameField.setFocusTraversable(false);
//        nameField.setPrefHeight(30);
        gridPane.add(nameField, 1,1);


        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Your password");
        passwordField.setFocusTraversable(false);
//        passwordField.setPrefHeight(30);
        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Login");
        submitButton.setPrefHeight(10);
        submitButton.setDefaultButton(true);
        help_forget.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        submitButton.setAlignment(Pos.CENTER);

        gridPane.add(submitButton, 1, 4);
        gridPane.add(help_forget,1,4);
        GridPane.setHalignment(submitButton, HPos.LEFT);
        GridPane.setHalignment(help_forget,HPos.RIGHT);

        GridPane.setMargin(submitButton, new Insets(10, 0,10,0));

        submitButton.setOnAction(event -> {
            if(nameField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                return;
            }
            if(passwordField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                return;
            }

            showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Login Successful!", "Welcome " + nameField.getText());
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
