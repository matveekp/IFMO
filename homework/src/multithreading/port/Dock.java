package multithreading.port;

import java.util.concurrent.SynchronousQueue;

public class Dock {
    int id;
    SynchronousQueue<Ship> queue;
    Port port;


    public Dock(int id, Port port) {
        this.id = id;
        this.port = port;
        this.queue = new SynchronousQueue<>();
    }


    private void loadShip(Ship ship) throws InterruptedException {

        while (ship.hasFreeSpace()) {
            ship.addCargo(100);
            Thread.sleep(300);
        }
        System.out.println("Корабль " + ship.getName() + " загружен");

    }

    private void unloadShip(Ship ship) throws InterruptedException {

        while (!ship.isEmpty()) {
            ship.getCargo(100);
            Thread.sleep(300);
        }
        System.out.println("Корабль " + ship.getName() + " разгружен");

    }


    public void takeShip(Ship ship) throws InterruptedException {


        System.out.println("Прибывает корабль " + ship.getName() + " к доку " + id);

        queue.offer(ship);

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

    }


    public void releaseShip(Ship ship) throws InterruptedException {
        queue.poll();
        System.out.println("Корабль " + ship.getName() + " покинул док " + id);
    }

    public boolean isFree() {
        return queue.isEmpty();
    }


}
