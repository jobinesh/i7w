package com.jobinesh.i7w.dailycoding;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 *
 * For example, given the string "([])[]({})", you should return true.
 *
 * Given the string "([)]" or "((()", you should return false.
 */
public class BracketMatcher {
    HashMap bracketMapper = new HashMap<Character,Character>(){{
        put('[', ']');
        put('(', ')');
        put('{', '}');
    }};

    public boolean isValid(String brackets){
        Stack<Character> stack = new Stack<Character> ();

        for(int i=0;i<brackets.length();i++ ){
            if(brackets.charAt(i) == '{' || brackets.charAt(i) == '[' || brackets.charAt(i) == '('){
                stack.push(brackets.charAt(i));
            }
            if(brackets.charAt(i) == '}' || brackets.charAt(i) == ']' || brackets.charAt(i) == ')'){
                if(stack.empty()){
                    return false;
                }
                Character poppedElem= stack.peek();
                if(bracketMapper.get(poppedElem).equals(brackets.charAt(i))){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(stack.empty()) {
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(new BracketMatcher().isValid("{((()))[]}") );
    }
}
