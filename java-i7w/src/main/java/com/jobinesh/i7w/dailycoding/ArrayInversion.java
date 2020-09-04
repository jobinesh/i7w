package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;

/*
We can determine how "out of order" an array A is by counting the number of inversions it has.
Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j.
That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 */
public class ArrayInversion {
    long merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }

    long invCount(int[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        int left[] = Arrays.copyOfRange(arr, 0, m);
        int right[] = Arrays.copyOfRange(arr, m, arr.length);

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }
    public int mergeSortWithInversions(int[] src){
        if( src.length == 0){
            return 0;
        }
        int mid = src.length/2;
        int[] src1= Arrays.copyOfRange(src,0, mid );
        int[] src2= Arrays.copyOfRange(src,mid, src.length );
        int inver1 = mergeSortWithInversions(src1);
        int inver2 = mergeSortWithInversions(src2);
        int inver0 = 0;
        int i=0;
        int j=0;
        //int k=0;
       // int[] merged = new int[src1.length+src2.length ];
        while(i<src1.length && j< src2.length){
            if(src1[i] <= src2[j]){
                //merged[k]=src1[i];
                i++;
            }else{
              //  merged[k]=src2[j];
                j++;
            }
           // k++;
        }
        //while(j<src2.length){
           // merged[k]=src2[j];
          //  k++;
          //  j++;
       // }
       // while(i<src1.length){
            //merged[k]=src1[i];
         //   k++;
         //   i++;
        //}
        return inver0 +inver1+inver2;
    }
    public int findInversions(int[] src){
        int inversions=0;
        for(int i=0;i<src.length-1;i++){
            for(int j=i+1;j<src.length;j++){
                if(src[i]>src[j]){
                    inversions++;
                }
            }
        }
        return inversions;
    }
    public static void main(String[] args){
        System.out.println( new ArrayInversion().findInversions(new int[]{ 2, 4, 1, 3, 5}));
        System.out.println( new ArrayInversion().findInversions(new int[]{ 5, 4, 3, 2, 1}));
    }
}
