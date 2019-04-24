package multithreading.pool;


import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, //основное кол-во потоков
                10, //максимальное кол-во потоков
                2, TimeUnit.MINUTES, //как долго потоки могут простаивать
                new ArrayBlockingQueue<>(3)
        );

        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task2());
        queue.add(new Task3());
        queue.add(new Task());
        queue.add(new Task3());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task3());
        queue.add(new Task());

        for (Runnable runnable : queue) {
            pool.execute(runnable);
        }

        pool.shutdown();


    }
}


class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task: " + getClass().getName() + " " + Thread.currentThread().getName());
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task2: " + getClass().getName() + " " + Thread.currentThread().getName());
    }
}

class Task3 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task3: " + getClass().getName() + " " + Thread.currentThread().getName());
    }
}