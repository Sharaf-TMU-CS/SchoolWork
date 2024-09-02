import java.util.Arrays;

/**
 * A class to calculate the area of several SodaCans. You are to complete the
 * following:
 * <p>
 * - Complete the necessary additions in Soda.java
 * - Complete the method totalMeasure which calculates the total measure over all the Measurable
 * items in a given array
 */
public class SodaCanTester
{
    /**
     * Calculates the total measure over all the given Measurable items.
     *
     * For an empty list, should return 0.0.
     *
     * @param items the items
     * @return the total measure of the items
     */
    private static double totalMeasure(Measurable[] items)
    {
        //$start get the measure from all objects in the array, add them up and
        // return the total
        double totalArea = 0.0;
        for (Measurable s : items) {
            totalArea = totalArea + s.getMeasure();
        }
        return totalArea;
        //$end
    }

    public static void main(String[] args)
    {
        SodaCan[] sodaCans = new SodaCan[4];
        sodaCans[0] = new SodaCan(2, 3);
        sodaCans[1] = new SodaCan(3, 3);
        sodaCans[2] = new SodaCan(5, 7);
        sodaCans[3] = new SodaCan(1, 1);

        System.out.println("------ TEST 1: Test GetMeasure Directly ------");
        runGetMeasureTest(sodaCans[0], 94.25);
        runGetMeasureTest(sodaCans[1], 113.10);
        runGetMeasureTest(sodaCans[2], 527.79);
        runGetMeasureTest(sodaCans[3], 12.57);

        System.out.println("\n------ TEST 2: Test totalMeasure ------");

        runGetTotalMeasureTest(sodaCans, 747.70);

        Measurable [] smaller = Arrays.copyOf(sodaCans, 3);

        runGetTotalMeasureTest(smaller, 735.13);

        System.out.println("\n------ TEST 3: Test totalMeasure Empty Array ------");
        runGetTotalMeasureTest(new SodaCan[0], 0.0);
    }

    public static void runGetMeasureTest(Measurable m, double expected) {
        System.out.println("Testing on " + m);
        double output = m.getMeasure();

        printTestResult(testDoubleOutput("getMeasure", output, expected, 2));
    }

    public static void runGetTotalMeasureTest(Measurable [] items, double expected) {
        System.out.println("Initial List is " + Arrays.toString(items));
        double output = totalMeasure(items);

        printTestResult(testDoubleOutput("totalMeasure", output, expected, 2));
    }

    public static boolean testDoubleOutput(String methodName, double output, double expected, int digits)
    {
        String pf = "%." + digits + "f\n";
        System.out.printf("OUTPUT of " + methodName + ":   " + pf, output);
        if (Math.abs(output - expected) >= Math.pow(10, -1 * digits)) {
            System.out.printf("EXPECTED of " + methodName + ": " + expected);
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
