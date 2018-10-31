/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.string;

/**
 *
 * @author Jobinesh
 */
public class StringUtil {

    public StringUtil() {
    }

    public static String reverseString(String arg) {

        char[] reversed = arg.toCharArray();
        int lastElementIndex = arg.length() -1;
        for (int i = 0; i < arg.length() / 2; i++) {
            char tmp = reversed[i];
            reversed[i] = reversed[lastElementIndex - i];
            reversed[lastElementIndex - i] = tmp;
        }
        return String.valueOf( reversed );
    }

    public static void main(String[] arg) {
      System.out.print( StringUtil.reverseString("jobinesh") );
    }
}
