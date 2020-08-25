package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;

/**
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last.
 * You can only swap elements of the array.
 *
 * Do this in linear time and in-place.
 *
 * For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */
public class RGBArranger {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length<2){
            return;
        }
        int low=0;
        int mid=0;
        int high =nums.length-1;
        while(mid<=high){
            if( nums[mid]==0){
                int tmp=nums[low];
                nums[low]=nums[mid];
                nums[mid] = tmp;
                low=low+1;
                mid=mid+1;
            }else if(nums[mid]==1){
                mid=mid+1;
            }else if(nums[mid]==2){
                int tmp=nums[high];
                nums[high]=nums[mid];
                nums[mid] = tmp;
                high=high-1;
            }
        }
    }
    public void rgbSort(char[] src){
        for(int i=0;i< src.length; i++){
            for(int j=i;j<src.length;j++) {
                if (src[j]>src[i] ) {
                    char tmp= src[i];
                    src[i] = src[j];
                    src[j] = tmp;
                }
            }
        }

    }
    public static void main(String[] args){
        char[] rgbs={'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        new RGBArranger().rgbSort(rgbs );
        System.out.println(Arrays.toString(rgbs) );
        int[] rgbsnums={2,0,1};
        new RGBArranger().sortColors(rgbsnums );
        System.out.println(Arrays.toString(rgbsnums) );
    }
}
