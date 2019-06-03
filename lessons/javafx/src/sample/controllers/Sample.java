package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Sample {

    @FXML
    public void openAddTaskWindow() throws IOException {
        System.out.println("Add Task");

        FXMLLoader loader = new FXMLLoader(AddTask.class.getResource("../fxml/addTask.fxml")); // получаем загрузчик xml
        Parent root = loader.load(); // загружаем xml

        Stage addTaskWindow = new Stage();
        addTaskWindow.initModality(Modality.APPLICATION_MODAL); // главное окно будет недоступно пока не закрыто новое окно
        addTaskWindow.setTitle("Добавление задачи");
        addTaskWindow.setScene(new Scene(root)); // создаем сцену и передаем подгруженный xml
        addTaskWindow.show();



    }

}
