/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobinesh.i7w.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jobinesh
 */
public class StringUtil {

    public StringUtil() {
    }

    public static String removeWhiteSpace(String str) {
        StringBuilder sb = new StringBuilder();
        char[] strArray = str.toCharArray();
        for (char element : strArray) {
            if (element != ' ') {
                sb.append(element);
            }
        }
        return sb.toString();
    }

    public static boolean isAnagram2(String str1, String str2) {
        boolean isAnagram = true;
        char[] array1 = str1.toCharArray();
        StringBuilder sb = new StringBuilder(str2);
        if (array1.length != sb.length()) {
            isAnagram = false;
            return isAnagram;
        }
        for (int i = 0; i < array1.length; i++) {
            int index = sb.indexOf(String.valueOf(array1[i]));
            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                isAnagram = false;
                break;
            }
        }
        return isAnagram;
    }

    public static boolean isAnagram1(String str1, String str2) {
        boolean isAnagram = true;
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        if (array1.length != array2.length) {
            isAnagram = false;
            return isAnagram;
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if ((Character.toLowerCase(array1[i]) == Character.toLowerCase(array2[j])) && i != j) {
                    System.out.println("i:" + i + " " + array1[i] + " = " + array2[j] + " j:" + j);
                    break;
                }
                if (j + 1 == array2.length) {
                    isAnagram = false;
                    return isAnagram;
                }
            }
        }
        return isAnagram;
    }

    public static void printRepeatedCharsCount(String arg) {

        char[] argArray = arg.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int cnt = 0;
        for (int i = 0; i < argArray.length; i++) {
            if (map.containsKey(argArray[i])) {
                map.put(argArray[i], map.get(argArray[i]) + 1);
            } else {
                map.put(argArray[i], 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrries) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey());
            }
        }
    }

    public static char[] getRepeatedChars(String arg) {

        char[] argArray = arg.toCharArray();
        char[] repeated = new char[argArray.length / 2];
        int cnt = 0;
        for (int i = 0; i < argArray.length; i++) {
            for (int j = i + 1; j < argArray.length; j++) {
                if (argArray[i] == argArray[j]) {

                    repeated[cnt] = argArray[i];
                    cnt++;
                }
            }
        }
        return Arrays.copyOfRange(repeated, 0, cnt);
    }

    public static boolean isPalindrome(String arg) {
        boolean isPalindrome = true;
        char[] textArrayToCheck = arg.toCharArray();
        int lastElementIndex = textArrayToCheck.length - 1;
        for (int i = 0; i < textArrayToCheck.length / 2; i++) {
            if (textArrayToCheck[i] != textArrayToCheck[lastElementIndex - i]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;

    }

    public static String reverseStringAtIndex(String arg, int index) {

        char[] reversed = arg.toCharArray();
        int lastElementIndex = arg.length() - 1;
        for (int i = 0; i < arg.length() / 2; i++) {
            char tmp = reversed[i];
            reversed[i] = reversed[lastElementIndex - i];
            reversed[lastElementIndex - i] = tmp;
        }
        return String.valueOf(reversed);
    }

    public static String reverseString(String arg) {

        char[] reversed = arg.toCharArray();
        int lastElementIndex = arg.length() - 1;
        for (int i = 0; i < arg.length() / 2; i++) {
            char tmp = reversed[i];
            reversed[i] = reversed[lastElementIndex - i];
            reversed[lastElementIndex - i] = tmp;
        }
        return String.valueOf(reversed);
    }

    public static void main(String[] arg) {
        System.out.println(StringUtil.reverseStringAtIndex("abcdefghi", 3));
    }
}
