import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    /**
     * Program entry point
     *
     * @param args
     */
    public static void main(String[] args) {

        Weather weather = new Weather();
        weather.registerObserver(new Hobbits());
        weather.registerObserver(new Orcs());

        weather.timePass();
        weather.timePass();

    }

}
