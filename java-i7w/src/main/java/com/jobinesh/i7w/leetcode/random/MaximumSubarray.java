package com.jobinesh.i7w.leetcode.random;
/*
Given an integer array nums,
find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray2(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
    public int maxSubArray(int[] nums) {
        int sum=0;
        int largerSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = Math.max( nums[i],sum+ nums[i]);
            if( largerSum<sum){
                largerSum=sum;
            }

        }
        return largerSum;
    }
    public static void main(String args[]){
        System.out.println(new MaximumSubarray().maxSubArray( new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
