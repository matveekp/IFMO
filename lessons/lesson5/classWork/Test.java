package lesson5.classWork;

public class Test {

    public static void main(String[] args) {

        Handler json = new JsonHandler();

        json.read();
        json.write();

        Handler xml = new XmlHandler();
        xml.read();
        xml.write();

    }
}
