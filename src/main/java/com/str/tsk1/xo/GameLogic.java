package com.str.tsk1.xo;

import java.util.Scanner;

public class GameLogic {
    private final Field field = new Field();
    private char currentPlayer = 'X';
    private final Scanner scanner = new Scanner(System.in);

    public void playGame() {

        boolean gameRunning = true;

        while (gameRunning) {
            field.printBoard();
            System.out.println("Игрок " + currentPlayer + " ходи (0-2 строка и колонка)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (makeMove(row, col, currentPlayer)) {
                if (isWin(currentPlayer)) {
                    field.printBoard();
                    System.out.println("Игрок " + currentPlayer + " вин!");
                    gameRunning = false;
                } else if (isFull())  {
                    field.printBoard();
                    System.out.println("Ничья, лалки");
                    gameRunning = false;
                } else {
                    //к следующему игроку
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Криво пошел - перехаживай");     //сообщение об ошибочном ходе
            }
        }
        scanner.close();        //закрытие сканнера после завершения игры
    }
    private boolean validateMove(int row, int col, char currentPlayer) {
        return true;
    }
    private boolean isWin(char player) {
        //проверка строк и столбцов
        for (int i=0; i<field.getSIZE(); i++) {
            if ((field.getBoard()[i][0] == player && field.getBoard()[i][1] == player && field.getBoard()[i][2] == player) ||
                    (field.getBoard()[0][i] == player && field.getBoard()[1][i] == player && field.getBoard()[2][i] == player)) {
                return true;        //если строка или столбец заполнены одним символом, то игрок выиграл
            }
        }
        //проверка диагоналей
        if ((field.getBoard()[0][0] == player && field.getBoard()[1][1] == player && field.getBoard()[2][2] == player) ||
                (field.getBoard()[0][2] == player && field.getBoard()[1][1] == player && field.getBoard()[2][0] == player)) {
            return true;            //если одна из диагоналей заполнены одним символом, то игрок выиграл
        }

        return false;           //если ни одно из условий не выполнено, то нет победы
    }

    private boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < field.getSIZE() && col >= 0 && col < field.getSIZE() && this.field.getBoard()[row][col] == ' ') {
            this.field.getBoard()[row][col] = player;
            return true;
        }
        return false;
    }

    private boolean isFull() {
        for (int i=0; i< field.getSIZE(); i++) {
            for (int j=0; j< field.getSIZE(); j++) {
                if (field.getBoard()[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}