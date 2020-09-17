import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
        });

        log.info(t1.getState().toString());
    }
}
