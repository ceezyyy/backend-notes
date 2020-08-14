public class SingletonPatternDemo {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);

    }

}
