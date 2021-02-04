import java.util.logging.Logger;

public class Hobbits implements WeatherObserver {

    private static final Logger LOGGER = Logger.getLogger(Hobbits.class.getName());

    @Override
    public void update(WeatherType weatherType) {
        LOGGER.info("Hobbits are facing " + weatherType.getDescription() + " now!");
    }
}
