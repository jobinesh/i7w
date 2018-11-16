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
public class JQuickSort {

    int[] array = null;

    public void sort(int[] array) {
        this.array = array;
        this.quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int heigh) {
        if (low < heigh) {
            int pivot = pivot(low, heigh);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, heigh);
        }
    }

    private int pivot11(int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private int pivot(int low, int high) {
        int pivot = high;
        int k = low - 1;
        for (int i = low; i < high; i++) {

            if (array[i] <= array[pivot]) {
                k++;
                int tmp = array[k];
                array[k] = array[i];
                array[i] = tmp;

            }
        }
        int tmp = array[k+1];
        array[k+1] = array[pivot];
        array[pivot] = tmp;
        pivot = k + 1;

        return pivot;
    }

    public static void main(String[] arg) {
        int[] inputArrUnSorted = {3, 4, 13, 11, 77, 98, 5, 9, 18, 43};
        int[] inputArr = new int[inputArrUnSorted.length];
        System.arraycopy(inputArrUnSorted, 0, inputArr, 0, inputArrUnSorted.length);

        new JQuickSort().sort(inputArr);

        System.out.println(Arrays.toString(inputArrUnSorted));
        System.out.println(Arrays.toString(inputArr));
    }
}
