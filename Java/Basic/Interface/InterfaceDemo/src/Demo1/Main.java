package Demo1;

/*
 * 1. interface 的 default 方法可以被实现类直接调用
 * 2. 实现类可以 override interface 的 default 方法
 * */

public class Main {
    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();  // 实现类
        myInterface.methodAbs();

        MyInterfaceDefaultA defaultA = new MyInterfaceDefaultA();
        defaultA.method1();
        defaultA.method2();  // default method of interface

        MyInterfaceDefaultB defaultB = new MyInterfaceDefaultB();
        defaultB.method1();
        defaultB.method2();  // default method of interface

    }
}


