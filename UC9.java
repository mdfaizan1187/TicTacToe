public static boolean checkWin(char[][] board, char symbol) {

    // Check rows
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == symbol &&
            board[i][1] == symbol &&
            board[i][2] == symbol) {
            return true;
        }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
        if (board[0][i] == symbol &&
            board[1][i] == symbol &&
            board[2][i] == symbol) {
            return true;
        }
    }

    // Check diagonals
    if (board[0][0] == symbol &&
        board[1][1] == symbol &&
        board[2][2] == symbol) {
        return true;
    }

    if (board[0][2] == symbol &&
        board[1][1] == symbol &&
        board[2][0] == symbol) {
        return true;
    }

    return false; // no win found
}
