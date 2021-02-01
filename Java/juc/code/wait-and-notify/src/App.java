import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Object> blockingQueue = new BlockingQueue<>(10);
        ExecutorService pool = Executors.newCachedThreadPool();

        // Producer
        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                try {
                    blockingQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Consumer
        for (int i = 0; i < 8; i++) {
            pool.execute(() -> {
                try {
                    blockingQueue.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();

    }
}
