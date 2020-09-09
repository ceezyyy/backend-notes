package Demo1;

/*
 * 接口当中的default方法可解决接口升级问题
 * */
public interface MyInterfaceDefault {
    public abstract void method1();

    public default void method2() {
        System.out.println("This is default method");
    }
}


