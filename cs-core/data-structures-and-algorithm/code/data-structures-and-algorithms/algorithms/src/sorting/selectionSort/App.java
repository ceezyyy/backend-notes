package sorting.selectionSort;

import util.generator.ArrayGenerator;

public class App {
    public static void main(String[] args) {

        Integer[] test = ArrayGenerator.autogenerate(20);

        SelectionSort.sort(test);

        for (Integer i : test) {
            System.out.println(i);
        }

    }
}
