package multithreading.port;

import java.util.concurrent.SynchronousQueue;

public class Dock {
    int id;
    SynchronousQueue<Ship> queue;


    public Dock(int id) {
        this.id = id;
        queue = new SynchronousQueue<>();
    }


    public void goToDock(Ship ship) {

        try {
            queue.put(ship);
            System.out.println("Корабль причалил к доку");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void leaveDock() {
        queue.poll();
        System.out.println("Корабль покинул док");
    }


}
