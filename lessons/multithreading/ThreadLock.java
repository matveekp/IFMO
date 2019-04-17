package multithreading;

public class ThreadLock {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 START");
                synchronized (obj1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread1 locked obj1");
                    synchronized (obj2) {
                        System.out.println("thread1 locked obj2");
                    }
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 START");
                synchronized (obj1) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("thread2 locked obj1");
                    synchronized (obj2) {
                        System.out.println("thread2 locked obj2");
                    }
                }
            }
        });

thread1.start();
thread2.start();

    }
}
