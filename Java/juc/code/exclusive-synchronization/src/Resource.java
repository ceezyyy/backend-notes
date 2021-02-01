public class Resource {

    public void func() {
        synchronized (this.getClass()) {
            for (int i = 0; i < 20; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
