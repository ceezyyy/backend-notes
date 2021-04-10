import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/3
 */
@Slf4j
public class App {
    public static void main(String[] args) {

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter1.increase();
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter2.decrease();
            }
        }, "t2").start();

        try {
            Thread.sleep(1000);
            log.info("Counter1: " + counter1.getCounter());
            log.info("Counter2: " + counter2.getCounter());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
