package synchronizedDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {

        SynchronizedDemo demo1 = new SynchronizedDemo();
        SynchronizedDemo demo2 = new SynchronizedDemo();

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(() -> demo1.func());
        pool.execute(() -> demo2.func());

        // 0 1 2 0 1 2 3 4 3 5 4 5 6 7 8 9 6 7 8 9

        pool.shutdown();

    }
}
