import java.util.concurrent.atomic.AtomicInteger;

public class Resource {

    private static AtomicInteger ai = new AtomicInteger(0);

    public static AtomicInteger getAi() {
        return ai;
    }

    public void increase() {
        ai.getAndIncrement();
    }

}
