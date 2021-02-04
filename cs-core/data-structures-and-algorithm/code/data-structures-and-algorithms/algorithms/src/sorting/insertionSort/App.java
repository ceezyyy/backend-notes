package sorting.insertionSort;

import util.generator.ArrayGenerator;

public class App {

    public static void main(String[] args) {

        Integer[] test = ArrayGenerator.autogenerate(50);

        InsertionSort.sort(test);

        for (Integer i : test) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
