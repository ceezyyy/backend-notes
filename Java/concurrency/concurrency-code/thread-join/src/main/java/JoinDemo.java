import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinDemo implements Runnable {
    @Override
    public void run() {
        log.info(Thread.currentThread().getName() + " started");
        for (int i = 0; i < 5; i++) {
            log.info(Thread.currentThread().getName() + " " + i);
        }
        log.info(Thread.currentThread().getName() + " stopped");
    }
}
