import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            log.info("t1 here!");
        };

        Thread t1 = new Thread(r1, "t1");
        t1.start();

        log.info("main here!");
    }

}
