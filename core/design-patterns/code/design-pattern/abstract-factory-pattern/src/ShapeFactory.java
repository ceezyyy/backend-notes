/**
 * Shape factory
 */
public class ShapeFactory implements AbstractFactory {

    /**
     * Get shape
     *
     * @param typeOfShape
     * @return
     */
    @Override
    public Shape getShape(String typeOfShape) {
        if (typeOfShape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (typeOfShape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (typeOfShape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } else {
            return null;
        }
    }

    @Override
    public Color getColor(String typeOfColor) {
        return null;
    }
}
