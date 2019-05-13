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

            int tryCounts = 0;

            while (tryCounts != 10) {

            if (!queue.isEmpty()) {
                tryCounts = 0;
                System.out.println("\nКасса № " + id + " . Очередь " + queue.size() + " человек.");
                Visitor visitor = queue.take();
                System.out.println("Касса № " + id + " Получен заказ для посетителя с id " + visitor.getId());
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                System.out.println("Заказ готов. Посетитель с id " + visitor.getId() + " получил свой заказ\n");
            }
            else {
                System.out.println("\nВ кассу № " + id + " нет посетителей...\n");
                Thread.sleep(500);
                tryCounts++;
            }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
