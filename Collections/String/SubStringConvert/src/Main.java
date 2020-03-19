public class Main {

    public static void main(String[] args) {
        /* String to Char Array */
        char[] charArray = "Hello World".toCharArray();
        System.out.println(charArray);

        System.out.println(charArray[1]);
        System.out.println(charArray.length);

        /* String to Byte Array */
        byte[] byteArray = "Hello World".getBytes();
        System.out.println(byteArray);
        for (int i = 0; i < byteArray.length; i++) {
            System.out.println(byteArray[i]);
        }

        /* Replace */
        String str = "How are you";
        String str1 = str.replace("o", "*");  // return a new string
        System.out.println(str1);

    }
}
