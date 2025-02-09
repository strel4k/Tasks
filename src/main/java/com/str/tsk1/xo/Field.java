package com.str.tsk1.xo;

public class Field {
    private char[][] board;
    private final int SIZE = 3;

    public int getSIZE() {
        return SIZE;
    }

    public char[][] getBoard() {
        return board;
    }

    public Field() {
        board = new char[SIZE][SIZE];
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (i< SIZE - 1)
                System.out.println("-----");
        }
    }
}