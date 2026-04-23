public class TicTacToeUC5 {

    // Method to validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check boundaries
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true; // valid move
    }

    public static void main(String[] args) {

        // Sample board
        char[][] board = {
            {'-', '-', '-'},
            {'-', 'X', '-'},
            {'-', '-', '-'}
        };

        int row = 1;
        int col = 1;

        if (isValidMove(board, row, col)) {
            System.out.println("Move is valid!");
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }
}
