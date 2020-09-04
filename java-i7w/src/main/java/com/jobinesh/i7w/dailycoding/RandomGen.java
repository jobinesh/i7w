package com.jobinesh.i7w.dailycoding;

/**
 * This problem was asked by Two Sigma.
 *
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
 * implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 */
public class RandomGen {
    public int rand7(){
        return 5;
    }
    public int rand10(){
        int col,row, idx;
        {
             col = rand7();
             row = rand7();
             idx = (row - 1) * 7 + col;
        } while(idx>40) ;
       return 1 + (idx - 1) % 10;
    }
    public static void main(String[] args){
        System.out.println( new RandomGen().rand7());
    }
}
