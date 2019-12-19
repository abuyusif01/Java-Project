package Login;

import Forgot_password.forgot_password;
import Registration.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Login extends Application {
    public Stage test;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Login");
        this.test = primaryStage;
        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();

        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        String css = getClass().getResource("Login.css").toExternalForm();
        scene.getStylesheets().add(css);
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

    private void addUIControls(GridPane gridPane) throws IOException {
        // Add Header
        Label headerLabel = new Label("Login Form");
        Button help_forget = new Button("Need help?");
        help_forget.setId("help_button");
        help_forget.setUnderline(true);
        help_forget.setFocusTraversable(true);

        headerLabel.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);

        GridPane.setHalignment(headerLabel, HPos.CENTER);

        // Add Name Label
        Label nameLabel = new Label("User Name : ");
        nameLabel.setId("name_label");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Your Username");
        nameField.setId("name_field");
        nameField.setFocusTraversable(false);
        gridPane.add(nameField, 1,1);


        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        passwordLabel.setId("password_label");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Your password");
        passwordField.setId("password_field");
        passwordField.setFocusTraversable(false);
        gridPane.add(passwordField, 1, 3);

        // Add Login Button
        Button submitButton = new Button("Login");
        submitButton.setId("Login_button");
        submitButton.setPrefHeight(10);
        submitButton.setPrefWidth(100);
        submitButton.setAlignment(Pos.CENTER);

        gridPane.add(submitButton, 1, 4);
        gridPane.add(help_forget,1,4);
        GridPane.setHalignment(submitButton, HPos.LEFT);
        GridPane.setHalignment(help_forget,HPos.RIGHT);
        GridPane.setMargin(submitButton, new Insets(10, 0,10,0));


        //method for authentication
        user_info Credentials = new user_info();


        boolean[] search = {false};


        submitButton.setOnAction(event -> {
            if(nameField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                return;
            }
            if(passwordField.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
            }
            try {
                 search[0] = Credentials.auth(nameField.getText(),passwordField.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(search[0]){
                showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Logged in...", "Welcome back "+nameField.getText());
            }else{
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Logged in...", "Check your Credentials and try again");
            }

        });
        help_forget.setOnAction(e-> display("Need Help",this.test));
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void display(String title, Stage new_window) {
        Stage window = new Stage();

        forgot_password forget_pass = new forgot_password();
        registration user_reg = new registration();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        GridPane gridPane = new GridPane();

        Label label = new Label();
        label.setText("You're Welcome :) ");
        Button exit = new Button("exit");
        Button forgot = new Button("forgot pass");
        Button new_user = new Button("New_User?");
        new_user.setUnderline(true);
        new_user.setMaxWidth(Double.MAX_VALUE);
        new_user.setAlignment(Pos.CENTER);
        GridPane.setHalignment(new_user, HPos.CENTER);

        exit Exit = new exit();
        exit.setOnAction(e -> {Exit.platform_way(new_window,"Are You Sure Wanna Leave Login Page? ");window.close();});
        forgot.setOnAction(e -> {forget_pass.start();Exit.platform_way(new_window,"Are You Sure Wanna Leave Login page? ");window.close();});
        new_user.setOnAction(e -> {
            try {
                user_reg.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(label, 0,0,2,1);
        gridPane.add(exit,0,4);
        gridPane.add(new_user,0,5);
        gridPane.add(forgot,0,6);
        GridPane.setHalignment(label, HPos.CENTER);
        label.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(gridPane);
        String css = getClass().getResource("Login.css").toExternalForm();
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
