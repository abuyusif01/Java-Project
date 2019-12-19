package Sub_Reg;

import Registration.*;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class subject_registration  {
    public Scene first_scene;
    public Stage test;
    public GridPane gridPane =  new GridPane();
    public void start() throws IOException {
        Stage FirstStage = new Stage();
        //main text
        Text Main_text = new Text("Subject Registration");
        Main_text.setFont(Font.font("Fira Code", FontWeight.SEMI_BOLD,20));
        GridPane.setHalignment(Main_text, HPos.CENTER);


        //create text for Subject name
        Text Subject_name = new Text("Subject Name");
        Text Subject_code = new Text("Subject Code");
        Text Subject_credit = new Text("Credit Hours");
        Text Semester_name = new Text("Select semester");
        Text Email_text = new Text("Enter your Email");

        //create radio buttos
        RadioButton semester_1 = new RadioButton("Semester 1");
        RadioButton semester_2 = new RadioButton("Semester 2");
        RadioButton semester_3 = new RadioButton("Semester 3");

        //create text_field for Subject_name
        TextField Subject_name_field = new TextField();
        Subject_name_field.setPromptText(" Subject Name");
        Subject_name_field.setFocusTraversable(false);

        //create text_field for Subject_name
        TextField Email = new TextField();
        Email.setPromptText(" Subject Name");
        Email.setFocusTraversable(false);

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

        // create toggle for the radio button
        final ToggleGroup group = new ToggleGroup();
        semester_1.setToggleGroup(group);
        semester_1.setSelected(true);
        semester_2.setToggleGroup(group);
        semester_3.setToggleGroup(group);

        //create box
        HBox box = new HBox();
        box.setSpacing(5);
        box.getChildren().addAll(semester_1,semester_2,semester_3);

        //create button
        Button Submit_subject = new Button("Submit");
        Submit_subject.setMaxWidth(Double.MAX_VALUE);
        Submit_subject.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Submit_subject,HPos.CENTER);
        Submit_subject.setDefaultButton(true);

        //create grid_pane and some needed settings
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //add everything to grid_pane
        gridPane.add(Semester_name,0,3);
        gridPane.add(Current_semester,1,3);
        gridPane.add(Subject_name,0,4);
        gridPane.add(Subject_code,0,5);
        gridPane.add(Subject_credit,0,6);
        gridPane.add(Email_text,0,7);
        gridPane.add(Subject_name_field,1,4);
        gridPane.add(Subject_code_field,1,5);
        gridPane.add(Subject_credit_field,1,6);
        gridPane.add(Email,1,7);
        gridPane.add(Submit_subject,0,0,2,60);
        gridPane.add(Main_text, 0,0,2,1);
        gridPane.setAlignment(Pos.CENTER);

        //for saving user Credentials
        user_info Credentials = new user_info();

        //create event handler
        Submit_subject.setOnAction(e ->{
            Credentials.insert_user_subject(Email.getText(),Subject_name_field.getText());
            FirstStage.close();
        });

        //no need to comment
        first_scene = new Scene(gridPane);
        String css = getClass().getResource("subject_registration").toExternalForm();
        first_scene.getStylesheets().add(css);
        this.test=return_stage(FirstStage);
        FirstStage.setScene(first_scene);

        FirstStage.show();
    }
    public Stage return_stage(Stage stage){
        return stage;
    }

}
