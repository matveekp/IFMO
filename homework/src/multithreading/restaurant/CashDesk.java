package multithreading.restaurant;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class CashDesk implements Runnable{

    private LinkedBlockingQueue<Visitor> queue;
    private int id;

    public CashDesk(int id){
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

            while (true) {

            if (!queue.isEmpty()) {
                Visitor visitor = queue.take();
                System.out.println("Касса № " + id + " Получен заказ для посетителя с id " + visitor.getId());
                Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 3000));
                System.out.println("Заказ готов. Посетитель с id " + visitor.getId() + " получил свой заказ");
            }
            else {
                System.out.println("В кассу № " + id + " нет посетителей...");
                Thread.sleep(1000);
            }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
