/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.array;

import java.util.Arrays;

/**
 *
 * @author jmpurush
 */
public class Array17W {

    public static Object[] removeDuplicateElements(Object[] arrray) {
        Object[] clonedArray = Arrays.copyOf(arrray, arrray.length);
        int length = clonedArray.length;
        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                if (clonedArray[i] == clonedArray[k] && k != i) {
                    for (int j = i; j < arrray.length - 1; j++) {
                        clonedArray[j] = clonedArray[j + 1];
                    }
                    length--;
                }
            }

        }
        //for (int i = 0; i < length; i++) {
        //    System.out.println(arrray[i]);
        //}

        Object[] trimmedArray = Arrays.copyOfRange(clonedArray, 0, length);
        return trimmedArray;
    }

    public static void main(String[] arg) {
        Integer[] array = {11, 22, 3, 44, 11, 44, 55, 66, 66, 88, 99};
        Object[] trimmedArray = Array17W.removeDuplicateElements(array);
        System.out.println(Arrays.toString(trimmedArray));
    }
}
