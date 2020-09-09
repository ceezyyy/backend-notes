
public class NewPhone extends Phone {
    int num = 20;

    @Override
    public void show() {
        super.show();
        System.out.println("This is profile");
        System.out.println("This is name");
    }

    public void showNum() {
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);
    }

    public void methodA() {
        System.out.println("AAA");
    }

    public void methodB() {
        this.methodA();
        System.out.println("BBB");
    }
}

