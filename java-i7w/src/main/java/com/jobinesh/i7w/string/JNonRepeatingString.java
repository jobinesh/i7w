package com.jobinesh.i7w.string;


public class JNonRepeatingString {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.isEmpty()){
            return 0;
        }
        StringBuilder possibleLongSubstr = new StringBuilder();
        StringBuilder evaluatedLongSubstr = new StringBuilder();
        boolean needtoCheckMore = true;
        int beginIndex = 0;
        while (needtoCheckMore) {
            System.out.println("Beginindex :" + beginIndex);
            for (var j = beginIndex; j < s.length(); j++) {
                if (possibleLongSubstr.toString().lastIndexOf(s.charAt(j)) != -1) {
                    if (evaluatedLongSubstr.length() < possibleLongSubstr.length()) {
                        evaluatedLongSubstr = possibleLongSubstr;
                    }
                    beginIndex = beginIndex + possibleLongSubstr.toString().lastIndexOf(s.charAt(j)) + 1;
                    possibleLongSubstr = new StringBuilder();
                    break;
                }
                if (j + 1 == s.length()) {
                    needtoCheckMore = false;
                }
                possibleLongSubstr.append(s.charAt(j));
                System.out.println("possibleLongSubstr :" + possibleLongSubstr);
                System.out.println("evaluatedLongSubstr :" + evaluatedLongSubstr);
                System.out.println("j :" + j);
            }
        }
        if (evaluatedLongSubstr.length() < possibleLongSubstr.length()) {
            evaluatedLongSubstr = possibleLongSubstr;
        }
        System.out.println(evaluatedLongSubstr);
        return evaluatedLongSubstr.length();
    }
//loddktdji
    //pwwkew

    public static void main(String... arg) {
        System.out.println(new JNonRepeatingString().lengthOfLongestSubstring(""));
    }
}
