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
public class JPMergeSort {
    
    int[] array = null;
    
    public void sort(int[] array) {
        this.array = array;
        this.mergeSort(0, array.length - 1);
    }
    
    public void mergeSort(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            doMerge(low, mid, mid + 1, high);
        }
    }
    
    public void doMerge(int low1, int high1, int low2, int high2) {
        int[] tmpArray = new int[array.length];
        System.arraycopy(array, low1, tmpArray, low1, (high2 - low1) + 1);
        int i = low1;
        int j = low2;
        int k = low1;
        System.out.println(low1 + " - " + high1 + " : " + low2 + " - " + high2);
        while (i <= high1 && j <= high2) {
            if (tmpArray[i] <= tmpArray[j]) {
                array[k] = tmpArray[i];
                i++;
            } else {
                array[k] = tmpArray[j];
                j++;
            }
            k++;
        }
          System.out.println(i +  " i -high1 " + high1 + " : " + j + " j - high2 " + high2);
        while (i <= high1) {
            array[k] = tmpArray[i];
            i++;
            k++;
        }
        while (j <= high2) {
            array[k] = tmpArray[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] arg) {
        int[] inputArr1 = {3, 4, 11, 11, 77, 98, 4, 8, 8, 43};
        int[] inputArr = {3, 4, 11, 11, 77, 98, 4, 8, 8, 43};
        
        new JPMergeSort().sort(inputArr);
         
        System.out.println(Arrays.toString(inputArr1));
        System.out.println(Arrays.toString(inputArr));
    }
}
