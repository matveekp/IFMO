package sample.model;

import java.time.LocalDate;

public class Task {
    private String title;
    private String decription;
    private LocalDate date;

    public Task(String title, String decription, LocalDate date) {
        this.title = title;
        this.decription = decription;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public String getDecription() {
        return decription;
    }

    public LocalDate getDate() {
        return date;
    }
}
