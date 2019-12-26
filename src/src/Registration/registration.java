package Registration;

import Dashboard.dashboard;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class registration  {
    public static  String user;
    public void start() throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Registration Form");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);

        //style
        String css = getClass().getResource("registration.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        // Add Name Label
        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0, 1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPromptText("Your Username Pls");
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1, 1);

        // Add Email Label
        Label emailLabel = new Label("Email ID : ");
        gridPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPromptText("Your Email Pls");
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);
        // Add faculty level
        Label FacultyLabel = new Label("Faculty : ");
        gridPane.add(FacultyLabel, 0, 4);
        
        Label CreditLabel = new Label("Credit : ");
        gridPane.add(CreditLabel, 0, 5);

        // Add Faculty Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Your Password");
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);
        
        TextField FacultyField = new TextField();
        FacultyField.setPromptText("Enter Your Kulliyah");
        FacultyField.setPrefHeight(40);
        gridPane.add(FacultyField, 1, 4);

        //create credit hours
        TextField CreditField = new TextField();
        CreditField.setPromptText("Enter Current Credit Hours");
        CreditField.setPrefHeight(40);
        gridPane.add(CreditField, 1, 5);
        
        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        //create obj to store user data
        user_info Credentials = new user_info();
        dashboard Dash = new dashboard();
        submitButton.setOnAction(event -> {
            if (nameField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Please enter your name");
                return;
            }
            if (emailField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Please enter your email id");
                return;
            }
            if (passwordField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Please enter a password");
                return;
            }
            if (FacultyField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Please Your Kulliyah");
                return;
            }
            if (CreditField.getText().isEmpty()) {
                new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Please Enter Your Credit Hours");
                return;
            }
            
            user = nameField.getText();
            Credentials.insert_user_info(user_info.get_hash(nameField.getText()),user_info.get_hash(passwordField.getText()));

            Credentials.Create_dir(user_info.get_hash(nameField.getText()),nameField.getText(),
                    user_info.get_hash(passwordField.getText()),emailField.getText(),FacultyField.getText(),"Semester_2",CreditField.getText());
            primaryStage.close();
            Dash.start(primaryStage);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createRegistrationFormPane() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
        return gridPane;
    }
}
