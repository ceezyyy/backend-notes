package useFutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task = new FutureTask<>(() -> {
            return "Hello World from " + Thread.currentThread().getName();
        });

        new Thread(task, "t1").start();

        System.out.println("Hello World from " + Thread.currentThread().getName());

        System.out.println(task.get());

    }
}
