/**
 * Client
 */
public class Client {
    public static void main(String[] args) {

        AbstractFactory shape = FactoryProducer.getFactory("shape");
        Shape circle = shape.getShape("circle");
        circle.draw();  // Drawing circle

        AbstractFactory color = FactoryProducer.getFactory("color");
        Color green = color.getColor("green");
        green.fill();  // Filling green

    }

}
