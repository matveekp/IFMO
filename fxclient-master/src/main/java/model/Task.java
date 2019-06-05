package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String taskDate;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Task() {
    }

    public Task(String title, String description, String taskDate) {
        this.title = title;
        this.description = description;
        this.taskDate = taskDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
