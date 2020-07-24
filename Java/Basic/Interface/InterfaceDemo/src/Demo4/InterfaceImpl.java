package Demo4;


public class InterfaceImpl implements InterfaceA, InterfaceB {

    @Override
    public void methodDefault() {
        System.out.println("Override default method");
    }

    @Override
    public void methodA() {
        System.out.println("Override methodA");
    }

    @Override
    public void method() {
        System.out.println("Override method");

    }

    @Override
    public void methodB() {
        System.out.println("Override methodB");

    }
}


