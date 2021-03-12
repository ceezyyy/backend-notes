public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        // lazy loading
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
