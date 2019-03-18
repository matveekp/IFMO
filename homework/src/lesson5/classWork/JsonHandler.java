package lesson5.classWork;

public class JsonHandler extends Handler {
    @Override
    public void read() {
        System.out.println("Reading file from JSON");
    }

    @Override
    public void write() {
        System.out.println("Writing to JSON");
    }
}
