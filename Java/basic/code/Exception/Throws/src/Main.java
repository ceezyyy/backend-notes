import java.io.File;
import java.io.FileNotFoundException;

/*
 * throws 关键字
 * 异常交给别人处理 我只负责声明异常
 * 最终还是 JVM 处理 -> 中断程序 停止运行
 * */


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        judgeAddress("a.txt");

    }


    // throws 声明异常 让方法调用者处理
    private static void judgeAddress(String fileName) throws FileNotFoundException {
        // 只有 Runtime Exception 不用理会 其他都需要解决
        if (!fileName.equals("a.txt")) {
            throw new FileNotFoundException("The file could not be found");
        }
        System.out.println("Everything is fine");
    }
}
