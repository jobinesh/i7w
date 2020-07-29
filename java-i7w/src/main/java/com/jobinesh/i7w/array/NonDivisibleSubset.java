package com.jobinesh.i7w.array;

import java.util.List;

/*
Given a set of distinct integers, print the size of a maximal subset of  where the sum of any  numbers in  is not evenly divisible by .

For example, the array  and . One of the arrays that can be created is . Another is . After testing all permutations, the maximum length solution array has  elements.
 */
public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        Integer[] sArray= s.toArray(new Integer[s.size()]);
        int[] reminder = new int[k];
        for(int i=0;i<sArray.length;i++){
            reminder[sArray[i]%k]++;
        }
        int result=0;
        if(k%2==0){
            reminder[k/2] =Math.min(reminder[k/2],1);
        }
        for(int i=1;i<=k/2;i++){
            result += Math.max(reminder[i], reminder[k-i] );
        }
        result += Math.min(reminder[0],1);

        return result;
    }
    public static void main(String[] args){

    }
}
