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

    public static boolean equals(Object[] array1, Object array2[]) {
        if (array1.length != array2.length) {
            return false;
        }
        int length = array1.length / 2;

        int index = 0;
        while (index < length / 2) {
            if (!array1[index].equals(array2[index])) {
                return false;
            }
            if (!array1[length - index].equals(array2[length - index])) {
                return false;
            }
            index++;
        }
        return true;
    }

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
        Integer[] array1 = {11, 22, 3, 44, 11, 3, 4, 4, 33, 55, 66, 66, 88, 99};
        Integer[] array2 = {11, 22, 3, 44, 11, 3, 4, 5, 33, 55, 66, 66, 88, 99};

        //Object[] trimmedArray = Array17W.removeDuplicateElements(array);
        System.out.println(Array17W.equals(array1, array2));
    }
}
