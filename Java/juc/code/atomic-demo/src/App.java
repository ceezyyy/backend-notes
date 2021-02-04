import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demo of java.util.concurrent.atomic.AtomicInteger
 */
public class App {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        Resource resource = new Resource();

        pool.execute(() -> {
            for (int i = 0; i < 500; i++) {
                resource.increase();
            }
        });
        pool.execute(() -> {
            for (int i = 0; i < 500; i++) {
                resource.increase();
            }
        });

        pool.shutdown();

        System.out.println(Resource.getAi());  // 1000

    }
}
