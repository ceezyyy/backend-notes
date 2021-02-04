import java.util.logging.Logger;

public class Orcs implements WeatherObserver {

    private static final Logger LOGGER = Logger.getLogger(Orcs.class.getName());

    @Override
    public void update(WeatherType weatherType) {
        LOGGER.info("Orcs are facing " + weatherType.getDescription() + " now!");
    }
}
