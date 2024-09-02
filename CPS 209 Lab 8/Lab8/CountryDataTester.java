/**
 * This program reads in country data from a file into an ArrayList, then can be
 * used to find the largest country by area, by density, or the smallest by density.
 * You are to complete the following:
 * <p>
 * - Complete the readCountries method which reads in the country data to an ArrayList of Country objects
 * - Make a Comparator that compares according to area
 * - Make a Comparator that compares according to density
 * - Use those comparators to find the max area country, max density country, and min density country
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CountryDataTester
{

    public static ArrayList<Country> readCountries(String filename)
    {
        ArrayList<Country> countries = new ArrayList<>();

        //$start Inside a try-catch block, create a scanner to iterate through
        // the lines in the file, extract each country, and add it to the above
        // ArrayList of countries
        try {

            // Create a scanner for the given filename
            // Skip the first line which just has column information
            Scanner fileScanner = new Scanner(new File(filename));
            fileScanner.nextLine();

            // Iterate through the lines
            // Use a second scanner to pull out necessary information to construct a Country object
            // Remember to set the delimiter correct for this data file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                String name = lineScanner.next();
                int population = lineScanner.nextInt();
                int area = lineScanner.nextInt();

                countries.add(new Country(name, population, area));
            }

        } catch (IOException e) {
            System.out.println(filename + ": File not found");
        }
        // Catch the IOException and print out "filename: File not found" where filename is the filename
        // Should return an empty array list in this case
        //$end
        return countries;
    }

    //$start Create a Comparator that compares Country objects by area
    private static class AreaComparator implements Comparator<Country>
    {
        public int compare(Country o1, Country o2)
        {
            return o1.getArea() - o2.getArea();
        }
    }
    //$end

    //$start Create a Comparator that compares Country objects by density. Before you
    // do the division, remember to cast the values to doubles
    private static class DensityComparator implements Comparator<Country>
    {
        public int compare(Country o1, Country o2)
        {
            double density1 = ((double) o1.getPopulation()) / ((double) o1.getArea());
            double density2 = ((double) o2.getPopulation()) / ((double) o2.getArea());

            if (density1 < density2)
                return -1;
            else if (density1 > density2) {
                return 1;
            }
            return 0;
        }
    }
    //$end

    public static void main(String[] args)
    {
        System.out.println("------ TEST 1: Checks that readCountries works with correct data ------");
        String filename = "countrydata.txt";
        ArrayList<Country> countries = readCountries(filename);
        printTestResult(testIntOutput("countries.size()", countries.size(), 238));

        System.out.println("\n------ TEST 2: Get country with max area ------");
        Country maxArea = null;

        //$start Set maxArea as the Country with the maximum area. Use
        // Collections.max and your AreaComparator
        maxArea = Collections.max(countries, new AreaComparator());
        //$end
        printTestResult(testStringOutput("maxArea.toString()", maxArea.toString(), "(Russia, Pop:140702094, Area:17075200)"));

        System.out.println("\n------ TEST 3: Get country with max density ------");
        Country maxDensity = null;

        //$start Set maxDensity as the Country with the maximum density. Use
        // Collections.max and your DensityComparator
        maxDensity = Collections.max(countries, new DensityComparator());
        //$end
        printTestResult(testStringOutput("maxDensity.toString()", maxDensity.toString(), "(Macau, Pop:460823, Area:28)"));

        System.out.println("\n------ TEST 4: Get country with min density ------");
        Country minDensity = null;

        //$start Set minDensity as the Country with the minimum density. Use
        // Collections.min and your DensityComparator
        minDensity = Collections.min(countries, new DensityComparator());
        //$end
        printTestResult(testStringOutput("minDensity.toString()", minDensity.toString(), "(Greenland, Pop:56326, Area:2166086)"));

        System.out.println("\n\n--- TEST 5: Checks on a missing file");
        System.out.print("OUTPUT:   ");
        ArrayList<Country> missing_countries = readCountries("missing_countrydata.txt");
        System.out.println("EXPECTED: missing_countrydata.txt: File not found");

        System.out.println("\ncheck array list is empty");
        printTestResult(testIntOutput("missing_countries.size()", missing_countries.size(), 0));
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
}
