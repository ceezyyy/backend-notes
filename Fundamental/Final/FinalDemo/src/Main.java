public class Main {
    /*
     * final
     * 对于基本类型的变量 final 变量的数值不可改变
     * 对于引用类型的变量 final 变量的地址值不可改变
     * */

    public static void main(String[] args) {
        Son son = new Son();
        son.method();
        final int num = 10;
//        num = 10;
        final int num1;
        num1 = 100;
        final Star star = new Star("LBJ");
        System.out.println(star.getName());
        star.setName("AD");
        System.out.println(star.getName());
    }
}
