import java.util.Random;

public class TicTacToeUC7 {

    // Reuse from UC4
    public static int[] getBoardPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // Reuse from UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // Reuse from UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Display board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC7: Computer move
    public static void computerMove(char[][] board, char computerSymbol) {
        Random random = new Random();
        int slot;
        int row, col;

        while (true) {
            // Step 1: Generate random slot (1–9)
            slot = random.nextInt(9) + 1;

            // Step 2: Convert to row & column
            int[] position = getBoardPosition(slot);
            row = position[0];
            col = position[1];

            // Step 3: Validate
            if (isValidMove(board, row, col)) {
                // Step 4: Place move
                placeMove(board, row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
            // else → loop continues until valid
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'-', '-', '-'},
            {'-', 'X', '-'},
            {'-', '-', '-'}
        };

        System.out.println("Before Computer Move:");
        printBoard(board);

        // Computer plays 'O'
        computerMove(board, 'O');

        System.out.println("\nAfter Computer Move:");
        printBoard(board);
    }
}
