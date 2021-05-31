package multithreading;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class F_CallableFuture implements Callable<String> {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new F_CallableFuture();

        for (int i = 0; i < 100; i++) {
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }

        for (Future<String> fut : list) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }
}
