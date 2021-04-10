import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 使用 wait-notify 机制实现线程顺序打印
 * e.g 先打印 a 后打印 b
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/8
 */
@Slf4j
public class SequentialOutput {

    private final static Object LOCK = new Object();

    private static boolean first = true;

    public static void main(String[] args) {

        // b 后打印
        new Thread(() -> {
            synchronized (LOCK) {
                while (first) {
                    try {
                        LOCK.wait();
                        log.info("Waiting...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("b");
            }
        }, "THREAD_B").start();

        // a 先打印
        new Thread(() -> {
            synchronized (LOCK) {
                log.info("a");
                first = false;
                LOCK.notifyAll();
            }
        }, "THREAD_A").start();

    }
}
