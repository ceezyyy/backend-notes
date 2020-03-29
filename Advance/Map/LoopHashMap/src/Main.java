import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("LBJ", 23);
        map.put("KOBE", 24);
        map.put("KD", 35);
        map.put("PAUL", 3);

        System.out.println(map.toString());
        System.out.println(map.containsKey("LBJ"));
        System.out.println(map.containsValue(11));
        System.out.println(map.get("PAUL"));

        // For loop key
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }

        // For loop Entry (k-V)
        Set<Map.Entry<String, Integer>> set1 = map.entrySet();
        for (Map.Entry<String, Integer> s : set1) {
            System.out.println(s);
        }

    }
}
