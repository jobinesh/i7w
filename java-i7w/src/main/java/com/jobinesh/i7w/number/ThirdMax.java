package com.jobinesh.i7w.number;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secMax = null;
        Integer thirdMax = null;
        for (int i = 0; i < nums.length; i++) {
            if (firstMax == null || nums[i] > firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = nums[i];
            }else if((secMax == null || nums[i] > secMax) && nums[i] != firstMax ){
                thirdMax = secMax;
                secMax = nums[i];
            }else if((thirdMax == null ||nums[i] > thirdMax) && nums[i] != firstMax && nums[i] != secMax ){
                thirdMax = nums[i];
            }
        }
        if( thirdMax != null)
            return thirdMax;
        else
            return firstMax;


    }

    public static void main(String[] args) {
        System.out.println( new ThirdMax().thirdMax(new int[]{2,2,33,23423,3,}));
    }
}
