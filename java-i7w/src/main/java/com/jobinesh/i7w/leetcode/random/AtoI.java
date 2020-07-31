package com.jobinesh.i7w.leetcode.random;
/*
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
 */
public class AtoI {
    public int myAtoi(String str) {
        if(str ==null || str.length()==0){
            return 0;
        }

        char[] strArray = str.toCharArray();
        Character symbol=null;
        StringBuilder sb = new StringBuilder();
        boolean invalid=false;
        boolean precedingZero=false;
        for(int i=0;i<strArray.length;i++){
            if(strArray[i] == '+' ||  strArray[i] == '-'  ){
               if(sb.length()>0 || precedingZero){
                   if(i>0 && (strArray[i-1] >= '0' && strArray[i-1]<= '9')){
                       break;
                   }
                   invalid=true;
                   break;
               }
               if(symbol == null) {
                   symbol = strArray[i];
               }else{
                   invalid=true;
                   break;
               }

               continue;
           }else if((strArray[i] >= '0' && strArray[i]<= '9')){
               if(strArray[i] == '0'&&sb.length()==0){
                   precedingZero=true;
                   continue;
               }
               sb.append(strArray[i]);
           }else if(strArray[i] == ' '){
                if((symbol != null && sb.length()==0) || precedingZero){
                    invalid=true;
                    break;
                }
                if(sb.length()>0){
                    break;
                }else{
                    continue;
                }
            }else{
                if(sb.length()>0) {
                    break;
                }else{
                    invalid=true;
                }
            }
        }
        if(sb.length()==0 || invalid){
            return 0;
        }
        char[] refinedArray= sb.toString().toCharArray();
        if( refinedArray.length>10){
            if(symbol != null && symbol == '-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        long num=0;
        for(int i=0;i<refinedArray.length;i++){
            long base = (long)Math.pow( 10, (refinedArray.length-1-i));
            num = num + Character.getNumericValue(refinedArray[i])* base;
        }
        if( num>Integer.MAX_VALUE){
            if(symbol != null && symbol == '-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int symbolVal=1;
        if(symbol != null && symbol == '-'){
            symbolVal=-1;
        }

        return (int)num*symbolVal;
    }

    public static void main(String[] args){
       System.out.println( new AtoI().myAtoi(

               "-5-"));
    }
}
