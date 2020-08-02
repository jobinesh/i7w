package com.jobinesh.i7w.leetcode.random;

public class Sqrt {
    public int mySqrt1(int x) {
        long i = 1;
        while (i * i <= x) {
            i++;
        }
        return (int) i - 1;
    }

    public int mySqrt(int x) {

        long start = 0;
        long end = x;
        long solution=0;
        if (x == 0 || x == 1)
            return x;

        while (start <= end) {
            long mid = (start + end) / 2;

            long square = mid * mid;
            if ( square == x) {
                solution=mid;
                break;
            }else if( square< x){
                start = mid+1;
            }else{
                solution=mid-1;
                end= mid-1;
            }
        }
        return (int)solution;
    }

    public static void main(String arg[]) {
        System.out.println(new Sqrt().mySqrt(
                2147395600)); //2147395600
    }
}
