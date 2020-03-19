package Demo5;

public interface InterfaceB {
    public abstract void methodB();

    public default void method() {
        System.out.println("BB");
    }
}
