package com.jobinesh.i7w.leetcode.random;

/*
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
Find and return the shortest palindrome you can find by performing this transformation.
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {

        int i = 0;
        int j = s.length()-1;
        while (j >=0) {
           if(s.charAt(i)==s.charAt(j)){
               i++;
           }
           j--;
        }
        if(i==s.length()){
            return s;
        }
        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid=  s.substring(0,i);

        return prefix+mid+suffix;
    }
    public static void main(String[] args){
        System.out.println( new ShortestPalindrome().shortestPalindrome( "adcba"));
    }
}
