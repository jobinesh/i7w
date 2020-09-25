package com.jobinesh.i7w.dailycoding;

/**
 * A number is considered perfect if its digits sum up to exactly 10.
 *
 * Given a positive integer n, return the n-th perfect number.
 *
 * For example, given 1, you should return 19. Given 2, you should return 28.
 */
public class DC70PerfectNum {
    public int perfectNum(int num){
        int perfectNum;
        int sum=0;
        int tmpNum = num;
        while( tmpNum != 0){
            sum = sum+ tmpNum%10;
            tmpNum = tmpNum /10;
        }
        int digit = 10 - sum;
        perfectNum = digit  + num *10;
        return perfectNum;
    }
    public static void main(String args[]){
        System.out.println(new DC70PerfectNum().perfectNum(25));
    }
}
