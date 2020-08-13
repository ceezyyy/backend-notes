public class UniverseBus extends Bus implements Transport {
    @Override
    public void transport() {
        System.out.println("Universe bus here!");
        System.out.println("Running on the road");
    }

    public void fly() {
        System.out.println("I can fly");
    }
}
