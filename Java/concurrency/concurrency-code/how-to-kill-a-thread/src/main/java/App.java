import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    // Use static keyword because
    // Non-static cannot be referenced from a static context
    static boolean flag = false;

    public static void main(String[] args) {

        new Thread(() -> {
            
        });

    }

}
