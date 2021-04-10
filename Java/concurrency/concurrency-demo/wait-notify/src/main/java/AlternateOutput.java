import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 使用 wait-notify 机制实现线程交替打印
 * e.g 输出 a, b, c, a, b, c, a, b, c
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/8
 */
@Slf4j
public class AlternateOutput {


    public static void main(String[] args) {

        WaitNotify waitNotify = new WaitNotify(1, 5);

        new Thread(() -> {
            waitNotify.print(1, 1, 2);
        }, "a").start();

        new Thread(() -> {
            waitNotify.print(2, 2, 3);
        }, "b").start();

        new Thread(() -> {
            waitNotify.print(3, 3, 1);
        }, "c").start();

    }
}
