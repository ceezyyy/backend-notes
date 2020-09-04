import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        // 在第一次调用 put 方法时创建数组
        Map<String, Integer> map = new HashMap<>();

        // 根据 key 调用 hashCode 方法计算出哈希值 结合数组长度计算出存储空间的索引值
        map.put("LBJ", 23);
    }
}
