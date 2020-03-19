package Demo5;

public interface InterfaceA {
    public abstract void methodA();

    public default void method() {
        System.out.println("AA");
    }
}
