package Sub_Reg;

import Registration.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class subject_registration extends GridPane {

    GridPane gridPane = new GridPane();
    public subject_registration() {
        //main text
        Text Main_text = new Text("Subject Registration");
        Main_text.setFont(Font.font("Fira Code", FontWeight.SEMI_BOLD,20));
        GridPane.setHalignment(Main_text, HPos.CENTER);

        //create text for Subject name
        Text UserNameLabel = new Text("Username: ");
        Text Subject_nameLabel = new Text("Subject Name: ");
        Text Subject_codeLabel = new Text("Subject Code: ");
        Text Subject_creditLabel = new Text("Credit Hours: ");
        Text Lectures_nameLabel = new Text("Lectures name");

        //create text_field for Username
        TextField UserNameField = new TextField();
        UserNameField.setPromptText(" Username");

        //create text_field for Subject_name
        TextField Subject_nameField = new TextField();
        Subject_nameField.setPromptText(" Subject Name");

        //create text_field for Subject_code
        TextField Subject_codeField = new TextField();
        Subject_codeField.setPromptText(" Subject Code");

        //create text_field for Subject_credits
        TextField Subject_creditField = new TextField();
        Subject_creditField.setPromptText(" Credit Hours");

        //create text_field for semester
        TextField lecturerField = new TextField();
        lecturerField.setPromptText("Lecturer's name: ");

        //create button
        Button Submit_button = new Button("Submit");
        Submit_button.setId("submit_button");
        
        Submit_button.setMaxWidth(Double.MAX_VALUE);
        Submit_button.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Submit_button,HPos.CENTER);
        gridPane.setPrefSize(1600, 1600);
        //create grid_pane and some needed settings
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //add everything to grid_pane
        gridPane.add(Main_text, 0,0,2,1);
        gridPane.add(UserNameLabel,0,3,2,1);
        gridPane.add(UserNameField,1,3);
        gridPane.add(Subject_nameLabel,0,4);
        gridPane.add(Subject_codeLabel,0,5);
        gridPane.add(Subject_creditLabel,0,6);
        gridPane.add(Subject_nameField,1,4);
        gridPane.add(Subject_codeField,1,5);
        gridPane.add(Subject_creditField,1,6);
        gridPane.add(lecturerField,1,7);
        gridPane.add(Lectures_nameLabel,0,7);
        gridPane.add(Submit_button,0,0,2,80);
        gridPane.setPadding(new Insets(10,10,10,10));

        //create event handler
        Submit_button.setOnAction(e -> {new user_info().insert_user_subject(user_info.get_hash(UserNameField.getText()),Subject_nameField.getText(),Subject_codeField.getText(),
                Subject_creditField.getText(), lecturerField.getText());
        if(UserNameField.getText().isEmpty() || Subject_codeField.getText().isEmpty() || Subject_creditField.getText().isEmpty()) {
            new Resources.AlertBox.showAlert(gridPane.getScene().getWindow(), "Pls fill the form");
            return;
        }
            new Resources.AlertBox.showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "Done...", "Subject Added successfully!!");});
        String css = getClass().getResource("subject_registration.css").toExternalForm();
        this.getStylesheets().add(css);
        this.getChildren().add(gridPane);
    }
}
