package multithreading.port;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;

public class Dock {
    private int id;
    //    private SynchronousQueue<Ship> queue;
    private BlockingQueue<Ship> queue;
    private Port port;
    private Semaphore semaphore;
    private List<Ship> list;
    private static final Logger LOGGER = Logger.getLogger(MyThread.class);

    public Dock(int id, Port port) {
        this.id = id;
        this.port = port;
//        this.queue = new SynchronousQueue<>();
        this.queue = new ArrayBlockingQueue<>(1);
        this.semaphore = new Semaphore(1);
    }


    private void loadShip(Ship ship) throws InterruptedException {
        LOGGER.debug("Start load ship");
        while (ship.hasFreeSpace()) {
            ship.addCargo(100);
            Thread.sleep(300);
        }
        System.out.println("Корабль " + ship.getName() + " загружен");

        LOGGER.debug("Ship is loaded");

    }

    private void unloadShip(Ship ship) throws InterruptedException {
        LOGGER.debug("Start unload ship");
        while (!ship.isEmpty()) {
            ship.getCargo(100);
            Thread.sleep(300);
        }
        System.out.println("Корабль " + ship.getName() + " разгружен");
        LOGGER.debug("Ship is unloaded");
    }


    public void takeShip(Ship ship) throws InterruptedException {



//        if (queue.isEmpty()) {


        queue.put(ship);
        LOGGER.debug("Ship " + ship.getName() + " is going to doc");
        System.out.println("Прибывает корабль " + ship.getName() + " к доку " + id);


        System.out.println("Корабль " + ship.getName() + " причалил к доку " + id);
        Thread.sleep(1000);

        if (ship.hasCargo()) {
            System.out.println("Корабль " + ship.getName() + " разгружается");
            unloadShip(ship);
        }


        System.out.println("Корабль " + ship.getName() + " на погрузке");
        loadShip(ship);


        Thread.sleep(500);
        releaseShip(ship);
        LOGGER.debug("Ship " + ship.getName() + " leaved doc");
    }


    public void releaseShip(Ship ship) throws InterruptedException {
        queue.poll();
        System.out.println("Корабль " + ship.getName() + " покинул док " + id);
        Thread.sleep(500);
    }

    public boolean isFree() {
        while (queue.size() != 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //return queue.size() == 0 ? true : false;
        return true;
    }


}
