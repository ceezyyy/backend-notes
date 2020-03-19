
public class Teacher extends Employee {
    int num = 200;

    public void method() {
        int num = 300;
        System.out.println(num);  // 300
        System.out.println(this.num);  // 200
        System.out.println(super.num);  // 100
    }
}

