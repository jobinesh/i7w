package com.jobinesh.i7w.leetcode.random;

/*
Given an array containing n distinct numbers
taken from 0, 1, 2, ..., n, find the one that is missing from the array.
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = nums.length*(nums.length+1)/2;
        for(int i=0;i< nums.length;i++){
            sum = sum- nums[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int [] nums= {9,6,4,2,3,5,7,0,1};
        System.out.println( new MissingNumber().missingNumber(nums));
    }
}
