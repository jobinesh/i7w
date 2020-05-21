package com.jobinesh.i7w.array;

public class Robber {
    public int rob(int[] nums) {
        int sum0=0;
        int sum1=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                sum0 = sum0+ nums[i];
            }else{
                sum1 = sum1+ nums[i];
            }
        }
        if(sum0 > sum1){
            return sum0;
        }else
        return sum1;
    }

    public static void main(String[] arg) {
        int[] houseMoney = { 1,2,3,1};
       int result = new Robber().rob(houseMoney);
        System.out.println( result);
    }
}
