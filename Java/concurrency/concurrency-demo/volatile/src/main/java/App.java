/**
 * <p>
 *
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/9
 */
public class App {
    public static void main(String[] args) {

        VolatileDemo demo = new VolatileDemo();

        new Thread(() -> {
            demo.writer();
        }, "t2").start();

        new Thread(() -> {
            demo.reader();
        }, "t1").start();


    }
}
