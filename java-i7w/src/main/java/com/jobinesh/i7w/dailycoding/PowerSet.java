package com.jobinesh.i7w.dailycoding;

import java.util.ArrayList;
import java.util.List;

/**
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.
 *
 * For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 *
 * You may also use a list or array to represent a set.
 */
public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        long size = (long)Math.pow(2, nums.length);
        List<List<Integer>> poweSet = new ArrayList<>();
        for(int i=0;i<size; i++){
            String binaryStr = Integer.toBinaryString(i);
            List<Integer> bitList = new ArrayList<>();
            for(int j=0;j<binaryStr.length();j++ ){
                int index = nums.length - binaryStr.length();
                if(binaryStr.charAt(j)=='1'){
                    bitList.add(nums[j+index]);
                }
            }
            //if( bitList.size()>0)
            poweSet.add(bitList);
        }
        return poweSet;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println( new PowerSet().subsets(nums));
    }
}
