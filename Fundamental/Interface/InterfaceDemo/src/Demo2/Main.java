package Demo2;

/*
 * 不能通过接口实现类的对象来调用 interface 的 static 方法
 * 直接通过 interface 调用 (与之前 通过类调用十分类似)
 * */


public class Main {
    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        System.out.println(myInterface.NUM);
        MyInterfaceStatic.method();
        System.out.println();

    }
}




