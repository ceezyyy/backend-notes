package Demo1;


import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date);  // Date 类 重写了 toString 方法
        Date date1 = new Date(0L);
        System.out.println(date1);  // Thu Jan 01 08:00:00 CST 1970 东八区
    }

}




