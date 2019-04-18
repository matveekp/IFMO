package multithreading;

public class multithreading {

    public static void main(String[] args) {


        Thread myThread = new MyThreadd();
        myThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread1 = new Thread(new OtherThread("One"));
        System.out.println(thread1.getState());
        Thread thread2 = new Thread(new OtherThread("Two"));
        Thread thread3 = new Thread(new OtherThread("Three"));

        thread1.start();
        thread2.start();
        thread3.start();


        try {
            System.out.println("Ожидание завершения потоков");
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Завершение основного потока");


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running: " + Thread.currentThread().isAlive() + " " +
                        Thread.currentThread().getState());
            }
        });


        Thread thread = new WhileThread();

        thread.setDaemon(true);
        thread.start();

        thread4.start();

        System.out.println("thread4: " + thread4.getState());


        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted())
                    System.out.println("thread5");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });

//        thread5.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread5.interrupt();

    }
}

class MyThreadd extends Thread {


    @Override
    public void run() {
        Thread.currentThread().setName("multithreading.MyThreadd");
        System.out.println(Thread.currentThread().getName());
    }
}

class OtherThread implements Runnable {

    String name;

    public OtherThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}


class WhileThread extends Thread {
    @Override
    public void run() {

        while(true) {
            System.out.println("multithreading.WhileThread;");
        }
    }
}