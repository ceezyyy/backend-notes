package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
