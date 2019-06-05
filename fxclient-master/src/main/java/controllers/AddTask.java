package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Task;


public class AddTask {
    private Task task;

    @FXML private TextField taskTitle; // название
    @FXML private TextArea taskDescription; // описание
    @FXML private DatePicker taskDate; // дата

    @FXML
    public void addTask(){
        String title = taskTitle.getText();
        String description = taskDescription.getText();
        String date = taskDate.getValue().toString();
        Task task = new Task(title, description, date);
        setTask(task);
        taskDate.getScene().getWindow().hide();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
