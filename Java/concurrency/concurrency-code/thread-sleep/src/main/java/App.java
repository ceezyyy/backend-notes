import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private static Integer countdown = 10;

    public static void main(String[] args) {

        new Thread(() -> {
            while (countdown >= 0) {
                try {
                    log.info(countdown.toString());
                    countdown--;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
