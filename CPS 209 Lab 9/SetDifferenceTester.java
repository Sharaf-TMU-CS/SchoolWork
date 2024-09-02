import java.util.TreeSet;
import java.util.Set;

/**
 * For this question, you are to implement a method that calculates the difference
 * between two given sets. This is a set containing the elements that are in one
 * of the given sets, but not both.
 */
public class SetDifferenceTester
{
    //$start
    // Calculates the set difference between the two given sets. These are the
    // elements that are in one set, but not the other.
    // Note, a new set should be created and the original sets should not be altered
    // Use a TreeSet to ensure when the sets are printed, they are printed in
    // alphabetical order
    public static Set<String> difference(Set<String> set1, Set<String> set2)
    {
        Set<String> diffSet = new TreeSet<>();

        for(String e : set1)
        {
            if (!set2.contains(e))
            {
                diffSet.add(e);
            }
        }

        for(String e : set2)
        {
            if (!set1.contains(e))
            {
                diffSet.add(e);
            }
        }
        return diffSet;
    }
    //$end

    public static void main(String[] args)
    {
        Set<String> set1 = new TreeSet<String>();
        Set<String> set2 = new TreeSet<String>();

        set1.add("A");
        set1.add("B");
        set1.add("C");
        set1.add("D");
        set1.add("F");
        set1.add("G");
        set1.add("H");
        set1.add("I");

        set2.add("F");
        set2.add("G");
        set2.add("H");
        set2.add("I");
        set2.add("J");
        set2.add("K");

        System.out.println("------ TEST 1: Difference between two non-empty ------");
        runDifferenceTest(set1, set2, "[A, B, C, D, J, K]");

        System.out.println("\n------ TEST 2: Difference between two non-empty sets, reversed ------");
        runDifferenceTest(set2, set1, "[A, B, C, D, J, K]");

        System.out.println("\n------ TEST 3: Difference between two non-empty sets ------");
        Set<String> set3 = new TreeSet<String>();
        set3.add("R");
        set3.add("B");
        set3.add("Q");
        set3.add("D");
        set3.add("S");
        set3.add("G");
        set3.add("H");
        set3.add("I");
        runDifferenceTest(set1, set3, "[A, C, F, Q, R, S]");

        System.out.println("\n------ TEST 4: Difference between a set and itself ------");
        runDifferenceTest(set1, set1, "[]");

        System.out.println("\n-------- TEST 5: Difference between a set and an empty set ------");
        set1 = new TreeSet<>();
        runDifferenceTest(set1, set2, "[F, G, H, I, J, K]");
    }

    public static void runDifferenceTest(Set<String> set1, Set<String> set2, String expected) {
        String set1String = set1.toString();
        String set2String = set2.toString();

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        String output = difference(set1, set2).toString();
        boolean pass = testStringOutput("difference", output, expected);

        if(!set1String.equals(set1.toString())) {
            pass = false;
            System.out.println("\tSet 1 has incorrectly changed to " + set1.toString());
        }
        if(!set2String.equals(set2.toString())) {
            pass = false;
            System.out.println("\tSet 2 has incorrectly changed to " + set2.toString());
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

    public static boolean testStringOutput(String methodName, String output, String expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);

        if (output == null && expected == null) {
            return true;
        } else if (output == null || !output.equals(expected)) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
