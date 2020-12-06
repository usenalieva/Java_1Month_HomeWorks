package com.makhabatusen;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    /* MAIN TASK:
    Create an array of fractional (non-integer) numbers of 15 elements and fill it with
    positive and negative numbers;
    Then, through the “for each” loop, calculate the arithmetic mean of positive numbers located after the first
    negative number and display it */


        double[] fractions = new double[]{
                4.6, -5.7, 8.6, 4.7, -1.4, 3.8, 9.5, -4.9,
                2.9, 16.7, -4.9, -4.4, 4.7, 4.5, 5.3};

        boolean firstNegativeNum = false;

        double sum = 0;
        int count = 0;
        double result;

        for (double a : fractions) {
            if (!firstNegativeNum && a < 0) {
                firstNegativeNum = true;
                continue;
            }
            if (firstNegativeNum && a > 0) {
                sum += a;
                count++;
            }

        }
        result = sum / count;
        System.out.println("After first negative number:" +
                "\nTotal sum of positive numbers is " + sum +
                "\nThe length of positive numbers is " + count +
                "\nThe arithmetic mean is " + result);


        /* ADDITIONAL TASK:
    You need to write the following ascending sorting algorithm: select each iteration
    the smallest element and offset it to the beginning. At the same time, each new iteration
    starts moving to the right, that is, the second pass - from the second, etc.
    And on each iteration, print out the current state of the array */

        System.out.println("__________");

        double[] fractions2 = new double[]{
                4.6, -54.7, 82.6, 4.73, -1.4, 3.8, 9.5, -478.9,
                2.9, 16.7, -4.9, -4.4, 467.7, 48.5, 5.3};

        for (var i = 0; i < fractions2.length; i++) {
            double least = fractions2[i];
            var a = i - 1;
            while (a >= 0 && least < fractions2[a]) {
                fractions2[a + 1] = fractions2[a];
                a--;
                fractions2[a + 1] = least;
            }

            System.out.println(Arrays.toString(fractions2));
        }

    }
}


