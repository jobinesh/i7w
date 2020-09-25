package com.jobinesh.i7w.dailycoding;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class DC63WordSearch {

    public boolean exist(char[][] board, String word) {
        int wordIndex = 0;
        boolean exists = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if(dfs(board, i, j, word, 0)){
                   exists=true;
               }

            }
        }
        return exists;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j]='#';
            if (k == word.length() - 1) {
                return true;
            }else if (dfs(board, i - 1, j, word, k + 1)
                    || dfs(board, i + 1, j, word, k + 1)
                    || dfs(board, i, j - 1, word, k + 1)
                    || dfs(board, i, j + 1, word, k + 1)) {
                return true;
            }
            board[i][j]= temp;
        }
         return false;
    }

    public static void main(String[] args) {
        char[][] board0 = {{'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}};
        System.out.println(new DC63WordSearch().exist(board0, "ABCB"));
        char[][] board1 = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new DC63WordSearch().exist(board1, "SEE"));
        char[][] board2 = {{'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}};
        System.out.println(new DC63WordSearch().exist(board2, "ABCCED"));
    }
}
