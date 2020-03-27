package HashSetPack;


/* 哈希值
 * 十进制整数, 由系统随机给出
 * Object类中的 hashCode()方法可获取对象的哈希值 (逻辑值 不是地址值)
 * 源码
 * public native int hashCode();
 * native 方法代表调用本地操作系统的方法public native int hashCode();
 * */

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        int num1 = p1.hashCode();
        int num2 = p2.hashCode();

        // String.toString() 源码
        //  public String toString() {
        //        return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
        //    }

        System.out.println(num1);
        System.out.println(num2);

        System.out.println(p1);  // Hex 16 进制
        System.out.println(p2);

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);
    }
}



