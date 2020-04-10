
public class MyClass {

    int num;
    static int numStatic;

    public void method() {
        System.out.println("This is a normal method");
        System.out.println(num);
        System.out.println(numStatic);
    }

    /* static method cannot use "this"
     * object.this
     * */
    public static void methodStatic() {
        System.out.println("This is a static method");
        System.out.println(numStatic);

    }
}
