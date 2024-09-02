/**
 * This is a simple program to count the lines in a data file. You are to
 * complete the lineCounter method.
 */

import java.util.*;
import java.io.*;

public class LineCount
{

    public static int lineCounter(String fileName)
    {
        //$start Use a try{...}catch(){...} block and open a file "data.txt"
        // using the File class. Create a Scanner object and pass in the File
        // reference. Read the lines one at a time from the file
        // and count them. Return the count
        // Return 0 if an exception is thrown
        int count = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);


            while (scanner.hasNext()) {
                count++;
                scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
        //$end
    }

    public static void main(String[] args)
    {
        System.out.println("------ TEST 1: Checks on one file ------");
        runLineCounterTest("data.txt", 13);
        //System.out.println("OUTPUT:   " + lineCounter("data.txt"));
        //System.out.println("EXPECTED: 13");

        System.out.println("\n--- TEST 2: Checks on a second file");
        runLineCounterTest("lines.txt", 9);
        //System.out.println("OUTPUT:   " + lineCounter("lines.txt"));
        //System.out.println("EXPECTED: 9");
    }

    public static void runLineCounterTest(String file, int expected)
    {
        int output = lineCounter(file);
        boolean pass = testIntOutput("lineCounter", output, expected);
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
