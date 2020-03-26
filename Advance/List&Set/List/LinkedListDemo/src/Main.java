import java.util.LinkedList;

public class Main {

    /* Linked-list 底层是链表
     * 特点
     * 1. 查询慢，增删快
     * 2. 包含大量首尾操作的方法
     * 使用 linked-list 特有的方法不能使用多态
     * */


    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("LBJ");
        linkedList.add("AD");
        linkedList.add("GOAT");
        System.out.println(linkedList);  // 重写了 toString 方法

        LinkedList<String> linkedList1 = linkedList;
        System.out.println(linkedList == linkedList1);  // 引用类型 指向同一地址

        linkedList1.add("KUZ");
        System.out.println(linkedList1);
        System.out.println(linkedList);
        System.out.println(linkedList == linkedList1);

        linkedList.addFirst("FIRST");
        System.out.println(linkedList1);

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList1.getLast());

        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.pop();  // pop() == removeFirst()
        System.out.println(linkedList);

    }
}
