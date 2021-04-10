import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * ReentrantLock "可重入" 测试类
 * </p>
 *
 * @author ceezyyy
 * @since 2021/4/7
 */
@Slf4j
public class Reenter {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        /*
          main 线程的多个流程中能否获得同一把锁? 可以 -> 可重入锁
          这里的锁指的是 reentrantLock
         */
        try {
            reentrantLock.lock();
            log.info("I'm in main");
            method1();
        } finally {
            reentrantLock.unlock();
        }

    }

    public static void method1() {
        try {
            reentrantLock.lock();
            log.info("I'm in method1");
            method2();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void method2() {
        try {
            reentrantLock.lock();
            log.info("I'm in method2");
        } finally {
            reentrantLock.unlock();
        }
    }


}
