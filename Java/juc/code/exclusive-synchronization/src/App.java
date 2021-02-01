import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {

        Resource r1 = new Resource();
        Resource r2 = new Resource();
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(() -> {
            r1.func();
        });
        pool.execute(() -> {
            r2.func();
        });

        pool.shutdown();

    }
}
