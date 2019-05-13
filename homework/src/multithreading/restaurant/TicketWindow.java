package multithreading.restaurant;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class TicketWindow implements Runnable{

    LinkedBlockingQueue<Visitor> queue;
    private int id;

    public TicketWindow(int id){
        this.id = id;
        this.queue = new LinkedBlockingQueue<>();
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

    public int getSize(){
        return queue.size();
    }


    @Override
    public void run() {
        try {


            if (!queue.isEmpty()) {

                Visitor visitor = queue.take();
                System.out.println("Получен заказ для посетителя с id " + visitor.getId());
                Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 3000));
                System.out.println("Посетитель с id " + visitor.getId() + " получил свой заказ");


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
