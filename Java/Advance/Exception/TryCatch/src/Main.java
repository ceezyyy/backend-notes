import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String address = "aa.txt";
        try {
            readFile(address);  // 编译异常
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.toString());
        }

    }

    private static void readFile(String address) throws IOException {
        if (address != "a.txt") {
            throw new IOException("文件格式错误");
        }
        System.out.println("Here is the file");
    }
}
