package Demo1;


public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int result = getElement(array, 0);
        System.out.println(result);
    }

    private static int getElement(int[] originArray, int index) {
        return originArray[index];

    }
}



