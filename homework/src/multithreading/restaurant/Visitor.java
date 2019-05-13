package multithreading.restaurant;

public class Visitor {

    private int id = 0;
    private String name;
    private static int countVisitors = 0;


    public Visitor(String name) {
        this.name = name;
        this.id = ++countVisitors;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
