package com.jobinesh.i7w.dailycoding;

/**
 * Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.
 * <p>
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 * <p>
 * Do this in O(N) time and O(1) space.
 */
public class NonDuplicateNumber {
    public int findOddOne(int[] nums) {

        int ones = 0;
        int twos = 0;
        int commons = 0;
        for (int i = 0; i < nums.length; i++) {
            twos = twos | (ones & nums[i]);
            ones = (ones ^ nums[i]);
            commons = ~(ones & twos);
            ones = ones & commons;
            twos = twos & commons;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new NonDuplicateNumber().findOddOne(new int[]{0,1,0,1,0,1,99}));
    }
}
