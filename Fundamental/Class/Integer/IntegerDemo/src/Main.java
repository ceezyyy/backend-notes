public class Main {
    /*
     * 装箱: 基本数据类型 转化成为 对应的包装类型
     * 拆箱: 包装类型 转化成为 基本数据类型
     *
     * 自动装箱 自动拆箱
     * */


    public static void main(String[] args) {
//        Integer num1 = new Integer(100);  // 方法过时
//        System.out.println(num1);  // 重写了toString方法
//        Integer num2 = new Integer("100000");  // 方法过时
//        System.out.println(num2);

        Integer num3 = Integer.valueOf(200);
        Integer num4 = Integer.valueOf("3000");

        System.out.println(num3);
        System.out.println(num4);

    }
}
