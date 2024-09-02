/**
 * Searches all files for the specified word and finds all the lines that contain the given word
 * containing the specified word. You are to complete the following:
 * <p>
 * - implement findAndPrint
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWordInFile
{

    /**
     Searches file for a word, and returns a String containing every line in the file that has the given word in it.
     Each line should include the line number, followed by the line itself, followed by a new line character.

     @param wordToFind the word to find
     @param filename the filename for the file to search
     */
    public static String findAndPrint(String wordToFind, String filename)
    {
        //$start fill in the method. Make use of the contains() method of class String
        // Make a String to store the output, and add to it every line in the filename with the given word. The line
        // should include the line number in the file
        // If you find the word in a line of a file, print the file name followed by a ": " followed by the line
        // Hint: use a try{..}catch(){...} block. If the file is not found, return the String containing the filename
        // followed by " not found!"
        String output = "";
        try {
            Scanner inFile = new Scanner(new File(filename));
            int count = 1;
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                if (line.contains(wordToFind)) {
                    output += count + ": " + line + "\n";
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            return filename + " not found!";
        }
        return output;
        //$end
    }

    public static void main(String[] args)
    {
        System.out.println("------ TEST 1: Checks for \"sandwich\" in first file  ------");
        String expected = "1: I love a good sandwich.\n3: A sandwich can be very healthy.\n";
        runFindAndPrintTest("file1.txt", "sandwich", expected);

        System.out.println("\n------ TEST 2: Checks for \"healthy\" in first file ------");
        expected = "3: A sandwich can be very healthy.\n4: Or they can be unhealthy.\n";
        runFindAndPrintTest("file1.txt", "healthy", expected);

        System.out.println("\n------ TEST 3: Checks for \"sandwich\" in second file ------");
        expected = "1: I love to eat a sandwich at lunch.\n3: A sandwich is very filling.\n";
        expected += "4: One of my favorite type of sandwich is grilled cheese.\n5: I like a peanut butter and jelly sandwich too.\n";
        runFindAndPrintTest("file2.txt", "sandwich", expected);

        System.out.println("\n------ TEST 4: Checks for \"at\" in second file ------");
        expected = "1: I love to eat a sandwich at lunch.\n2: I also occasionally eat them at dinner.\n";
        runFindAndPrintTest("file2.txt", "at", expected);

        System.out.println("\n------ TEST 5: Checks for \"sandwich\" in third file ------");
        expected = "1: If you buy a sandwich at a restaurant they can be quite expensive.\n2: That's why I often make a sandwich at home.\n";
        runFindAndPrintTest("file3.txt", "sandwich", expected);

        System.out.println("\n------ TEST 6: Checks for \"at\" in third file ------");
        expected = "1: If you buy a sandwich at a restaurant they can be quite expensive.\n2: That's why I often make a sandwich at home.\n";
        runFindAndPrintTest("file3.txt", "at", expected);

        System.out.println("\n------ TEST 7: Checks on a missing file ------");
        expected = "file4.txt not found!";
        runFindAndPrintTest("file4.txt", "sandwich", expected);
    }

    public static void runFindAndPrintTest(String filename, String wordToFind, String expected)
    {
        String output = findAndPrint(wordToFind, filename);
        boolean pass = testStringOutput("findAndPrint", "\n" + output, "\n" + expected);
        printTestResult(pass);
    }

    public static void printTestResult(boolean pass)
    {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }

    public static boolean testStringOutput(String methodName, String output, String expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (!output.equals(expected)) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
