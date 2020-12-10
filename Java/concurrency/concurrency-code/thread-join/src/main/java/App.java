import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) throws InterruptedException {

        log.info(Thread.currentThread().getName() + " started");

        Thread t1 = new Thread(new JoinDemo(), "t1");
        t1.start();

        for (int i = 0; i < 2; i++) {
            log.info(Thread.currentThread().getName() + " " + i);
            if (i == 0) t1.join();
        }

        log.info(Thread.currentThread().getName() + " stopped");

    }

}