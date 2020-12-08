import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        for (int i = 0; i < 5; i++) {
            log.info("main " + i);
        }

    }
}
