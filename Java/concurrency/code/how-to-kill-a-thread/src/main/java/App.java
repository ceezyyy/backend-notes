import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();
        log.info("t1 started processing!");

        for (int i = 0; i < 100; i++) {
            log.info(Thread.currentThread().getName() + " is running!");
            if (i == 50) t1.stop();
        }

    }
}
