package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    int[] original=null;
    int[] shuffled=null;
    public Solution(int[] nums) {
        original=Arrays.copyOfRange(nums,0,nums.length);
        shuffled=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        int n=shuffled.length;
        Random r = new Random();
        for(int j=n-1;j>0;j--){
            int i= r.nextInt(j+1);
            System.out.println("r:"+i);
            int tmp = shuffled[j];
            shuffled[j] = shuffled[i];
            shuffled[i] = tmp;

        }
        return shuffled;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        Solution sol = new Solution(nums);
        System.out.println(Arrays.toString(sol.shuffle() ));
        System.out.println(Arrays.toString(sol.reset() ));
        System.out.println(Arrays.toString(sol.shuffle() ));
        System.out.println(Arrays.toString(sol.reset() ));
    }
}
