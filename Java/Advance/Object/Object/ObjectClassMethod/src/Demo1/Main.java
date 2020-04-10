package Demo1;


import java.util.Objects;

/*
 * Object 类是 java.lang.Object
 * Objects 类是工具类 是 java.util.Objects里的
 * */

public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abC";
        String s3 = "abc";
        String s4 = null;
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
//        System.out.println(s4.equals(s1));  // NullPointerException

//        public static boolean equals(Object a, Object b) {
//            return a == b || a != null && a.equals(b);
//        }
        System.out.println(Objects.equals(s1, s4));  // false 不会报空指针异常
        System.out.println(Objects.equals(s1, s3));
    }


}


