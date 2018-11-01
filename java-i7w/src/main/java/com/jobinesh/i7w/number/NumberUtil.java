/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.number;

import java.util.ArrayList;

/**
 *
 * @author jmpurush
 */
public class NumberUtil {

    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int armstrong = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            number = number/10;
            armstrong = armstrong + (int)Math.pow(currentDigit, 3);
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
        System.out.println(NumberUtil.isArmstrong(371));

    }
}
