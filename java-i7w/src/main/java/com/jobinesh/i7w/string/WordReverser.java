package com.jobinesh.i7w.string;

import java.util.ArrayList;

public class WordReverser {
    private String[] split(String src) {
        ArrayList<String> splittedList = new ArrayList();
        char[] srcArray = src.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean hasNewWord = false;
        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i] != ' ') {
                if (hasNewWord && sb.length() > 0) {
                    splittedList.add(sb.toString());
                    sb = new StringBuilder();
                }
                hasNewWord = false;
                sb.append(srcArray[i]);
            } else {
                hasNewWord = true;
            }
        }
        splittedList.add(sb.toString());
        String[] array = new String[splittedList.size()];
        return splittedList.toArray(array);
    }

    public String reverseWords(String s) {
        if( s== null ){
            return s;
        }
        if(s.isBlank()){
           return "";
        }
        String[] words = split(s);
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String reversed = new WordReverser().reverseWords("a good   example");
        System.out.println("|"+reversed+"|");
    }
}
