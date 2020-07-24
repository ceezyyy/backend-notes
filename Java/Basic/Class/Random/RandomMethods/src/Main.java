import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(10);
            System.out.println(num);
        }
    }
}
