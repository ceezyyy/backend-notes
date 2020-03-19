package com.ceezyyy;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;


public class Main {

    public static void main(String[] args) {
        /*
         * Primitive and Reference
         */
        byte age = 30;
        Date now = new Date();
        System.out.println(now);
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(x);
        System.out.println(y);
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 100;
        System.out.println(point2);
        /*
         * String
         */
        String message = "    Hello World   " + "!!";
        System.out.println(message.endsWith("!!"));
        System.out.println(message.startsWith("sadf"));
        System.out.println(message.length());
        System.out.println(message.indexOf("H"));
        System.out.println(message.indexOf("sky"));
        System.out.println(message.replace("!!", "??"));
        // return new string object, string in Java cannot be modified
        System.out.println(message);
        System.out.println(message.toLowerCase());
        // get rid of the white spaces at the beginning or the end of the string
        System.out.println(message.trim());
        String message1 = "Hello \"Yi\"";
        String message2 = "C:\\Java\\...";
        System.out.println(message1);
        System.out.println(message2);
        /*
         * 1D array
         */
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers));  // fixed length
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        /*
         * 2D array
         */
        int[][] numbers1 = new int[3][3];
        numbers1[0][0] = 1;
        System.out.println(Arrays.toString(numbers1));
        System.out.println(Arrays.deepToString(numbers1));
        /*
         * Constant
         */
        final float PI = 3.14f;
        System.out.println(PI);
        /*
         * Integer and float
         */
        int result = 10 / 3;
        double res = (double) 10 / (double) 3;
        double res1 = 10.0 / 3.0;
        System.out.println(res1);
        int x = 1;
        int y = x++;
        int z = ++y;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        /*
         * byte < short < int < long < float < double
         */
        String x = "1";
        int y = Integer.parseInt(x) + 100;
        String m = "1.111111";
        double n = Double.parseDouble(m);
        System.out.println(y);
        System.out.println(n);
        /*
         * Math
         */
        int result = Math.round(2.22f);
        double result = Math.random();
        System.out.println(result);
        /*
         * Number Format
         */
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(12345678.98888);
        System.out.println(result);
        String result = NumberFormat.getPercentInstance().format(0.12);
        System.out.println(result);
    }
}
