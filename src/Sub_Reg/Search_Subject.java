package Sub_Reg;

import Registration.user_info;
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
import java.io.FileNotFoundException;
import java.io.IOException;

public class Search_Subject extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Forgot Password");

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

    private void addUIControls(GridPane gridPane) throws IOException {

        // Add Header
        Label headerLabel = new Label("Search_Subject");
        headerLabel.setAlignment(Pos.TOP_CENTER);
        headerLabel.setFont(Font.font("Fira Code", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,3,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(10, 0,10,0));

        // Add Name Text Field
        TextField Email = new TextField();
        Email.setPromptText("Enter Email");
        Email.setFocusTraversable(false);
        Email.setPrefHeight(30);
        gridPane.add(Email, 1,1);

        // Add Name Text Field
        TextField Subject_name = new TextField();
        Subject_name.setPromptText("Subject Code");
        Subject_name.setFocusTraversable(false);
        Subject_name.setPrefHeight(30);
        gridPane.add(Subject_name, 1,2);

        // Add Submit Button
        Button submitButton = new Button("Ok");
        submitButton.setDefaultButton(true);
        submitButton.setMaxWidth(Double.MAX_VALUE);
        submitButton.setAlignment(Pos.CENTER);
        gridPane.add(submitButton, 1, 4);
        GridPane.setHalignment(submitButton, HPos.CENTER);


        Registration.user_info Credentials = new user_info();
        final String[] found = new String[1];
        submitButton.setOnAction(event -> {
            if(Email.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Email");
                return;
            }
            if (Subject_name.getText().isEmpty()){showAlert(Alert.AlertType.ERROR,gridPane.getScene().getWindow(),"Error","Pls Subject name");
            return;
            }
            try {
                found[0] = Credentials.getUser_subject(Email.getText(),Subject_name.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            showAlert(Alert.AlertType.INFORMATION,gridPane.getScene().getWindow(),"Success",found[0]);
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
