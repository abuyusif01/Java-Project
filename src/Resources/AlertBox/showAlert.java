package Resources.AlertBox;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class showAlert extends GridPane {

    public showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        String css = getClass().getResource("Alert.css").toExternalForm();
        this.getStylesheets().add(css);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    public showAlert(Window owner, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String css = getClass().getResource("Alert.css").toExternalForm();
        this.getStylesheets().add(css);
        alert.setTitle("Form Error!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}