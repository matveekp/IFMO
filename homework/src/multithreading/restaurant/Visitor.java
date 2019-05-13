package multithreading.restaurant;

public class Visitor {

    private int id = 0;
    private String name;


    public Visitor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }




}
