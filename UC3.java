import java.util.Scanner;

public class TicTacToeUC3 {

    // Method to get slot input from user
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a slot number (1-9): ");
        int slot = scanner.nextInt();

        return slot; // return the entered value
    }

    public static void main(String[] args) {

        // Call method
        int userSlot = getUserInput();

        // Display entered slot
        System.out.println("You selected slot: " + userSlot);
    }
}
