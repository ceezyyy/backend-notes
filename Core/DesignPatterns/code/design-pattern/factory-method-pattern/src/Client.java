public class Client {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");  // Circle here!
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");  // Rectangle here!
        rectangle.draw();

        Shape triangle = shapeFactory.getShape("triangle");  // Triangle here!
        triangle.draw();

    }

}
