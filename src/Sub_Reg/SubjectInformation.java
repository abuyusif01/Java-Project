package Sub_Reg;

import Login.Login;
import Registration.user_info;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SubjectInformation extends GridPane {
    user_info info = new user_info();
    GridPane gridPane = new GridPane();
    public SubjectInformation() {

        gridPane.setPadding(new Insets(5, 5, 5, 5));
        info.getUser_subject(user_info.get_hash(Login.UserName));

        Text Main_text = new Text("Subject Information");
        Main_text.setFont(Font.font("Fira Code", FontWeight.SEMI_BOLD, 25));
        GridPane.setHalignment(Main_text, HPos.CENTER);


        Text Subject_value = new Text(user_info.sSubject_name);
        Text Code_value = new Text(user_info.sSubject_code);
        Text Credit_value = new Text(user_info.sSubject_credit);
        Text Lecturer_value = new Text( user_info.sLecturer);

        Text subjectText = new Text("Subject: ");
        Text CodeText = new Text("Code: ");
        Text CreditText = new Text("Credit: ");
        Text LecturerText = new Text("Lecturer: ");

        HBox HSubject = new HBox(subjectText);
        HBox HSubjectCode = new HBox(CodeText);
        HBox HCreditHours = new HBox(CreditText);
        HBox HLecturerName = new HBox(LecturerText);

        VBox VSubject = new VBox(Subject_value);
        VBox VSubjectCode = new VBox(Code_value);
        VBox VCreditHours = new VBox(Credit_value);
        VBox VLecturerName = new VBox(Lecturer_value);

        VSubject.setSpacing(5);
        VSubjectCode.setSpacing(5);
        VCreditHours.setSpacing(5);
        VLecturerName.setSpacing(5);
        HSubject.setSpacing(5);
        HSubjectCode.setSpacing(5);
        HCreditHours.setSpacing(5);
        HLecturerName.setSpacing(5);

        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.add(Main_text, 0,0,2,1);
        gridPane.add(HSubject,0,2);
        gridPane.add(HSubjectCode,1,2);
        gridPane.add(HCreditHours,2,2);
        gridPane.add(HLecturerName,3,2);
        gridPane.add(VSubject,0,3);
        gridPane.add(VSubjectCode,1,3);
        gridPane.add(VCreditHours,2,3);
        gridPane.add(VLecturerName,3,3);
        this.getChildren().add(this.gridPane);
    }
}