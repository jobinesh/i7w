package com.jobinesh.i7w.dailycoding;
/*


Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.


 */
public class ExponentFinder {
    public double myPow(double x, int y){
        if(y==0){
            return 1;
        }
        if( y == Integer.MIN_VALUE){
            return 0;
        }
        boolean isNegativePow = (y>0?false:true);
        if(isNegativePow){
            y= Math.abs(y);
        }
        double exp =1;
        while(y>0){
            if(y%2 != 0){
                exp = exp*x;
            }
            y = y/2;
            x = x*x;
        }
        if(isNegativePow){
            exp = 1/exp;
        }
        return exp;
    }
    public static void main(String[] args){
        System.out.println( new ExponentFinder().myPow(2,-2147483648));
    }
}
