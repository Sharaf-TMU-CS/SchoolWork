import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * You are given a file "babynames.txt", which lists the top 1000 most popular
 * baby names in the USA in 1990 for each of boys and girls. The given file is
 * ordered by popularity.
 * <p>
 * Your task is to generate two new files, one which contains the list of the
 * top 1000 boys names and one which contains the list of the top 1000 girls
 * names. The resulting files should be ordered alphabetically.
 * <p>
 * You should complete the following tasks:
 * <p>
 * - Complete the lineHandler method which takes in a line of text from the baby names files, extracts relevant data, and adds them to the corresponding ArrayLists
 * - Complete outputBabyList which takes in an ArrayList of BabyInfo objects and outputs them to the given file name
 * - Create a Comparator that can be used to sort an ArrayList of BabyInfo objects alphabetically
 * - Complete the code in main that extracts the baby names file line by line, sorts the ArrayLists, and outputs the ArrayList values
 */
public class BabyNamesSeparator
{

    /**
     * Handles a line in the baby names file that contains baby names and count information.
     * BabyInfo objects are then constructed and added to ArrayLists, one for boys and one
     * for girls
     *
     * @param line  The line of text to extract baby information from
     * @param boys  The ArrayList of boys to add to
     * @param girls The ArrayList of girls to add to
     */
    public static void lineHandler(String line, ArrayList<BabyInfo> boys, ArrayList<BabyInfo> girls)
    {
        //$start
        // Takes in a line of the baby names file, extracts the names and counts, and creates
        // a BabyInfo object for each baby. These are then added to the corresponding ArrayList
        //
        // The format of each line is 1\tBoyName\tBoyCount\tGirlName\tGirlCount

        // Create a scanner to extract parts of the line
        Scanner lineScanner = new Scanner(line);

        // Get the rank
        lineScanner.next();

        // Get the boy name and count, create a new BabyInfo object and add it to the boys ArrayList
        // Remember you can use next vs nextInt for different purposes
        String boyName = lineScanner.next();
        int count = lineScanner.nextInt();
        boys.add(new BabyInfo(boyName, count));

        // Repeat how you handled the boy name for the girl name
        String girlName = lineScanner.next();
        count = lineScanner.nextInt();
        girls.add(new BabyInfo(girlName, count));
        //$end
    }

    /**
     * Outputs the given ArrayList of BabyInfo objects to the given output file
     *
     * @param babies     The ArrayList of baby objects
     * @param outputFile The name of the output file
     * @throws IOException
     */
    public static void outputBabyList(ArrayList<BabyInfo> babies, String outputFile) throws IOException
    {
        //$start
        // This code should take in an ArrayList of BabyInfo objects and output them to the given file
        // Create a PrintWriter for the given outputFile
        PrintWriter writer = new PrintWriter(outputFile);

        // The first two lines should be "Popularity in 1990" and "Rank\tName\tCount"
        writer.println("Popularity in 1990");
        writer.println("Rank\tName\tCount");

        // Loop through the babies in the given ArrayList and print out a line
        // The format should be the number (ie. count in the array list + 1) followed by tab ("\t")
        // and then you can use the baby info toString for the rest
        for (int i = 0; i < babies.size(); i++) {
            writer.print("" + (i + 1) + "\t");
            writer.println(babies.get(i));
        }

        // Remember to close the writer
        writer.close();
        //$end
    }


    //$start
    // Create a comparator that will compare the baby names alphabetically
    private static class BabyComparator implements Comparator<BabyInfo>
    {

        public int compare(BabyInfo o1, BabyInfo o2)
        {
            return o1.getName().compareTo(o2.getName());
        }
    }
    //$end

    public static void main(String[] args) throws IOException
    {
        ArrayList<BabyInfo> boys = new ArrayList<>();
        ArrayList<BabyInfo> girls = new ArrayList<>();

        String inputFilename = "babynames.txt";
        String boysOutputFilename = "boys.txt";
        String girlsOutputFilename = "girls.txt";

        //$start This code should read in the baby names file, and fill
        // the two ArrayLists
        // Create a scanner for baby names that reads
        Scanner scanner = new Scanner(new File(inputFilename));

        // Skip the first two lines
        scanner.nextLine();
        scanner.nextLine();

        // Iterate through all lines in the input file and call
        // lineHandler to populate the ArrayLists
        while (scanner.hasNextLine()) {
            lineHandler(scanner.nextLine(), boys, girls);
        }
        //$end

        System.out.println("------ Test 1: Test that everything has been read in correctly ------");
        System.out.println("Check sizes of the array lists");
        printTestResult(testIntOutput("boys.size()", boys.size(), 1000));
        printTestResult(testIntOutput("girls.size()", girls.size(), 1000));

        System.out.println("Check that first element is correct");
        printTestResult(testStringOutput("boys.get(0).toString()", boys.get(0).toString(), "Michael\t65268"));
        printTestResult(testStringOutput("girls.get(0).toString()", girls.get(0).toString(), "Jessica\t46459"));

        System.out.println("Check that last element is correct");
        printTestResult(testStringOutput("boys.get(999).toString()", boys.get(999).toString(), "Deante\t111"));
        printTestResult(testStringOutput("girls.get(999).toString()", girls.get(999).toString(), "Louise\t182"));


        //$start Now you will sort the array lists and output them
        // perform the sort using Collections.sort and your comparator
        Collections.sort(boys, new BabyComparator());
        Collections.sort(girls, new BabyComparator());

        // Use outputBabyList to output the two array lists to their corresponding file
        outputBabyList(boys, boysOutputFilename);
        outputBabyList(girls, girlsOutputFilename);
        //$end


        System.out.println("\n------ TEST 2: Checks boys.txt has correct values after sorting ------");
        Scanner boyScanner = new Scanner(new File(boysOutputFilename));
        String output = "";
        for (int i = 0; i < 10; i++) {
            output += boyScanner.nextLine() + "\n";
        }

        String expected = "Popularity in 1990\n" +
                "Rank\tName\tCount\n" +
                "1\tAaron\t14545\n" +
                "2\tAbdul\t122\n" +
                "3\tAbel\t603\n" +
                "4\tAbraham\t1128\n" +
                "5\tAbram\t125\n" +
                "6\tAdam\t14709\n" +
                "7\tAdan\t335\n" +
                "8\tAddison\t247\n";
        printTestResult(testStringOutput("first 10 in boys.txt", output, expected));

        System.out.println("\n------ TEST 3: Checks girls.txt has correct values after sorting ------");
        Scanner girlScanner = new Scanner(new File(girlsOutputFilename));
        output = "";
        for (int i = 0; i < 10; i++) {
            output += girlScanner.nextLine() + "\n";
        }
        expected = "Popularity in 1990\n" +
                "Rank\tName\tCount\n" +
                "1\tAbbey\t507\n" +
                "2\tAbbie\t311\n" +
                "3\tAbby\t1293\n" +
                "4\tAbigail\t3719\n" +
                "5\tAdrian\t376\n" +
                "6\tAdriana\t2148\n" +
                "7\tAdrianna\t850\n" +
                "8\tAdrianne\t257\n";

        printTestResult(testStringOutput("first 10 in girls.txt", output, expected));
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
