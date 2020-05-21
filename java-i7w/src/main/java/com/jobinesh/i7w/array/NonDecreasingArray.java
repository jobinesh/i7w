package com.jobinesh.i7w.array;

import java.util.Arrays;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums == null){
            return false;
        }
        int changes=0;
        boolean isDecreasingArry = false;
        for(int i=0;(i<nums.length-1);i++){
            if(nums[i]<=nums[i+1]){
                continue;
            }else{
                if(changes>0){
                    changes++;
                    break;
                }
                if(i>0) {
                    if( i +1 == nums.length-1 ){
                        nums[i+1]=nums[i]+1;
                    }else {
                        if(nums[i] == nums[i - 1]){
                            nums[i+1]=nums[i];
                        }else {
                            if(i+2 <= nums.length-1 && nums[i] <= nums[i+2] ) {
                                nums[i+1] = nums[i];
                            }else {
                                nums[i] = nums[i - 1];
                            }
                        }
                        if(nums[i]>nums[i+1]){
                            isDecreasingArry = true;
                            break;
                        }
                    }
                }else{
                    nums[i ]= nums[i+1]-1;
                }
                changes++;
            }
        }
        System.out.println(Arrays.toString( nums));
        return isDecreasingArry? !isDecreasingArry: changes<=1;
    }
    public static void main(String[] arg){
        System.out.println( "Result: " + new NonDecreasingArray().checkPossibility( new int[]{4,2,5}) );
    }
}
