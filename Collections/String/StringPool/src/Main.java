public class Main {

    public static void main(String[] args) {
        String string = "abc";
        String string1 = "abc";
        String string2 = new String("abc");

        System.out.println(string == string1);  // true
        System.out.println(string == string2);  // false
        System.out.println(string1 == string2);  // false

    }
}
