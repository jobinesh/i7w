/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.prime;

/**
 *
 * @author Jobinesh
 */
public class NumberUtil {

    public static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i < number; i++) {
            if (i != number && number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
