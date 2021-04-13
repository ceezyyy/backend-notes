import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 自定义锁测试类 (不可重入)
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/11
 */
@Slf4j
public class App {
    public static void main(String[] args) {

        MyLock lock = new MyLock();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("I'm here");
                Thread.sleep(2000);
                log.info("Done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                log.info("I'm here");
                log.info("Done");
            } finally {
                lock.unlock();
            }
        }, "t2").start();

    }
}
