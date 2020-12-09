import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread implements Runnable {

    private volatile boolean flag;

    public void start() {
        flag = true;
        new Thread(this).start();
    }

    public void stop() {
        flag = false;
    }

    public void run() {
        while (flag) {
            try {
                log.info(Thread.currentThread().getName() + " is processing!");
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info(Thread.currentThread().getName() + " is interrupted!");
            }
        }
    }
}
