import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            log.info("t1 " + i);
        }
    }
}
