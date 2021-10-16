import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Subject: Weather
 */
public class Weather implements Subject {

    private static final Logger LOGGER = Logger.getLogger(Weather.class.getName());

    private WeatherType currentWeatherType;
    private List<WeatherObserver> observers;

    public Weather() {
        currentWeatherType = WeatherType.RAINY;
        observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add((WeatherObserver) observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(currentWeatherType);
        }
    }

    public void timePass() {

        WeatherType[] weatherTypes = WeatherType.values();

        // simulate weather changes
        currentWeatherType = weatherTypes[(currentWeatherType.ordinal() + 1) % weatherTypes.length];

        LOGGER.info("Weather have changed to " + currentWeatherType);

        notifyObservers();
    }

}
