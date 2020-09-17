import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {

        // Create a new thread
        Thread t1 = new Thread(() -> {
            log.info("The name of current threadGroup: {}", Thread.currentThread().getThreadGroup().getName());
            log.info("The name of current thread: {}", Thread.currentThread().getName());
        });

        // Start the thread
        t1.start();

        log.info("The name of main threadGroup: {}", Thread.currentThread().getName());
        log.info("The name of main thread: {}", Thread.currentThread().getName());

    }
}
