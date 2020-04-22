package Demo1;


import org.junit.Test;

import java.io.*;

public class Demo1 {

    // FileOutputStream

    @Test
    public void test1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt", false);
        byte[] bytes = "ABCDE".getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }


    @Test
    public void test2() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt", true);
        for (int i = 0; i < 5; i++) {
            fileOutputStream.write("加油".getBytes());
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }

    @Test
    public void test4() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("a.txt");

        byte[] bytes = new byte[1024];

        // Total length
        int length = 0;

        // Current length
        int temp = 0;
        while ((temp = fileInputStream.read(bytes)) != -1) {
            System.out.println(temp);
            length += temp;
        }

        fileInputStream.close();

        System.out.println(new String(bytes, 0, length));
    }

    @Test
    public void test5() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("a.txt");
            fileWriter.write("Be humble Sit down");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test6() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("a.txt");
            char[] chars = new char[1024];
            fileReader.read(chars);
            System.out.println(new String(chars).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}



