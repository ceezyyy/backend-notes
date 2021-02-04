public class ShapeFactory {

    public Shape getShape(String typeOfShape) {
        if (typeOfShape == null) {
            return null;
        }
        if (typeOfShape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (typeOfShape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } else if (typeOfShape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
