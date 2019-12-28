package DisplayInfo;
import Login.Login;
import Registration.user_info;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DisplayInfo extends GridPane{
    GridPane gridPane = new GridPane();
    user_info info = new user_info();
    public DisplayInfo() {
        info.getUser_info(user_info.get_hash(Login.UserName));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(5,5,5,5));

        Text Main_text = new Text("USer InFormation");
        Main_text.setFont(Font.font("Fira Code", FontWeight.SEMI_BOLD,25));
        GridPane.setHalignment(Main_text, HPos.CENTER);

        Text UserNameLabel = new Text("Username: ");
        Text Password = new Text("Password: ");
        Text Email = new Text("Email: ");
        Text Faculty = new Text("Faculty: ");
        Text CreditHours = new Text("Total Credit Hours: ");

        Text UserNameLabelValue = new Text(user_info.sUsername);
        Text PasswordValue = new Text(user_info.sPassword);
        Text EmailValue = new Text(user_info.sEmail);
        Text FacultyValue = new Text(user_info.sFaculty);
        Text CreditHoursValue = new Text(user_info.sTotal_credit);

        Button Clear = new Button("Ok");
        Clear.setId("Clear_button");
        Clear.setMaxWidth(Double.MAX_VALUE);
        Clear.setAlignment(Pos.CENTER);
        GridPane.setHalignment(Clear,HPos.CENTER);

        gridPane.add(Main_text, 0,0,2,1);
        gridPane.add(UserNameLabel,0,3,2,1);
        gridPane.add(UserNameLabelValue,1,3,2,1);
        gridPane.add(Password,0,4);
        gridPane.add(PasswordValue,1,4);
        gridPane.add(Email,0,5);
        gridPane.add(EmailValue,1,5);
        gridPane.add(Faculty,0,6);
        gridPane.add(FacultyValue,1,6);
        gridPane.add(CreditHours,0,7);
        gridPane.add(CreditHoursValue,1,7);
        gridPane.add(Clear,0,0,2,25);

        String css = getClass().getResource("DisplayInfo.css").toExternalForm();
        this.getStylesheets().add(css);
        this.getChildren().add(gridPane);
    }
}