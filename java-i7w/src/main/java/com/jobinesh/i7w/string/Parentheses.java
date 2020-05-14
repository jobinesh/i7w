package com.jobinesh.i7w.string;

import java.util.Map;
import java.util.Stack;

public class Parentheses {
    private final Map<Character,Character> closingParanth = Map.of('}','{',
            ']','[',
            ')','(');
    public boolean isValid(String s) {
        if(s== null){
           return false;
        }
        if (s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack();
        char[] paranthText =s.toCharArray();
        if(paranthText.length%2 != 0){
            return false;
        }
        for(var i=0;i<paranthText.length;i++){
            if(paranthText[i]=='{' || paranthText[i]=='[' || paranthText[i]=='('){
                stack.push(paranthText[i]);
             }else if(paranthText[i]=='}' || paranthText[i]==']' || paranthText[i]==')' ){
                if(stack.size() ==0){
                    return false;
                }
                char popedPranth =  stack.pop();
                if(popedPranth != closingParanth.get(paranthText[i]) ){
                    return false;
                }
            }else{
                return false;
            }
        }
        if(stack.size()!=0){
            return false;
        }
        return true;
    }
    public static void main(String[] arg){
       System.out.println( new Parentheses().isValid( "((") );
    }
}
