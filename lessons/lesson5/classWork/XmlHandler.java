package lesson5.classWork;

public class XmlHandler extends Handler{
    @Override
    public void read() {
        System.out.println("Reading file from XML");
    }

    @Override
    public void write() {
        System.out.println("Writing to XML");
    }
}
