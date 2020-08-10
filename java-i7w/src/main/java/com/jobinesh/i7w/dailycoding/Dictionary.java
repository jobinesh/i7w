package com.jobinesh.i7w.dailycoding;

import java.util.Arrays;
import java.util.List;

/*
This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 determine if s can be segmented into a space-separated
sequence of one or more dictionary words.
 */
public class Dictionary {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length()==0) {
            return true;
        }
        int size = s.length();
        boolean dp[] = new boolean[size+1];

        dp[0]=true;
        for (int i = 0; i < s.length(); i++) {
            if(dp[i]) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String seg = s.substring(i, j);
                    if (wordDict.contains(seg)) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[size];
    }
    public boolean wordBreak1(String s, List<String> wordDict) {

        int size = s.length();
        boolean dp[] = new boolean[size+1];
        if (size == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String seg = s.substring(0, i);
            boolean isValid = wordDict.contains(seg);
            if( isValid && wordBreak(s.substring(i, size), wordDict)){
                return true;
            }
        }
        return false;



    }

//    public String[] findSentence(String dictionary, String[] words)


    public static void main(String[] args) {
        //String[] sents = new Dictionary().findSentence("bedbathandbeyond", new String[]{"bed", "bath", "and", "beyond"});
        //System.out.println(Arrays.asList(sents));
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        System.out.println(new Dictionary().wordBreak(s, Arrays.asList(wordDict)));

    }
}
