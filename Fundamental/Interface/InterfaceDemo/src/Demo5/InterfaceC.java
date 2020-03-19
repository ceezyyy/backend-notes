package Demo5;

public interface InterfaceC extends InterfaceA, InterfaceB {
    public abstract void methodC();

    // 父接口 default 方法重复 子接口 必须 override
    @Override
    default void method() {
        System.out.println("Method");
    }
}
