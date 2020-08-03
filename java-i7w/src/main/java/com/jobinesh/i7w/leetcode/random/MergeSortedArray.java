package com.jobinesh.i7w.leetcode.random;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if( nums1==null){
            return;
        }
        int[] nums1Copied=Arrays.copyOf(nums1, nums1.length);
        int i=0;
        int j=0;
        int index=0;
        while(i<m || j<n ){
            if(j>=n){
                nums1[index]=nums1Copied[i];
                i++;
            }else if(i>=m) {
                nums1[index]=nums2[j];
                j++;
            }else{
                if( nums1Copied[i]<nums2[j]){
                    nums1[index]=nums1Copied[i];
                    i++;
                }else{
                    nums1[index]=nums2[j];
                    j++;
                }
            }
            index++;
        }
    }
    private void test(int[] nums1){
        int[] a1=nums1;
        nums1[0]=-9;
        System.out.println(Arrays.toString(a1) );
        System.out.println(Arrays.toString(nums1) );
    }
    public static void main(String[] args){

        int[] a1={1,2,2,5,0,0,0,0,0,0,0};
        int[] b1={3,4,5,6,7,8,9};
        new MergeSortedArray().merge(a1, 4, b1, 7);
        System.out.println(Arrays.toString(a1) );

    }
}
