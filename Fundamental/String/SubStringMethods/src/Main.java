public class Main {

    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = str1.substring(6);  // return a new string

        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.substring(6, 11);
        System.out.println(str3);

    }
}
