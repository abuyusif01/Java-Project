package Sub_Reg;

import Registration.user_info;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Search_Subject extends GridPane{
    public Search_Subject() throws IOException {
        // Create the registration form grid pane
        GridPane gridPane = new GridPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        String css = getClass().getResource("search_subject.css").toExternalForm();
        this.getStylesheets().add(css);
        this.getChildren().add(gridPane);

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
        gridPane.add(Email, 1,1);

        // Add Name Text Field
        TextField Subject_name = new TextField();
        Subject_name.setPromptText("Subject Code");
        Subject_name.setFocusTraversable(false);
        gridPane.add(Subject_name, 1,2);

        // Add Submit Button
        Button submitButton = new Button("Ok");
        submitButton.setDefaultButton(true);
        submitButton.setMaxWidth(Double.MAX_VALUE);
        submitButton.setAlignment(Pos.CENTER);
        gridPane.add(submitButton, 1, 4);
        gridPane.setPrefSize(1000, 1000);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));

        Registration.user_info Credentials = new user_info();
        final String[] found = new String[1];
        submitButton.setId("submit_button");
        submitButton.setOnAction(event -> {
            if(Email.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Email");
                return;
            }
//            if (Subject_name.getText().isEmpty()){showAlert(Alert.AlertType.ERROR,gridPane.getScene().getWindow(),"Error","Pls Subject name");
//            return;
//            }
//            try {
////                found[0] = Credentials.getUser_subject(Email.getText(),Subject_name.getText);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            showAlert(Alert.AlertType.INFORMATION,gridPane.getScene().getWindow(),"Success",found[0]);
        });

    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        String css = getClass().getResource("search_subject.css").toExternalForm();
        this.getStylesheets().add(css);
        alert.initOwner(owner);
        alert.show();
    }

}