public enum WeatherType {
    SUNNY("sunny"),
    RAINY("rainy"),
    WINDY("windy"),
    COLD("rainy");

    private final String description;

    WeatherType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
