import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class App {

    public static void main(String[] args) {

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("t1 here!");
                Thread.sleep(2000);
                return 100;
            }
        });

        new Thread(futureTask, "t1").start();
        log.info("main here!");

        try {
            log.info(String.valueOf(futureTask.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
