package com.jobinesh.i7w.dailycoding;

/**
 * On our special chessboard, two bishops attack each other if they share the same diagonal. This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.
 * <p>
 * You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).
 * <p>
 * For example, given M = 5 and the list of bishops:
 * <p>
 * (0, 0)
 * (1, 2)
 * (2, 2)
 * (4, 0)
 * The board would look like this:
 * <p>
 * [b 0 0 0 0]
 * [0 0 b 0 0]
 * [0 0 b 0 0]
 * [0 0 0 0 0]
 * [b 0 0 0 0]
 */
public class DC68Bishops {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'b', '0', '0', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', 'b', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'b', '0', '0', '0', '0'}
        };
        int attacks = new DC68Bishops().possibleAttacks(board);
        System.out.println("Attacks: " + attacks);
    }

    public int possibleAttacks(char[][] bishops) {
        int count = 0;
        for (int i = 0; i < bishops.length; i++) {
            for (int j = 0; j < bishops[i].length; j++) {
                if (bishops[i][j] == 'b') {
                    count = count + findAttackesInTopLeftDiagonal(bishops, i - 1, j - 1);
                    count = count + findAttackesInTopRightDiagonal(bishops, i - 1, j + 1);
                    count = count + findAttackesInBottomLeftDiagonal(bishops, i + 1, j - 1);
                    count = count + findAttackesInBottomRightDiagonal(bishops, i + 1, j + 1);
                }
            }
        }
        return count;
    }

    private int findAttackesInTopLeftDiagonal(char[][] bishops, int row, int column) {
        int count = 0;
        int j = column;
        for (int i = row; i >= 0 && j >= 0 && bishops[i][j] != '1'; i--) {
            if (bishops[i][j] == 'b') {
                count++;
            } else {
                bishops[i][j] = '1';
            }
            j--;
        }
        return count;
    }

    private int findAttackesInTopRightDiagonal(char[][] bishops, int row, int column) {
        int count = 0;
        int j = column;
        for (int i = row; i >= 0 && j < bishops[i].length && bishops[i][j] != '1'; i--) {
            if (bishops[i][j] == 'b') {
                count++;
            } else {
                bishops[i][j] = '1';
            }
            j++;
        }
        return count;
    }

    private int findAttackesInBottomLeftDiagonal(char[][] bishops, int row, int column) {
        int count = 0;
        int j = column;
        int totalRows = bishops.length;
        for (int i = row; i < totalRows && j >= 0 && bishops[i][j] != '1'; i++) {
            if (bishops[i][j] == 'b') {
                count++;
            } else {
                bishops[i][j] = '1';
            }
            j--;
        }
        return count;
    }

    private int findAttackesInBottomRightDiagonal(char[][] bishops, int row, int column) {
        int count = 0;
        int j = column;
        int totalRows = bishops.length;
        for (int i = row; i < totalRows && j < bishops[i].length && bishops[i][j] != '1'; i++) {
            if (bishops[i][j] == 'b') {
                count++;
            } else {
                bishops[i][j] = '1';
            }
            j++;
        }
        return count;
    }
}
