package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean isGameOver;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        isGameOver = false;

        // Initialize the board with empty cells
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void playGame() {
        System.out.println("Welcome to Tic Tac Toe!");

        while (!isGameOver) {
            displayBoard();
            getPlayerMove();
            checkGameOver();
            switchPlayer();
        }

        displayBoard();
        declareResult();
    }

    private void displayBoard() {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    private void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);

        int row, col;
        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move. Row and column should be between 1 and 3.");
            return false;
        }

        if (board[row][col] != '-') {
            System.out.println("Invalid move. Cell is already occupied.");
            return false;
        }

        return true;
    }

    private void checkGameOver() {
        if (checkWin()) {
            isGameOver = true;
        } else if (isBoardFull()) {
            isGameOver = true;
        }
    }

    private boolean checkWin() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == currentPlayer &&
                    board[row][1] == currentPlayer &&
                    board[row][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == currentPlayer &&
                    board[1][col] == currentPlayer &&
                    board[2][col] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                
                        if (board[row][col] == '-') {
                            return false;
                        }
                    }
                }
                return true;
            }

            private void switchPlayer() {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            private void declareResult() {
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("It's a draw!");
                }
            }

            public static void main(String[] args) {
                TicTacToe game = new TicTacToe();
                game.playGame();
            }
        }


