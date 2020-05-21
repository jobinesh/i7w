package com.jobinesh.i7w.string;

import java.util.ArrayList;

public class Reverser {
    public String reverseWords(String s) {
        if(s == null || s.isBlank()){
            return s;
        }
        String[] tokens = split(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            int currentIndex = 0;
            int length = tokens[i].length()-1;
            int mid = length / 2;
            char[] currentTokenArray = tokens[i].toCharArray();
            while (currentIndex <= mid) {
                char tmp = currentTokenArray[length - currentIndex];
                currentTokenArray[length - currentIndex] = currentTokenArray[currentIndex];
                currentTokenArray[currentIndex] = tmp;
                currentIndex++;
            }
            if(sb.length()>0){
                sb.append(" ");
            }
            sb.append(currentTokenArray);
        }
        return sb.toString();
    }
    private String[] split(String src){
        ArrayList<String> splittedList = new ArrayList();
        char[] srcArray = src.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<srcArray.length;i++){
            if(srcArray[i]==' '){
                splittedList.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(srcArray[i]);
            }
        }
        splittedList.add(sb.toString());
        String[] array = new String[splittedList.size() ];
        return splittedList.toArray(array);
    }

    public static void main(String[] args){
       String reversed=  new Reverser().reverseWords("Let's take LeetCode contest");
       System.out.println(reversed);
    }
}
