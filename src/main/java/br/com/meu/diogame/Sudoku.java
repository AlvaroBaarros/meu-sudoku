package br.com.meu.diogame;

import java.util.HashSet;

public class Sudoku {
    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean isValidSudoku() {
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            HashSet<Integer> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0 && !rows.add(board[i][j])) return false;
                if (board[j][i] != 0 && !cols.add(board[j][i])) return false;
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                int boxVal = board[RowIndex + j / 3][ColIndex + j % 3];
                if (boxVal != 0 && !box.add(boxVal)) return false;
            }
        }
        return true;
    }
}