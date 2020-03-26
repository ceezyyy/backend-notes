public class Main {

    public static void main(String[] args) {
        /* the length of the string */
        int num = "Hello WorldHello WorldHello WorldHello WorldHello WorldHello WorldHello World".length();
        System.out.println(num);

        /* add strings together */
        String string = "Hello World".concat("!");
        System.out.println(string);

        /* get the specific character in string by index */
        System.out.println("Hello World".charAt(1));

        /* get the first match index of the substring */
        System.out.println("Hello World".indexOf("Wor"));  // white-space is considered as one character
    }
}
