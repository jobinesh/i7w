package com.jobinesh.i7w.leetcode.random;

public class LegthOfLastWord {
        public int lengthOfLastWord(String s) {
            if( s== null || s.length()==0){
                return 0;
            }
            char[] sArray = s.toCharArray();
            int wordLen =0;
            for(int i=sArray.length-1;i>=0;i--){
                if((sArray[i]>='a' && sArray[i]<='z') ||
                        (sArray[i]>='A' && sArray[i]<='Z')){
                    wordLen++;

                }else if(wordLen ==0){
                    continue;
                }else{
                    break;
                }
            }
            return wordLen;
        }
        public int lengthOfLastWord1(String s) {
        if( s== null || s.length()==0){
            return 0;
        }
        char[] sArray = s.toCharArray();
        if( sArray.length ==1 && sArray[0] != ' '){
            return 1;
        }
        int wordLen =0;
        int i=sArray.length-1;
        while(i>=0){

            if(sArray[i] == ' ' ){
                if(i == sArray.length-1){
                    i--;
                    continue;
                }
                if( i<sArray.length-1 && sArray[i+1] == ' ' ) {
                    i--;
                    continue;
                }
                break;
            }
            if(sArray[i] != ' '){
                wordLen++;
            }

            i--;
        }

        return wordLen;
    }
    public static void main(String[] args){
        System.out.println(new LegthOfLastWord().lengthOfLastWord("  day    d "));
    }
}
