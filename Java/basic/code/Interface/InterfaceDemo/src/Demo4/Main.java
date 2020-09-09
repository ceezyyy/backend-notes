package Demo4;

/*
 * 1. implements 可以多个 extends 只能一个
 * 2. 对于 interface 共有的 abstract 方法, 只需 Override 一次
 * 3. 实现类必须 override 所实现 interface 的所有抽象方法
 * 4. 需要 override 冲突的 default 方法
 * 5. 继承优先于接口
 * */


public class Main {
    public static void main(String[] args) {
        InterfaceImpl impl = new InterfaceImpl();
        impl.methodA();
        impl.methodB();
        impl.method();
    }

}




