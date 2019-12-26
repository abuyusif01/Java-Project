package Login;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class exit {

    public void platform_way(Stage user_window, String message) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Exit");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Yes");
        Button nobutton = new Button("No");
        nobutton.setOnAction(e -> window.close());
        closeButton.setOnAction(e -> {window.close();user_window.close();});

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton,nobutton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        String css = getClass().getResource("Login.css").toExternalForm();
        scene.getStylesheets().add(css);
        //Display window and wait for it to be closed before returning
        window.setScene(scene);
        window.showAndWait();
    }
}