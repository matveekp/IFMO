package multithreading.synchronises;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static final CountDownLatch START = new CountDownLatch(6);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(new Runner(2000)).start();
        }

        while (START.getCount() > 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("На старт"); // описываем какое то событие
        START.countDown();

        System.out.println("еще событие какое то, например пришли данные");
        START.countDown();

        START.countDown();

    }


    public static class Runner implements Runnable {

        long sleep;

        public Runner(long sleep) {
            this.sleep = sleep;
        }

        @Override
        public void run() {
            try {
                System.out.println("Бегун + " + Thread.currentThread().getName() + " на старте");
                START.countDown();
                START.await();
                Thread.sleep(sleep);
                System.out.println("Бегун + " + Thread.currentThread().getName() + " финишировал");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
