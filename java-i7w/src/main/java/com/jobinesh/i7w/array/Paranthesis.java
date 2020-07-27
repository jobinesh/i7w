package com.jobinesh.i7w.array;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "",0,0,n,0);
        return list;

    }
    // Utility function used for pretty-printing.
    private static String getIndentation(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
    public void generate(List<String> para, String seq, int left, int right, int max, int depth){
        if(seq.length()==2*max){
            System.out.printf("%sleft=%d, right=%d, current='%s'\n",
                    getIndentation(depth), left, right, seq);
            para.add(seq);
            return;
        }
        if(left<max){
            System.out.printf("%sleft=%d, right=%d, current='%s'\n",
                    getIndentation(depth), left, right, seq);
             generate(para, seq+"(", left+1, right, max, depth+1 );
        }
        if(right<left){
            System.out.printf("%sleft=%d, right=%d, current='%s'\n",
                    getIndentation(depth), left, right, seq);
            generate(para,seq+")", left, right+1, max, depth+1);
        }
    }
    public List<String> generateParenthesis1(int n) {
        ArrayList<String> list = new ArrayList<String>();
        genearteString(list,"",0,0,n);
        return list;
    }
    public void genearteString(List<String> paranthesis,String currentSeq, int open, int close, int max){
      if(currentSeq.length()==max*2 ){
          paranthesis.add(currentSeq);
          return;
      }
      if( open<max){
          genearteString(paranthesis, currentSeq+'(', open+1,close, max);
      }
        if( close<open){
            genearteString(paranthesis, currentSeq+')', open,close+1, max);
        }
    }
    public static void main(String[] args){
        System.out.println( new Paranthesis().generateParenthesis(2));
    }
}
