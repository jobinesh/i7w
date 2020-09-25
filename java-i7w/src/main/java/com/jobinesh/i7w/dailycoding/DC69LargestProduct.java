package com.jobinesh.i7w.dailycoding;

/**
 * Given a list of integers, return the largest product that can be made by multiplying any three integers.
 * <p>
 * For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
 */
public class DC69LargestProduct {
    public long findLargestProduct(int[] numbers) {
        long prod = 0;
        int maxa = Integer.MIN_VALUE;
        int maxb = Integer.MIN_VALUE;
        int maxc = Integer.MIN_VALUE;
        int mina = Integer.MAX_VALUE;
        int minb = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxa) {
                maxc = maxb;
                maxb = maxa;
                maxa = numbers[i];
            } else if (numbers[i] > maxb) {
                maxc = maxb;
                maxb = numbers[i];
            } else if (numbers[i] > maxc) {
                maxc = numbers[i];
            }
            if (numbers[i] < mina) {
                minb = mina;
                mina = numbers[i];
            }else if (numbers[i] < minb) {
                minb = numbers[i];
            }
            long prod1 = maxc* maxb*maxa;
            long prod2 = mina * minb * maxa;
            if(prod1>prod2){
                prod= prod1;
            }else{
                prod= prod2;
            }
        }
        return prod;
    }
    public static void main(String[] args){
        System.out.println( new DC69LargestProduct().findLargestProduct(new int[]{ 1,2,3}));
    }
}
