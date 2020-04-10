package Demo1;


public class Main {
    public static void main(String[] args) {
        Father object = new Son();  // new 谁 就调用谁
        object.method();
        System.out.println(object.num);
    }
}



