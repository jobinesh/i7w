/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.number;

import java.util.Arrays;

/**
 *
 * @author jmpurush
 */
public class NumberUtil {

    public static long squareRootOf(long number) {
        long mid = 1;
        long start = 1;
        long end = number;
        while (start < end) {
            mid = Math.floorDiv((start + end), 2);
            long square = mid * mid;
            if (square == number) {
                break;
            } else if (square > number) {
                end = mid - 1;
            } else if (square < number) {
                start = mid + 1;
            }

        }
        return mid;
    }

    public static Object[] generateFizzBuzzArray(int number) {
        Object[] fizbuz = new Object[number];
        boolean multiplesOf3 = false;
        boolean multiplesOf5 = false;
        boolean multiplesOf3N5 = false;
        for (int i = 0; i < number; i++) {
            multiplesOf3 = (i % 3 == 0);
            multiplesOf5 = (i % 5 == 0);
            multiplesOf3N5 = (multiplesOf3 && multiplesOf5);
            if (multiplesOf3N5) {
                fizbuz[i] = "fizzbuzz";
            } else if (multiplesOf3) {
                fizbuz[i] = "fizz";
            } else if (multiplesOf5) {
                fizbuz[i] = "buzz";
            } else {
                fizbuz[i] = i;
            }
        }
        return fizbuz;
    }

    public static long reverseNumber(long number) {
        long reversed = 0;
        int cnt = 1;
        while (number > 0) {
            reversed = (reversed * 10) + number % 10;
            number = number / 10;
            cnt++;
        }
        return reversed;

    }

    public static long findFctorial(int number) {
        long factorial = 1;
        for (int i = 1; i < number; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int armstrong = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            number = number / 10;
            armstrong = armstrong + (int) Math.pow(currentDigit, 3);
        }

        return armstrong == originalNumber;
    }

    public static boolean isPalindrome(int number) {

        int originalValue = number;
        int reverse = 0;
        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return originalValue == reverse;
    }

    public static void main(String[] arg) {
        NumberUtil t=null;
        System.out.println(Arrays.toString(t.generateFizzBuzzArray(50)));

    }
}
