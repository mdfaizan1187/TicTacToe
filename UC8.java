import java.util.Scanner;
import java.util.Random;

public class TicTacToeGame {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // UC1: Initialize board
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Display board
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC3: User input
    public static int getUserInput() {
        int slot;
        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = scanner.nextInt();
            if (slot >= 1 && slot <= 9) return slot;
            System.out.println("Invalid input!");
        }
    }

    // UC4: Convert slot
    public static int[] getPosition(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    // UC5: Validate move
    public static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // UC6: Place move
    public static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer move
    public static void computerMove(char symbol) {
        while (true) {
            int slot = random.nextInt(9) + 1;
            int[] pos = getPosition(slot);
            if (isValidMove(pos[0], pos[1])) {
                placeMove(pos[0], pos[1], symbol);
                System.out.println("Computer chose: " + slot);
                break;
            }
        }
    }

    // UC8: Check winner
    public static boolean checkWin(char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == s && board[i][1] == s && board[i][2] == s) return true;
            if (board[0][i] == s && board[1][i] == s && board[2][i] == s) return true;
        }
        if (board[0][0] == s && board[1][1] == s && board[2][2] == s) return true;
        if (board[0][2] == s && board[1][1] == s && board[2][0] == s) return true;

        return false;
    }

    // Check draw
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        initializeBoard();

        char playerSymbol = 'X';
        char computerSymbol = 'O';

        boolean gameRunning = true;

        System.out.println("Tic-Tac-Toe Game Start!");
        printBoard();

        // UC8: Game Loop
        while (gameRunning) {

            // Player Turn
            int slot = getUserInput();
            int[] pos = getPosition(slot);

            if (isValidMove(pos[0], pos[1])) {
                placeMove(pos[0], pos[1], playerSymbol);
            } else {
                System.out.println("Invalid move! Try again.");
                continue; // retry same turn
            }

            printBoard();

            // Check win/draw
            if (checkWin(playerSymbol)) {
                System.out.println("Player Wins!");
                break;
            }

            if (isDraw()) {
                System.out.println("It's a Draw!");
                break;
            }

            // Computer Turn
            computerMove(computerSymbol);
            printBoard();

            if (checkWin(computerSymbol)) {
                System.out.println("Computer Wins!");
                break;
            }

            if (isDraw()) {
                System.out.println("It's a Draw!");
                break;
            }
        }
    }
}
