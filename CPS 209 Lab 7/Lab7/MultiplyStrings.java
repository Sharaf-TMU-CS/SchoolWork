/**
 * Tests the use of exceptions on methods that calculate the multiplication
 * of the numbers from 1 to 10 entered as Strings (ie. "one" to "ten").
 * You are to complete the following:
 * <p>
 * - Complete the safeMultiplyStrings which calls multiplyStrings, but handles the IllegalArgumentException
 */
public class MultiplyStrings
{

    private static final String[] NUM_STRINGS = {
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"};

    /**
     * Finds the index of the given String in NUM_STRINGS
     *
     * @param num A number inputted as an English word
     * @return The index of the number, or -1 if it is not there
     */
    public static int indexOf(String num)
    {
        for (int i = 0; i < NUM_STRINGS.length; i++) {
            if (num.equals(NUM_STRINGS[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Multiplies the two numbers given as English words. Can only handle integers
     * from "one" to "ten". Otherwise throws an IllegalArgumentException.
     *
     * @param num1 The first number to multiply
     * @param num2 The second number to multiply
     * @return The result of the multiplication
     */
    public static int multiplyStrings(String num1, String num2)
    {
        int value1 = indexOf(num1);
        int value2 = indexOf(num2);
        if (value1 < 0) {
            throw new IllegalArgumentException("Input " + num1 + " is not valid");
        }
        if (value2 < 0) {
            throw new IllegalArgumentException("Input " + num2 + " is not valid");
        }
        return value1 * value2;
    }

    /**
     * Uses multiplyStrings above to multiply the two numbers given as English
     * words. Prints the output and handles IllegalArgumentExceptions
     *
     * @param num1 The first number to multiply, given as an English word
     * @param num2 The second number to multiply, given as an English word
     */
    public static void safeMultiplyStrings(String num1, String num2)
    {
        //$start
        // Call multiplyStrings on num1 and num2 and print out the value
        // Make sure to put the call to multiplyStrings inside a try-catch
        // black and handle the IllegalArgumentException. If an exception
        // occurs, print out the error message
        try {
            int value = multiplyStrings(num1, num2);
            System.out.println(value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        //$end
    }

    public static void main(String[] args)
    {
        System.out.println("------ TEST 1: Check that handles valid input ------");
        System.out.println("one times four = 4");
        System.out.print("OUTPUT:   ");
        safeMultiplyStrings("one", "four");
        System.out.println("EXPECTED: 4");

        System.out.println("\nten times nine = 90");
        System.out.print("OUTPUT:   ");
        safeMultiplyStrings("ten", "nine");
        System.out.println("EXPECTED: 90");

        System.out.println("\nthree times five = 15");
        System.out.print("OUTPUT:   ");
        safeMultiplyStrings("three", "five");
        System.out.println("EXPECTED: 15");

        System.out.println("\n------ TEST 2: Test that exceptions are handled correctly ------");
        System.out.println("checking first input - eleven is too high.");
        System.out.print("OUTPUT:   ");
        safeMultiplyStrings("eleven", "four");
        System.out.println("EXPECTED: Input eleven is not valid");

        System.out.println("\nchecking second input - fifteen is too high");
        System.out.print("OUTPUT:   ");
        safeMultiplyStrings("one", "fifteen");
        System.out.println("EXPECTED: Input fifteen is not valid");
    }
}
