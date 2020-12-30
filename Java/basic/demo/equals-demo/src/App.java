public class App {
    public static void main(String[] args) {
        Money m1 = new Money(88, "USD");
        Money m2 = new Money(88, "USD");
        System.out.println(m1.equals(m2));  // true
    }
}
