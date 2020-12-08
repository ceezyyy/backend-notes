import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        for (int i = 0; i < 5; i++) {
            log.info("main " + i);
        }

    }
}
