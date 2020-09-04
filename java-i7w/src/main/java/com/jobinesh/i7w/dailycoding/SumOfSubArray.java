package com.jobinesh.i7w.dailycoding;
/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */
public class SumOfSubArray {
    public int sum(int[] a){
        if(a== null || a.length==0){
            return 0;
        }
        int currentSum=0;
        int sumSoFar=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if (a[i]>currentSum+a[i]){
                currentSum=a[i];
            }else{
                currentSum=currentSum+a[i];
            }
            if(currentSum>sumSoFar ) {
                sumSoFar = currentSum;
            }
        }
        sumSoFar = sumSoFar>currentSum?sumSoFar:currentSum;
        return sumSoFar;
    }
    public static void main(String[] args){
        System.out.println(new SumOfSubArray().sum(new int[]{34, -50, 42, 14, -5, 86}));
        System.out.println(new SumOfSubArray().sum(new int[]{ -5, -1, -8, -9}));
    }
}
