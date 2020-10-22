package com.jobinesh.i7w.dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DC96Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length - 1, result);
        return result;
    }

    private void permute(int[] nums, int l, int r, List<List<Integer>> result) {
        if (l == r) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                currentPermutation.add(nums[i]);
            }
            result.add(currentPermutation );

        } else {
            for (int i = l; i <= r; i++) {
                swap(nums, l, i);
                permute(nums, l + 1, r, result);
                swap(nums, l, i);
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new DC96Permutation().permute(nums);
        System.out.println(Arrays.asList(result));
    }
}
