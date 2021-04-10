import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * volatile 关键字保证内存可见性
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/9
 */
@Slf4j
public class VolatileDemo {

    private int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) log.info(String.valueOf(a));
    }

}
