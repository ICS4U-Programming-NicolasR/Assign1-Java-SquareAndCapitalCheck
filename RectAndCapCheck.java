import java.util.Scanner;
/**
* Checks if a rectangle or if a capital.
*
* @author  Mr. Riscalas
* @version 1.0
* @since   2023-03-06
*/

public final class RectAndCapCheck {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RectAndCapCheck() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the SQUARE_CHECK method.
     *
     * @param length //height
     * @param width //width
     * @return boolean
     *
     */
    public static boolean squareCheck(final double length,
                                    final double width) {
        boolean square = false;
        if (length == width) {
            square = true;
        } else {
            square = false;
        }
        return square;
    }

    /**
     * This is the capitalCheck method.
     *
     * @param characterCh //CHARACTER
     * @return boolean
     *
     */

    public static boolean capitalCheck(final char characterCh) {
        // The ascii maximum and minimum for capital letters
        final int ASCII_MIN = 65;
        final int ASCII_MAX = 90;
        boolean capital = false;
        if (characterCh >= ASCII_MIN && characterCh <= ASCII_MAX) {
            capital = true;
        } else {
            capital = false;
        }
        return capital;
    }

    /**
     * This is the main method.
     *
     * @param args //unused
     *
     */

    public static void main(final String[] args) {
        // Create constants
        final String RECTANGLE = "1";
        final String CAPITAL = "2";
        final String YES = "YES";
        final String Y = "Y";
        // Create the maximums and the minimums for upper and lowercase letters
        final int ASCII_MINL = 65;
        final int ASCII_MAXL = 90;
        final int ASCII_MINU = 97;
        final int ASCII_MAXU = 122;
        String tryAgain = "";
        // Created a scanner object
        final Scanner INPUT_SCAN = new Scanner(System.in);
        do {
            // Check which program the user wants to do
            System.out.println("What program would you like to do? 1 for"
                            + " square check, 2 for capital check");
            final String PROGRAM = INPUT_SCAN.nextLine();
            // Rectangle program
            if (PROGRAM.equals(RECTANGLE)) {
                // Get the user lengths
                System.out.println("What is your length?");
                final String LENGTH_STR = INPUT_SCAN.nextLine();
                System.out.println("What is your width?");
                final String WIDTH_STR = INPUT_SCAN.nextLine();
                // Convert to double
                try {
                    final double LENGTH_DUB = Double.parseDouble(LENGTH_STR);
                    final double WIDTH_DUB = Double.parseDouble(WIDTH_STR);
                    if (LENGTH_DUB > 0 && WIDTH_DUB > 0) {
                        // Call the function to see if it is a square or not
                        final boolean SQUARE_CHECK = squareCheck(LENGTH_DUB,
                                                    WIDTH_DUB);
                        if (SQUARE_CHECK) {
                            System.out.println("You have a square!");
                        } else {
                            System.out.println("You have a rectangle!");
                        }
                    } else {
                        System.out.println("You have entered a negative "
                                + "number");
                    }
                // Catch for the try catch
                } catch (NumberFormatException error) {
                    System.out.println("You entered a string! "
                            + "Please enter a real number\n"
                            + error);
                }
            // Capital program
            } else if (PROGRAM.equals(CAPITAL)) {
                // Ask the user for the character
                System.out.println("Please enter in your CHARACTER");
                final String CHARACTER_STR = INPUT_SCAN.nextLine();
                // Convert the first input into a char
                final char CHARACTER = CHARACTER_STR.charAt(0);
                // Check if it is a letter
                if (CHARACTER >= ASCII_MINL && CHARACTER <= ASCII_MAXL
                    || CHARACTER >= ASCII_MINU && CHARACTER <= ASCII_MAXU) {
                    // Call the function to check if it is a capital
                    final boolean CHARACTER_CHECK = capitalCheck(CHARACTER);
                    if (CHARACTER_CHECK) {
                        System.out.println("You entered a capital!");
                    } else {
                        System.out.println("You have a lowercase letter!");
                    }
                } else {
                    System.out.println("You have entered a non letter"
                                    + " value");
                }
            } else {
                System.out.println("You have not entered a real program");
            }
            // Ask the user if they want to play again
            System.out.println("Would you like to play again?");
            tryAgain = INPUT_SCAN.nextLine().toUpperCase();
            // While loop to make it restart
        } while (tryAgain.equals(YES) || tryAgain.equals(Y));
        INPUT_SCAN.close();
    }
}
