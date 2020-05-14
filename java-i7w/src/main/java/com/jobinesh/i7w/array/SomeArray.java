package com.jobinesh.i7w.array;

public class SomeArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                if (index + 1 < i) {
                    nums[index + 1] = nums[i];
                }
                index++;
            }
        }

        return index + 1;
    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if  (nums[i]>=target) {
                index = i;
                break;
            }
        }
        if(i==nums.length){
            index=i;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int len = new SomeArray().searchInsert(nums, 4);
        System.out.println("index: " + len);

    }
}
