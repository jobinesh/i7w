/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.sort;

import java.util.Arrays;

/**
 *
 * @author Jobinesh
 */
public class JInsertionSort {

    int[] array = null;

    public void sort(int[] array) {
        this.array = array;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int slot = i;
            for (int j = i - 1; j >= 0; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    slot = j;
                }
            }
            if (slot != i) {
                array[slot] = key;
            }
        }
    }

    public void sortOptimizedLoop(int[] array) {
        this.array = array;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (array[j] > key && j >= 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

        }
    }

    public static void main(String[] arg) {
        int[] inputArrUnSorted = {3, 4, 13, 11, 77, 98, 5, 9, 18, 43};
        int[] inputArr = new int[inputArrUnSorted.length];
        System.arraycopy(inputArrUnSorted, 0, inputArr, 0, inputArrUnSorted.length);

        new JInsertionSort().sortOptimizedLoop(inputArr);

        System.out.println(Arrays.toString(inputArrUnSorted));
        System.out.println(Arrays.toString(inputArr));
    }
}
