package Testing;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Test_File extends StackPane {
    public Test_File(){
        Label des = new Label("INFORMATION");
        VBox boom = new VBox(des);
        this.getChildren().add(boom);
    }
}
