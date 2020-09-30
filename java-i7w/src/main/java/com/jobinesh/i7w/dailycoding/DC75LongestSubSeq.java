package com.jobinesh.i7w.dailycoding;

/**
 * Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.
 *
 * For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
 */
public class DC75LongestSubSeq {

    public int lengthOfLIS(int[] nums) {
        int length =0;
        if( nums == null || nums.length ==0 ){
            return 0;
        }
        int ls[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ls[i]=1;
        }
        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
               if( nums[i]<nums[j] && ls[j]< ls[i]+1){
                   ls[j] =ls[i]+1;
               }
            }
        }
        length = ls[0];
        for(int i=1;i<nums.length;i++){
            if(ls[i]>length){
                length=ls[i];
            }
        }
        return length;
    }
    public static void main(String[] args){
        System.out.println(new DC75LongestSubSeq().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

}
