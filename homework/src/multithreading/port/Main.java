package multithreading.port;

import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Port port = new Port();

        Dock dock1 = new Dock(1, port);
        Dock dock2 = new Dock(2, port);
        Dock dock3 = new Dock(2, port);

        port.addDock(dock1);
//        port.addDock(dock2);
//        port.addDock(dock3);


        Ship ship1 = new Ship(1000, 500,"cargoShip1");
        Ship ship2 = new Ship(2000, 0,"cargoShip2");
        Ship ship3 = new Ship(2500, 2500,"cargoShip3");
        Ship ship4 = new Ship(1000,  1000,"cargoShip4");



        new Thread(new MyThread(ship1, port)).start();
        Thread.sleep(500);
        new Thread(new MyThread(ship2, port)).start();
        Thread.sleep(500);
        new Thread(new MyThread(ship3, port)).start();
        Thread.sleep(500);
        new Thread(new MyThread(ship4, port)).start();

    }
}

class MyThread implements Runnable {
    private Ship ship;
    private Port port;

    public MyThread(Ship ship, Port port) {
        this.ship = ship;
        this.port = port;
    }

    private static final Logger LOGGER = Logger.getLogger(MyThread.class);

    @Override
    public void run() {

        LOGGER.debug("Starting Thread" + MyThread.class.getSimpleName());
        try {
            port.getFreeDock().takeShip(ship);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }

    }
}
