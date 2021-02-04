/**
 * Abstract factory
 */
public interface AbstractFactory {

    // get shape through ShapeFactory
    Shape getShape(String typeOfShape);

    // get color through ColorFactory
    Color getColor(String typeOfColor);

}
