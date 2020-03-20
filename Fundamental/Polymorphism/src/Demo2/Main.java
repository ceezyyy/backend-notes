package Demo2;

/*
 * 成员方法: 编译看左边, 运行看右边
 * 成员变量: 编译看左边, 运行还看左边
 * */


public class Main {
    public static void main(String[] args) {
        Father object = new Son();
        System.out.println(object.age);
        object.method();
        object.methodFather();
//        object.methodSon();
    }
}



