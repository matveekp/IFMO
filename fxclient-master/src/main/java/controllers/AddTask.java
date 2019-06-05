package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.Task;
import model.TaskRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class AddTask {
    private Task task;

    @FXML
    private TextField taskTitle; // название
    @FXML
    private TextArea taskDescription; // описание
    @FXML
    private DatePicker taskDate; // дата
    FileChooser fileChooser = new FileChooser();
    @FXML
    private Label imagePath;

    private TaskRequest taskRequest = new TaskRequest();

    @FXML
    public void addTask() throws IOException {
        String title = taskTitle.getText();
        String description = taskDescription.getText();
        String date = taskDate.getValue().toString();
        Task task = new Task(title, description, date);
        task.setImagePath(imagePath.getText());

        // отправляем на сервер для сохранения в бд
        taskRequest.postRequest(task);


        setTask(task);
        taskDate.getScene().getWindow().hide();
    }

    @FXML
    public void addImage() {

        fileChooser.setTitle("Добавление изображения");
        fileChooser.getExtensionFilters().addAll(

                new FileChooser.ExtensionFilter("png", "*.png"),
                new FileChooser.ExtensionFilter("jpg", "*.jpg")
        );
        File file = fileChooser.showOpenDialog(taskTitle.getScene().getWindow());

        imagePath.setText(file.getAbsolutePath());
    }


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
