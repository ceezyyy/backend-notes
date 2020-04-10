public class Main {

    public static void main(String[] args) {
        String str = "apple,banana,orange,strawberry";
        String[] stringArray = str.split(",");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        str = "apple banana orange strawberry";
        stringArray = str.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        str = "apple.banana.orange.strawberry";
        stringArray = str.split("\\.");  // regular expression
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }
}
