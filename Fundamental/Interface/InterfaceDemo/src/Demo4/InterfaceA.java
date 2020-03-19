package Demo4;

public interface InterfaceA {
    public abstract void methodA();

    public abstract void method();

    public default void methodDefault() {
        System.out.println("Default method");
    }
}
