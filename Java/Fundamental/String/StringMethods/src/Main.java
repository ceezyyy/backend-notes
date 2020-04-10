public class Main {

    public static void main(String[] args) {
        /* Create String 3 + 1 methods */

        /* first method */
        String str1 = new String("First");
        System.out.println(str1);

        /* second method */
        char[] chars = {'A', 'B', 'C'};
        String str2 = new String(chars);
        System.out.println(str2);

        /* third method */
        byte[] bytes = {97, 98, 99};
        String str3 = new String(bytes);
        System.out.println(str3);

        /* fourth method */
        String str4 = "Fourth method";
        System.out.println(str4);

        String str5 = "abc";
        String str6 = "abc";

        char[] charArray = {'a', 'b', 'c'};
        String str7 = new String(charArray);
        System.out.println(str5);
        System.out.println(str6);
        System.out.println(str7);

        // compare
        System.out.println(str5 == str6);  // true
        System.out.println(str5 == str7);  // false
        System.out.println(str6 == str7);  // false


    }
}
