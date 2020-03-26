import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    /*
     * List 接口 继承了 Collection 接口
     *
     * 三大特点：
     * 1. 有序的集合
     * 2. 有索引 包含了有索引的方法
     * 3. 允许重复元素
     *
     * */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();  // 多态
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("a");
        System.out.println(list);  // 重写了 toString 方法

        list.add(0, "a");
        System.out.println(list);

        list.remove(list.size() - 1);
        System.out.println(list);

        list.set(list.size() - 1, "E");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String string : list) {
            System.out.println(string);
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }


    }
}
