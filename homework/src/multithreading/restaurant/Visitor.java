package multithreading.restaurant;

public class Visitor {
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                '}';
    }
}
