import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 自定义线程池测试类
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/10
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5, 3, 2000, TimeUnit.MILLISECONDS);
        // 模拟并发环境
        for (int i = 0; i < 100000; i++) {
            int j = i;
            threadPool.execute(new Thread(() -> {
                log.info("I'm task {}", j);
            }, "THREAD_" + i));
        }
    }
}
