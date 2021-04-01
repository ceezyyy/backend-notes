import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 创建与运行线程
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/1
 */
@Slf4j
public class App {
    public static void main(String[] args) {

        /*
          Create a new thread
         */
        Thread t1 = new Thread(() -> {
            log.info("running");
        }, "t1");

        /*
          Start thread
         */
        t1.start();

        log.info("running");

    }
}
