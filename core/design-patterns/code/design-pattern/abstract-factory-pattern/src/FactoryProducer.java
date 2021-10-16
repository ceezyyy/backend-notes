/**
 * Factory Producer
 */
public class FactoryProducer {

    /**
     * Get abstract factory
     *
     * @param typeOfFactory
     * @return
     */
    public static AbstractFactory getFactory(String typeOfFactory) {
        if (typeOfFactory.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (typeOfFactory.equalsIgnoreCase("color")) {
            return new ColorFactory();
        } else {
            return null;
        }
    }

}
