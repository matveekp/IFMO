package multithreading.synchronize;

import java.util.ArrayList;

public class Counter {
    int counter = 0;

    public synchronized void increment() {
        counter++;
    }

}


class IncrementThread extends Thread {

    Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            synchronized (counter) {
//                counter.counter++;
//            }

            counter.increment();

        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            threads.add(new IncrementThread(counter));
        }

        for (IncrementThread thread : threads) {
            thread.start();
        }


        for (IncrementThread thread : threads) {
            thread.join();
        }

        System.out.println(counter.counter);

    }
}