import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        Object cloneList = arrayList.clone();

        System.out.println(cloneList == arrayList);  // false

        System.out.println(cloneList);  // [1, 2]
        System.out.println(arrayList);  // [1, 2]
    }
}
