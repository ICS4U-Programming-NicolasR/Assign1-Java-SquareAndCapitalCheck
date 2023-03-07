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
     * This is the SQUARE_CHECK method.
     *
     * @param characterCh //CHARACTER
     * @return boolean
     *
     */

    public static boolean capitalCheck(final char characterCh) {
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
     * This is the LengthCalc method.
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
        final int ASCII_MINL = 65;
        final int ASCII_MAXL = 90;
        final int ASCII_MINU = 97;
        final int ASCII_MAXU = 122;
        String tryAgain = "";
        // Created a scanner object
        final Scanner INPUT_SCAN = new Scanner(System.in);
        do {
            System.out.println("What program would you like to do? 1 for"
                            + " square check, 2 for capital check");
            final String PROGRAM = INPUT_SCAN.nextLine();
            if (PROGRAM.equals(RECTANGLE)) {
                System.out.println("What is your length?");
                final String LENGTH_STR = INPUT_SCAN.nextLine();
                System.out.println("What is your width?");
                final String WIDTH_STR = INPUT_SCAN.nextLine();
                try {
                    final double LENGTH_DUB = Double.parseDouble(LENGTH_STR);
                    final double WIDTH_DUB = Double.parseDouble(WIDTH_STR);
                    if (LENGTH_DUB > 0 && WIDTH_DUB > 0) {
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
                } catch (NumberFormatException error) {
                    System.out.println("You entered a string! "
                            + "Please enter a real number\n"
                            + error);
                }
            } else if (PROGRAM.equals(CAPITAL)) {
                System.out.println("Please enter in your CHARACTER");
                final String CHARACTER_STR = INPUT_SCAN.nextLine();
                try {
                    final char CHARACTER = CHARACTER_STR.charAt(0);
                    if (CHARACTER >= ASCII_MINL && CHARACTER <= ASCII_MAXL
                        || CHARACTER >= ASCII_MINU && CHARACTER <= ASCII_MAXU) {
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
                } catch (NumberFormatException error) {
                    System.out.println("You have entered a string "
                            + "You must enter a real number\n"
                            + error);
                }
            } else {
                System.out.println("You have not entered a real PROGRAM");
            }
            System.out.println("Would you like to play again?");
            tryAgain = INPUT_SCAN.nextLine().toUpperCase();
        } while (tryAgain.equals(YES) || tryAgain.equals(Y));
        INPUT_SCAN.close();
    }
}
