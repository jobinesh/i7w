package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;

/*
We can determine how "out of order" an array A is by counting the number of inversions it has.
Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j.
That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 */
public class ArrayInversionFinder {
    int findInversion(int[] src) {
        if (src == null || src.length <= 1) {
            return 0;
        }
        int mid = (src.length) / 2;
        int[] left = Arrays.copyOfRange(src, 0, mid);
        int[] right = Arrays.copyOfRange(src, mid, src.length);

        int inversions = findInversion(left) + findInversion(right) + merge(left, right);

        return inversions;
    }

    private int merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int inversions = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                i++;
            } else {
                inversions = inversions + left.length - i;
                j++;
            }
        }
        return inversions;
    }
    public static void main(String[] args){
        System.out.println( new ArrayInversionFinder().findInversion(new int[]{ 2, 4, 1, 3, 5}));
        System.out.println( new ArrayInversionFinder().findInversion(new int[]{ 5, 4, 3, 2, 1}));
    }
}
