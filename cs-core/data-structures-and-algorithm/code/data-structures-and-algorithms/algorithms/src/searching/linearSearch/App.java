package searching.linearSearch;

import util.generator.ArrayGenerator;

public class App {
    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.autogenerate(100);
        int testOne = LinearSearch.search(data, 88);
        int testTwo = LinearSearch.search(data, 10000);
        System.out.println(testOne);
        System.out.println(testTwo);
    }
}
