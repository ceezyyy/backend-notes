import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    // Use static keyword because
    // Non-static cannot be referenced from a static context
    static Boolean flag = true;

    public static void main(String[] args) {

        log.info(Thread.currentThread().getName() + " started");

        new Thread(() -> {
            log.info(Thread.currentThread().getName() + " started");
            while (flag) {
                // Do nothing
//                log.info(Thread.currentThread().getName() + " is processing");
                System.out.println("xxx");
            }
            log.info(Thread.currentThread().getName() + " stopped");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
        log.info(Thread.currentThread().getName() + " stopped");

    }
}
