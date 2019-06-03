package sample.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.model.Task;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Sample implements Initializable {

    @FXML
    private ListView<VBox> allTasks;

    private MultipleSelectionModel<VBox> selectionModel;

    @FXML
    public void openAddTaskWindow() throws IOException {
        System.out.println("Add Task");

        FXMLLoader loader = new FXMLLoader(AddTask.class.getResource("../fxml/addTask.fxml")); // получаем загрузчик xml
        Parent root = loader.load(); // загружаем xml

        AddTask addTaskController = loader.getController();


        Stage addTaskWindow = new Stage();
        addTaskWindow.initModality(Modality.APPLICATION_MODAL); // главное окно будет недоступно пока не закрыто новое окно
        addTaskWindow.setTitle("Добавление задачи");
        addTaskWindow.setScene(new Scene(root)); // создаем сцену и передаем подгруженный xml
        addTaskWindow.showAndWait();

        updateScene(addTaskController.getTask());

    }

    private void updateScene(Task task) {

        if (task == null) {
            System.out.println("Задача не передана");
            return;
        }

        Label title = new Label(task.getTitle());
        Label description = new Label(task.getDecription());
        Label date = new Label(task.getDate().toString());

        VBox vBox = new VBox(title, description, date);
        vBox.setAlignment(Pos.TOP_CENTER);

        allTasks.getItems().add(vBox);

    }

    @FXML
    private void closeTasks(){

        // получаем все выделенные вертикальные боксы
        ObservableList<VBox> selectedTasks = selectionModel.getSelectedItems();
        if ( selectedTasks.size() != 0 ) {

            for (VBox vBox : selectedTasks) {
                allTasks.getItems().remove(vBox);
            }
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectionModel = allTasks.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void showChart() throws IOException {

        FXMLLoader loader = new FXMLLoader(Chart.class.getResource("../fxml/chart.fxml"));
        Parent root = loader.load();

        Stage chartWindow = new Stage();
        chartWindow.initModality(Modality.APPLICATION_MODAL);
        chartWindow.setTitle("Chart");
        chartWindow.setScene(new Scene(root));
        chartWindow.show();

    }


}
