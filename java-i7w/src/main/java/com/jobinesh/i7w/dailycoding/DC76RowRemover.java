package com.jobinesh.i7w.dailycoding;

/**
 * You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically
 * later as you go down each row. It does not matter whether each row itself is ordered lexicographically.
 */
public class DC76RowRemover {
    public int rowsForRemoval(char[][] src){
        int rowsForRemoval=0;
        int m= src.length;
        int n= src[0].length;
        for(int j=0;j<n;j++){
            for(int i=0;i<m-1;i++){
                if (src[i][j] >  src[i+1][j]){
                    rowsForRemoval++;
                    break;
                }
            }
        }
        return rowsForRemoval;
    }
    public static void main(String[] args){
        char[][]  src= new char[][]{ {'w','y','z'},{ 'x','v','u'},{'z','s','r'} };
        int rows =new DC76RowRemover().rowsForRemoval(src );
        System.out.println( "Rows "+rows);
    }
}
