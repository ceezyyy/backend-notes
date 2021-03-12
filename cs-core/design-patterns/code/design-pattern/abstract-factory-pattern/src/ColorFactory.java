/**
 * Color factory
 */
public class ColorFactory implements AbstractFactory {
    @Override
    public Shape getShape(String typeOfShape) {
        return null;
    }

    /**
     * Get color
     *
     * @param typeOfColor
     * @return
     */
    @Override
    public Color getColor(String typeOfColor) {
        if (typeOfColor.equalsIgnoreCase("grey")) {
            return new Grey();
        } else if (typeOfColor.equalsIgnoreCase("green")) {
            return new Green();
        } else if (typeOfColor.equalsIgnoreCase("blue")) {
            return new Blue();
        } else {
            return null;
        }
    }
}
