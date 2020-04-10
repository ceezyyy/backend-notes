package Demo5;

/*
 * 1. 类之间是单继承的, 只能 extends 一个父类
 * 2. 类与接口是多继承的, 一个 class 可以 implements 多个 interface
 * 3. 接口与接口之间是多继承的, 一个 interface 可以 extends 多个 interface
 *
 * P.S:
 * abstract 方法冲突不要紧 在实现类 override 就好
 * default 方法冲突就必须得 override
 * */


public class Main {
    public static void main(String[] args) {
        InterfaceImpl impl = new InterfaceImpl();
        impl.methodA();
        impl.methodB();
        impl.methodC();
        impl.method();

    }
}




