public class Main {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        // == -> compare address
        // .equals() -> compare content
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

        String str4 = new String("Hello");
        System.out.println(str4.equals(str1));

        /* Attention */
        String str5 = null;
        System.out.println(str5.equals("abc"));  // NullPointerException
        System.out.println("abc".equals(str5));  // false
    }
}
