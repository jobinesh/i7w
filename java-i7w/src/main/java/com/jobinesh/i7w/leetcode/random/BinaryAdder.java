package com.jobinesh.i7w.leetcode.random;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.
 */
public class BinaryAdder {
    public String addBinary(String a, String b) {
        String sumText ="";
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        while( i>=0 || j>=0){
            if(i>=0 && j<0){
                int sum = Character.getNumericValue(a.charAt(i))  + carry;
                if(sum>=2){
                    carry=1;
                    sum=sum-2;
                }else{
                    carry=0;
                }
                sumText = sum +sumText;
                i--;
                continue;
            }else if(j>=0 && i<0){
                int sum = Character.getNumericValue(b.charAt(j))  + carry;
                if(sum>=2){
                    carry=1;
                    sum=sum-2;
                }else{
                    carry=0;
                }
                sumText = sum +sumText;
                j--;
                continue;
            }else{
                int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + carry;
                if(sum>=2){
                    carry=1;
                    sum=sum-2;
                }else{
                    carry=0;
                }
                sumText = sum+sumText;
                i--;
                j--;
            }
        }
        if(carry != 0){
            sumText=carry+sumText;
        }
        return sumText;
    }
    public static void main(String[] args){
        System.out.println(new BinaryAdder().addBinary( "11", "1") );
        System.out.println(new BinaryAdder().addBinary( "1111", "1111") );
    }
}
