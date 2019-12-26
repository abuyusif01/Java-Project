package Testing;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test_File extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<String> tableView = new TableView<>();
        TableColumn<String, String> tableColumn = new TableColumn<>("Dracula");
        TableColumn<String, String> tableColumn1= new TableColumn<>("Dracula");
        tableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().toString()));
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(tableColumn1);
        ObservableList<String> items = FXCollections.observableArrayList("Itachi");
        ObservableList<String> items1 = FXCollections.observableArrayList("Itachi");
        ObservableList<String> items2 = FXCollections.observableArrayList("Itachi");
//        tableColumn.getColumns().add(0)

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}