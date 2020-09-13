package com.jobinesh.i7w.dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string s and an integer k, break up the string into multiple lines such that each line
has a length of k or less. You must break it up so that words don't break across lines.
Each line has to have the maximum possible amount of words.
If there's no way to break the text up, then return null.
 */
public class TextBreaker {
    public String[] breakText(String text, int k){
        List<String> lines = new ArrayList<>();
        String currentLine = "";
        StringBuilder currentWord = new StringBuilder();
        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == ' '){
                if( i>0 && text.charAt(i-1) == ' '){
                    continue;
                }
                if( currentLine.length()+ 1 + currentWord.length() < k){
                    if(currentLine.length() >0 )
                        currentLine = currentLine + " "+currentWord.toString();
                    else
                        currentLine = currentWord.toString();
                }else{
                    if(currentLine.length()>0 ){
                        if(currentLine.length()<=k ) {
                            lines.add(currentLine);
                            currentLine = currentWord.toString();
                        }else{
                            currentLine = currentLine +" "+currentWord;
                        }
                    }
                }
                currentWord= new StringBuilder();
            }else{
                currentWord.append(text.charAt(i));
            }
        }
        return lines.toArray(new String[ lines.size()]);
    }
    public static void main(String[] args){
        String[] result=new TextBreaker().breakText("the quick brown fox jumps over the lazy dog" ,10 );
        System.out.println(Arrays.toString(result) );
    }
}
