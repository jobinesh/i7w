package com.jobinesh.i7w.array;

import java.util.Arrays;

public class RunningSum {

    public int[] runningSum(int[] nums) {
        if(nums==null){
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0){
                nums[i] = nums[i-1]+nums[i];
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums ={3,1,2,10,1};
        System.out.println(Arrays.toString(new RunningSum().runningSum( nums)));
    }

}
