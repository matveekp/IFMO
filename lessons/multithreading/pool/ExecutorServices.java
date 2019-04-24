package multithreading.pool;

import java.security.spec.ECField;
import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.shutdown();


        ExecutorService singleThread = Executors.newSingleThreadExecutor();

        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));

        singleThread.shutdown();


        ExecutorService cachedThread = Executors.newCachedThreadPool();

        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        Future future1 = scheduledExecutorService.schedule(new CallableTask("scheduledTask"), 5, TimeUnit.SECONDS);

        try {
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        scheduledExecutorService.shutdownNow();


        ScheduledExecutorService runEvryFiveSeconds = Executors.newSingleThreadScheduledExecutor();
        runEvryFiveSeconds.scheduleAtFixedRate(new RunnableTask("everyFiveSeconds"), 1, 5, TimeUnit.SECONDS);


        runEvryFiveSeconds.shutdownNow();

        ScheduledExecutorService runEveryScond = Executors.newSingleThreadScheduledExecutor();
        runEveryScond.scheduleWithFixedDelay(new RunnableTask("everySceond"), 1, 1, TimeUnit.SECONDS);
    }
}

class CallableTask implements Callable<Integer> {

    String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Поток: " + Thread.currentThread().getName() + " из пула "+ name );
        return null;
    }
}

class RunnableTask implements Runnable {

    String name;

    public RunnableTask(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + " из пула "+ name );
    }
}
