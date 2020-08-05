package com.jobinesh.i7w.dailycoding;

/**
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 *
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 *
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class MessageEncoder {
    public int numDecodings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        return doCount( s.toCharArray(),s.length());
    }
    public int doCount(char[] digits, int n){
        if (digits[0]=='0')
            return 0;

        if(n ==0 || n ==1) {
            return 1;
        }

        int count = 0;
        if(digits[n-1] > '0' ){
            count = doCount(digits, n-1 );
        }
        if(digits[n-2] == '1' ||  digits[n-2]=='2' && digits[n-1]<='6'){
            count = count + doCount(digits, n-2 );
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(new MessageEncoder().numDecodings("12"));
    }
}
