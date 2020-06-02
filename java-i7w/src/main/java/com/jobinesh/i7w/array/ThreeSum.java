package com.jobinesh.i7w.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                //Ignore duplicates
                if (end < nums.length - 1
                        && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    Integer[] threeSum = new Integer[3];
                    threeSum[0] = nums[i];
                    threeSum[1] = nums[start];
                    threeSum[2] = nums[end];
                    result.add(Arrays.asList(threeSum));
                    start++;
                    end--;
                } else if (sum < 0) {
                    start = start + 1;
                } else {
                    end = end - 1;
                }
            }

        }
        return result;
    }

    public static void main(String... args) {
        List<List<Integer>> result = new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(result);
    }
}
