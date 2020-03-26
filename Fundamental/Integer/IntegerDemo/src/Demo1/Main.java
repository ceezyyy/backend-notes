package Demo1;

/*
 * String 与 基本类型 互换
 * */


public class Main {
    public static void main(String[] args) {
        // 第一种方法 +""
        int num = 1;
        String numString = num + "";  // 整数 -> String
        System.out.println(num + 1);  // 整数相加
        System.out.println(numString + 1);  // 字符串相连

        // 第二种方法 包装类 static 方法 toString(param)
        String numString1 = Integer.toString(num);
        System.out.println(numString1 + 200);  // 字符串相连

        // 第三种方法 String类 static 方法 String.valueOf(param)
        String numString2 = String.valueOf(num);
        System.out.println(numString2 + 300);  // 字符串相连


        int num1 = Integer.parseInt(numString2);
        double num2 = Double.parseDouble(numString2);
        System.out.println(num1 + 1);  // 2 整数相加
        System.out.println(num2);

    }
}


