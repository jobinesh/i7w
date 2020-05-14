package com.jobinesh.i7w.number;

public class IntPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reversed = 0;
        int reminder = 0;
        int srcNum = x;
        while (srcNum != 0) {
            reminder=srcNum % 10;
            reversed = reversed * 10 + reminder;
            srcNum=srcNum/10;
            System.out.println( "reminder "+reminder );
            System.out.println( "reversed "+reversed);
            System.out.println( "srcNum "+srcNum);
        }
        System.out.println( x );
        System.out.println( reversed);
        return x==reversed;
    }
    public static void main(String[] args){
       boolean isPali = new IntPalindrome().isPalindrome(10401);
       System.out.println("Is Pali "+ isPali);
    }

}
