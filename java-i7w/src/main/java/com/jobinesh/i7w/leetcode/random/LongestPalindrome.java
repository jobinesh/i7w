package com.jobinesh.i7w.leetcode.random;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s== null || s.length()==0){
            return s;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1= getPalindromeAtCentre(s,i, i);
            int len2= getPalindromeAtCentre(s,i, i+1);
            int len = len1> len2?len1:len2;
            if(len>(end-start)) {
                start = i -( len-1) / 2;
                end = i + len / 2;
            }
        }
       return s.substring(start,end+1);
    }
    public int getPalindromeAtCentre(String s, int low, int high){
       while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
        low--;
        high++;
       }
        return high-low-1;
    }
    public static void main(String[] args){
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }
}
