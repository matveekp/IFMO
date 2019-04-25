package multithreading.port;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Port port = new Port();

        Dock dock1 = new Dock(1, port);
        Dock dock2 = new Dock(2, port);

        port.addDock(dock1);
        port.addDock(dock2);


        Ship ship1 = new Ship(1000, 500,"cargoShip1");
        Ship ship2 = new Ship(2000, 100,"cargoShip2");
        Ship ship3 = new Ship(2500, 2500,"cargoShip3");
        Ship ship4 = new Ship(1000,  1000,"cargoShip4");

//        dock1.takeShip(ship1);
//        dock1.takeShip(ship2);


        new Thread(new MyThread(ship1, port)).start();
        new Thread(new MyThread(ship2, port)).start();
    }
}

class MyThread implements Runnable {
    Ship ship;
    Port port;

    public MyThread(Ship ship, Port port) {
        this.ship = ship;
        this.port = port;
    }

    @Override
    public void run() {

        try {
            port.getFreeDock().takeShip(ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
