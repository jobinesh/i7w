package com.jobinesh.i7w.string;

public class JLongestPalindrome {
    public String longestPalindrome(String s) {
        char[] source = s.toCharArray();
        StringBuilder resolvedPali = new StringBuilder();
        StringBuilder currentPali = null;
        for (var i = 0; i < source.length; i++) {
            currentPali = new StringBuilder();
             var palIndex = 0;
            for (var j = 0; j < i; j++) {
                if (source[j] == source[i - palIndex]) {
                    currentPali.append(source[i]);
                    palIndex++;
                } else {
                    palIndex = 0;
                    if (currentPali.length() > 0)
                        currentPali = new StringBuilder();
                }
            }
            if ( currentPali.length() > resolvedPali.length()) {
                resolvedPali = currentPali;
            }
        }
        return resolvedPali.toString();
    }

    public static void main(String[] args) {
        System.out.println(new JLongestPalindrome().longestPalindrome( "babad"));
    }
}
