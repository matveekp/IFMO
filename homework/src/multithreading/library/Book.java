package multithreading.library;

public class Book {
    private String title;
    private String author;
    private int id;
    private boolean takeHome;

    public Book(String title, String author, int id, boolean takeHome) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.takeHome = takeHome;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTakeHome() {
        return takeHome;
    }

    public void setTakeHome(boolean takeHome) {
        this.takeHome = takeHome;
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
