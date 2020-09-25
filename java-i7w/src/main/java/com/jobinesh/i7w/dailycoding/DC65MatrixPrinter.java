package com.jobinesh.i7w.dailycoding;

/**
 * This problem was asked by Amazon.
 *
 * Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
 *
 * For example, given the following matrix:
 *
 * [[1,  2,  3,  4,  5],
 *  [6,  7,  8,  9,  10],
 *  [11, 12, 13, 14, 15],
 *  [16, 17, 18, 19, 20]]
 * You should print out the following:
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * 10
 * 15
 * 20
 * 19
 * 18
 * 17
 * 16
 */
public class DC65MatrixPrinter {

    public void print(int[][] matrix) {
        int i=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int r=0;
        int c=0;
        int noOfCycle=0;
       while(m>0 && n>0){
           r=noOfCycle;
           c=noOfCycle;
           printLtoR(matrix,r,c,noOfCycle);
           r=noOfCycle+1;
           c=matrix[r].length-1-noOfCycle;
           printTtoB(matrix,r,c,noOfCycle);
           r=matrix.length-1-noOfCycle;
           c=matrix[r].length-1-noOfCycle-1;
           printRtoL(matrix,r,c,noOfCycle);
           r=matrix.length-1-noOfCycle-1;
           c=noOfCycle+1;
           printBtoT(matrix,r,c,noOfCycle);
           noOfCycle++;
           m = m-2;
           n = n-2;
       }
    }
    private void printLtoR(int[][] matrix, int r, int c, int noOfCycle){
        for(int j=c;j<matrix[r].length-noOfCycle;j++){
            System.out.println( matrix[r][j]);
        }
    }
    private void printTtoB(int[][] matrix, int r, int c, int noOfCycle){
        for(int i=r;i<matrix.length-noOfCycle;i++){
            System.out.println( matrix[i][c]);
        }
    }
    private void printRtoL(int[][] matrix, int r, int c,int noOfCycle){
        for(int j=c;j>=noOfCycle;j--){
            System.out.println( matrix[r][j]);
        }
    }
    private void printBtoT(int[][] matrix, int r, int c, int noOfCycle){
        for(int i=r;i>=noOfCycle;i--){
            System.out.println( matrix[i][c]);
        }
    }
    public static void main(String[] args) {
        int[][] matrices = {{1,  2,  3,  4,  5},
                            {6,  7,  8,  9,  10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20}};
        new DC65MatrixPrinter().print(matrices);

    }
}
