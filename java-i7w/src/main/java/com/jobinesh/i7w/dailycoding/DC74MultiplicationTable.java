package com.jobinesh.i7w.dailycoding;

/**
 * Suppose you have a multiplication table that is N by N. That is, a 2D array where the value at the i-th row and j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).
 * <p>
 * Given integers N and X, write a function that returns the number of times X appears as a value in an N by N multiplication table.
 * <p>
 * For example, given N = 6 and X = 12, you should return 4, since the multiplication table looks like this:
 */
public class DC74MultiplicationTable {
    public int findOccurancesBF(int n, int x) {
        int occurances = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + 1) * (j + 1) == x) {
                    occurances++;
                }
            }
        }
        return occurances;
    }
    public int findOccurances(int n, int x) {
        int occurances = 0;
        for (int i = 1; i <= n; i++) {
          if( x%i==0 && x/i<=n){
              occurances++;
          }
        }
        return occurances;
    }


    public static void main(String args[]) {
        System.out.println( new DC74MultiplicationTable().findOccurances( 6,12) );
    }
}
