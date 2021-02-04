/**
 * Observer: Weather observer
 */
public interface WeatherObserver extends Observer {
    /**
     * update weather type
     *
     * @param weatherType
     */
    void update(WeatherType weatherType);
}
