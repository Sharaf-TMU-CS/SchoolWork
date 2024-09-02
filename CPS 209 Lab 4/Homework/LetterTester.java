/**
 * This code tests your Letter class. You should NOT edit it. All changes to be made are in Letter.java
 */
public class LetterTester
{
    public static void main(String[] args)
    {
        Letter dearJohn = new Letter("Sally", "John");

        System.out.println("------ Testing Adding One Line ------");
        dearJohn.addLine("I'm sorry but it's just not going to work out.");
        runTest(dearJohn, 1, "Dear John:\n\nI'm sorry but it's just not going to work out.\n\nSincerely,\nSally");

        System.out.println("\n------ Testing Adding Two More Lines ------");
        dearJohn.addLine("I'm taking the dog.");
        dearJohn.addLine("I'm keeping the ring.");
        String expected = "Dear John:\n\nI'm sorry but it's just not going to work out.\nI'm taking the dog.\nI'm keeping the ring.\n\nSincerely,\nSally";
        runTest(dearJohn, 3, expected);

        System.out.println("\n------ Testing Deleting A Line ------");
        System.out.println("Removing line 2");
        dearJohn.removeLine(2);
        expected = "Dear John:\n\nI'm sorry but it's just not going to work out.\nI'm keeping the ring.\n\nSincerely,\nSally";
        runTest(dearJohn, 2, expected);

        System.out.println("\n------ Testing Deleting A Line Again ------");
        System.out.println("Removing line 1");
        dearJohn.removeLine(1);

        expected = "Dear John:\n\nI'm keeping the ring.\n\nSincerely,\nSally";
        runTest(dearJohn, 1, expected);

        System.out.println("\n------ Testing Adding A Line Again ------");
        dearJohn.addLine("Thank you for giving it to me.");
        expected = "Dear John:\n\nI'm keeping the ring.\nThank you for giving it to me.\n\nSincerely,\nSally";
        runTest(dearJohn, 2, expected);

        System.out.println("\n------ Testing Removing Line That Isn't There ------");
        dearJohn.removeLine(5);
        expected = "Dear John:\n\nI'm keeping the ring.\nThank you for giving it to me.\n\nSincerely,\nSally";
        runTest(dearJohn, 2, expected);
    }

    public static void runTest(Letter let, int expectedLines, String expectedLetter)
    {
        boolean pass = true;

        int outputLines = let.getNumberOfLines();
        System.out.println("OUTPUT of getNumberOfLines:  " + outputLines);

        if (outputLines != expectedLines) {
            System.out.println("EXPECTED of getNumberOfLines: " + expectedLines);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        String outputLetter = let.getText();
        System.out.println("OUTPUT of getLetter:\n" + outputLetter);
        if (!outputLetter.equals(expectedLetter)) {
            System.out.println("EXPECTED of getLetter:\n" + expectedLetter);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }
}
