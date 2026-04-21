import java.util.Random;

public class TicTacToeUC2 {

    public static void main(String[] args) {

        // Step 1: Create Random object
        Random random = new Random();

        // Step 2: Generate toss (0 or 1)
        int toss = random.nextInt(2);

        // Step 3: Game state variables
        char player1Symbol;
        char player2Symbol;
        int currentPlayer;

        // Step 4: Decide who starts and assign symbols
        if (toss == 0) {
            currentPlayer = 1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = 2;
            player2Symbol = 'X';
            player1Symbol = 'O';
        }

        // Step 5: Display results
        System.out.println("Toss Result: Player " + currentPlayer + " starts!");

        System.out.println("Player 1 Symbol: " + player1Symbol);
        System.out.println("Player 2 Symbol: " + player2Symbol);
    }
}
