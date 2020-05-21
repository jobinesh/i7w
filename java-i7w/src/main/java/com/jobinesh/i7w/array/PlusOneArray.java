package com.jobinesh.i7w.array;

import java.util.Arrays;

public class PlusOneArray {
    public int[] plusOne(int[] digits) {
        int reminder = 0;
        int result[]= new int[digits.length];
        System.arraycopy(digits,0,result,0, digits.length );
        int sum = digits[digits.length-1]+1 ;
        if(sum>=10){
            result[digits.length-1]=sum%10;
            reminder = sum/10;
        }else{
            result[digits.length-1]=sum;
            return result;
        }
        for(int i=digits.length-2; i>=0;i--){
            sum = digits[i] + reminder;
            if(sum>=10){
                result[i]=sum%10;
                reminder = sum/10;
            }else{
                result[i]=sum;
                reminder=0;
            }
        }
        if(reminder >0 ){
            int[] overflow= new int[digits.length+1];
            System.arraycopy(result,0,overflow,1, digits.length );
            overflow[0]=reminder;
            return overflow;
        }
        return result;
    }
    public static void main(String arg[]){
        int[] result = new PlusOneArray().plusOne( new int[]{4,3,2,9} );
        System.out.println(Arrays.toString(result ) );
    }
}
