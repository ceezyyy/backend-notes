import java.util.Objects;

public class Main {

    /* Throw 关键字
     * 1. 必须在方法内部
     * 2. new Exception 类 或者 Exception 的 子类
     * 3. 对于异常 我们需进行处理
     *
     * */

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        array = null;
        int result = getElement(array, 1);
        System.out.println(result);

    }

    private static int getElement(int[] array, int index) {
        // Objects.requireNonNull(Obj o) -> 简化代码
        Objects.requireNonNull(array, "传入参数需非空");

        // 需要对参数进行判断 过滤掉“不符合逻辑”的参数
        if (array == null) {
            throw new NullPointerException("数组为空！");
        }
        if (index < 0 || index > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("index越界");
        }
        return array[index];
    }
}
