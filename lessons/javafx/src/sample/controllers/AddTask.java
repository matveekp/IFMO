package sample.controllers;

import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.Task;

public class AddTask {

    private Task task;

    @FXML
    private TextField taskTitle;

    @FXML
    private TextArea taskDescription;

    @FXML
    private DatePicker taskDate;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @FXML
    private void addTask() {

        System.out.println(taskTitle.getText());
        System.out.println(taskDescription.getText());
        System.out.println(taskDate.getValue());

        Task task = new Task(taskTitle.getText(), taskDescription.getText(), taskDate.getValue());
        setTask(task);

        // закрываем окно (берем любое поле для этого, у них у всех одна сцена)
        taskDate.getScene().getWindow().hide();


    }

}
