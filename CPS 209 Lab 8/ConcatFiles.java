/**
 * This program concatenates several files to produce another file.
 * Create the concatenateFiles method which accomplishes this.
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class ConcatFiles
{
    /**
     * Takes in an array of files and writes them all out to the file with the given outFile name. That is,
     * the output file should be the concatenation of the given input files.
     *
     * DO NOT CATCH EXCEPTIONS HERE. SET THE FILE TO THROW IOException s
     *
     * @param files The list of input filenames
     * @param outfile The output file name
     */
    //$start
    // Method name is concatenateFiles
    public static void concatenateFiles(String [] files, String outfile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outfile);

        for (String filename : files) {
            Scanner scanner = new Scanner(new File(filename));
            while(scanner.hasNextLine()) {
                pw.println(scanner.nextLine());
            }
        }
        pw.close();
    }
    //$end

    public static void main(String[] args) throws FileNotFoundException
    {
        String [] twoFiles = {"cat.txt", "dog.txt"};
        runConcatFilesTest(twoFiles, "twoFilesOutput.txt", 2659, 61);

        String [] threeFiles = {"cat.txt", "dog.txt", "mouse2.txt"};
        runConcatFilesTest(threeFiles, "threeFilesOutput.txt", 3047, 68);

        String [] oneFile = {"cat.txt"};
        runConcatFilesTest(oneFile, "oneFileOutput.txt", 2158, 52);

        String [] noFiles = {};
        runConcatFilesTest(noFiles, "noFilesOutput.txt", 0, 0);
    }

    public static void runConcatFilesTest(String [] filenames, String outFile, int charCount, int lineCount) {
        boolean pass = true;

        try {
            concatenateFiles(filenames, outFile);

            int count = 0;
            int lines = 0;
            Scanner scan = new Scanner(new File(outFile));
            scan.useDelimiter("");
            while(scan.hasNext()) {
                String ch = scan.next();
                count++;
                if (ch.equals("\n")) {
                    lines++;
                }
            }
            pass = testIntOutput("char count of outFile", count, charCount);
            if (!testIntOutput("line count of outFile", lines, lineCount)) {
                pass = false;
            }

        } catch (IOException e) {
            pass = false;
            System.out.println("**** ERROR: EXCEPTION INCORRECTLY THROWN ****");
            System.out.println(e);
        }
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

    public static boolean testIntOutput(String methodName, int output, int expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (output != expected) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
