package Demo4;

public interface InterfaceB {
    public abstract void methodB();

    public abstract void method();

    public default void methodDefault() {
        System.out.println("Default method");
    }
}
