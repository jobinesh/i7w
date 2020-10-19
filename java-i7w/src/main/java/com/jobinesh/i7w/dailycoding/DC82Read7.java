package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;

/**
 * Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.
 *
 * For example, given a file with the content "Hello world", three read7() returns "Hello w", "orld" and then "".
 */
public class DC82Read7 {
    private char[] read7(){
        String str ="abcdefg";
        return str.toCharArray();
    }
    public char[] readN(int n){
        int len = n;
        int i =0;
        String str ="";
        while(i<n){
            char[] char7 = read7();
            int numOfCharsToCopy =  len - i;
            if(numOfCharsToCopy>7){
                numOfCharsToCopy=7;
            }
            str = str + String.valueOf(char7).substring(0,numOfCharsToCopy);
            System.out.println( str);
            i = i+7;
        }
        return str.toCharArray();
    }
    public static void main(String[] args){
        char[] result = new DC82Read7().readN(21);
        System.out.println(Arrays.toString(result ));
    }
}
