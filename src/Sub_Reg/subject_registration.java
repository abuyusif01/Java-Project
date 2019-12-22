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
import java.io.IOException;
import javafx.scene.control.Button;

public class subject_registration extends GridPane {
    GridPane gridPane = new GridPane();
    public subject_registration() throws IOException {
        //main text
        Text Main_text = new Text("Subject Registration");
        Main_text.setFont(Font.font("Fira Code", FontWeight.SEMI_BOLD,20));
        GridPane.setHalignment(Main_text, HPos.CENTER);

//        gridPane.setPrefHeight(101);
//        gridPane.setPrefWidth(101);


        //create text for Subject name
        Text Subject_name = new Text("Subject Name");
        Text Subject_code = new Text("Subject Code");
        Text Subject_credit = new Text("Credit Hours");
        Text Semester_name = new Text("Semester");
        Text Email_text = new Text("Your Email");
        Text Lectures_name = new Text("Lectures name");

        //create text_field for Subject_name
        TextField Subject_name_field = new TextField();
        Subject_name_field.setPromptText(" Subject Name");
        Subject_name_field.setFocusTraversable(false);

        //create text_field for Email
        TextField Email = new TextField();
        Email.setPromptText("Your Email");

        //create text_field for Subject_code
        TextField Subject_code_field = new TextField();
        Subject_code_field.setPromptText(" Subject Code");
        Subject_code_field.setFocusTraversable(false);

        //create text_field for Subject_credits
        TextField Subject_credit_field = new TextField();
        Subject_credit_field.setPromptText(" Credit Hours");
        Subject_code_field.setFocusTraversable(false);

        //create text_field for semester
        TextField Current_semester = new TextField();
        Current_semester.setPromptText("Current Semester");
        Current_semester.setFocusTraversable(false);

        //create text_field for semester
        TextField lecturer = new TextField();
        lecturer.setPromptText("Lecturer's name");
        lecturer.setFocusTraversable(false);

        //create button
        Button Submit_subject = new Button("Submit");
        Submit_subject.setId("submit_button");
        Submit_subject.setFocusTraversable(false);

        Submit_subject.setMaxWidth(Double.MAX_VALUE);
        Submit_subject.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Submit_subject,HPos.CENTER);
        gridPane.setPrefSize(1600, 1600);
        //create grid_pane and some needed settings
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //add everything to grid_pane
        gridPane.add(Main_text, 0,0,2,1);
        gridPane.add(Semester_name,0,3,2,1);
        gridPane.add(Current_semester,1,3);
        gridPane.add(Subject_name,0,4);
        gridPane.add(Subject_code,0,5);
        gridPane.add(Subject_credit,0,6);
        gridPane.add(Email_text,0,7);
        gridPane.add(Email,1,7);
        gridPane.add(Subject_name_field,1,4);
        gridPane.add(Subject_code_field,1,5);
        gridPane.add(Subject_credit_field,1,6);
        gridPane.add(lecturer,1,8);
        gridPane.add(Lectures_name,0,8);
        gridPane.add(Submit_subject,0,0,2,80);
        gridPane.setPadding(new Insets(10,10,10,10));

        //for saving user Credentials
        user_info Credentials = new user_info();

        //create event handler
        Submit_subject.setOnAction(e -> Credentials.insert_user_subject(Email.getText(),Subject_name_field.getText()));
        String css = getClass().getResource("subject_registration.css").toExternalForm();
        this.getStylesheets().add(css);
        this.getChildren().add(gridPane);
    }
}
