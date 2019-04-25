package multithreading.port;

public class Port {
    public static void main(String[] args) {

        Dock dock1 = new Dock(1);
        Dock dock2 = new Dock(2);


        Ship ship1 = new Ship();
        Ship ship2 = new Ship();
        Ship ship3 = new Ship();
        Ship ship4 = new Ship();


        new Thread(new Ship()).start();



    }


}
