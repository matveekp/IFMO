package multithreading.restaurant;

import java.util.concurrent.LinkedBlockingQueue;

public class TicketWindow {

    LinkedBlockingQueue<Visitor> queue = new LinkedBlockingQueue<>();
    private int id;

    public TicketWindow(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addVisitor(Visitor visitor) {
        try {
            queue.put(visitor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
