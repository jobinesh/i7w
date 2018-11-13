/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.sort;

import java.util.Arrays;

/**
 *
 * @author jmpurush
 */
public class JBubbleSort {

    int[] array = null;

    public void sort(int[] array) {
        this.array = array;
        bubble();

    }

    private void bubble() {
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < array.length -1 - k; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }

    }

    public static void main(String[] arg) {
        int[] inputArrUnSorted = {3, 4, 13, 11, 77, 98, 5, 9, 18, 43};
        int[] inputArr = new int[inputArrUnSorted.length];
        System.arraycopy(inputArrUnSorted, 0, inputArr, 0, inputArrUnSorted.length);

        new JBubbleSort().sort(inputArr);

        System.out.println(Arrays.toString(inputArrUnSorted));
        System.out.println(Arrays.toString(inputArr));
    }
}
