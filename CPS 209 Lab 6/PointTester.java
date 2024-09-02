import java.util.ArrayList;

/**
 * A Tester of the point class. You should complete the following tasks:
 *
 * - Complete the getDistance method
 * - Complete the getMaxDistance method
 * - Complete the getUniquePoints method
 */
public class PointTester
{
    /**
     * Calculate the distance between the two points. Recall that the distance
     * between (x1, y1) and (x2, y2) is given by
     *
     * sqrt((x1 - x2)^2 + (y1 - y2)^2)
     *
     * @param p1 The first point
     * @param p2 The second point
     * @return The distance between the points
     */
    public static double getDistance(Point p1, Point p2)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        // You may wish to use Math.sqrt and Math.pow for this method
        return Math.sqrt(Math.pow((p1.getX()-p2.getX()),  2.0) + Math.pow((p1.getY()-p2.getY()), 2.0));
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Returns the maximum distance between any two pair of points in the given
     * array list of points. That is, for points (p1, p2, p3), it will be the
     * maximum of the distances between p1 and p2, p1 and p3, and p2 and p3.
     *
     * @param points A list of points
     * @return The maximum of the distances between any two points in the list
     */
    public static double getMaxDistance(ArrayList<Point> points)
    {
        //-----------Start below here. To do: approximate lines of code = 7
        //
        double max = 0;
        double testMax = 0;
        for (int i=0; i<points.size();i++) {
            for (int j=0; j<points.size();j++) {
                testMax = Math.sqrt(Math.pow((points.get(i).getX()-points.get(j).getX()), 2.0) + Math.pow((points.get(i).getY()-points.get(j).getY()), 2.0));
                if (testMax > max) {
                    max = testMax;
                }
            }
        }
        return max;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Returns a new list that contains only the unique points in the
     * original list.
     *
     * @param points The list of points
     * @return A new list containing only the unique points in the original list
     */
    public static ArrayList<Point> getUniquePoints(ArrayList<Point> points)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        // HINT: Create a new list. Then iterate over the old list, checking if
        // each element is already in the new list.
        // You may wish to use the ArrayList "list.contains(e)" method to check if e
        // is in list. It uses equals to do the check
        for (int i=0; i<points.size();i++) {
            try {
                for (int j=0; j<points.size();j++) {
                    if (((points.get(i).toString()).equals(points.get(j).toString()))&&(j != i)) {
                        points.remove(j);
                        break;
                    }
                }
            }
            catch (Exception e) {
                break;
            }
        }
        return points;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }


    public static void main(String[] args)
    {
        System.out.println("------ Test 1: Check that Point toString works correctly ------");
        System.out.println("Test on p1 = (10, 20)");
        Point p1 = new Point(10, 20);
        runToStringTest(p1, "(10.0, 20.0)");

        System.out.println("Test on p2 = (-5, 20)");
        Point p2 = new Point(-5, 20);
        runToStringTest(p2, "(-5.0, 20.0)");

        System.out.println("Test on p3 = (13, -9)");
        Point p3 = new Point(13, -9);
        runToStringTest(p3, "(13.0, -9.0)");

        System.out.println("\n------ TEST 2: Check that equals works correctly ------");
        System.out.println("p1 equals p2?");
        runEqualsTest(p1, p2, false);

        System.out.println("p2 equals p1?");
        runEqualsTest(p2, p1, false);

        System.out.println("p1 equals p3?");
        runEqualsTest(p1, p3, false);

        Point p4 = new Point(10, 20);
        System.out.println("p4 is (10, 20)");
        System.out.println("p1 equals p4?");
        runEqualsTest(p1, p4, true);

        System.out.println("p4 equals p1?");
        runEqualsTest(p4, p1, true);

        System.out.println("\n------ TEST 3: Check that getDistance works correctly ------");
        System.out.println("distance from p1 to p2");
        runGetDistanceTest(p1, p2, 15.0);

        System.out.println("distance from p2 to p1");
        runGetDistanceTest(p2, p1, 15.0);

        System.out.println("distance from p1 to p3");
        runGetDistanceTest(p1, p3, 29.15);

        System.out.println("\n------ TEST 4: Check that getMaxDistance works correctly ------");
        ArrayList<Point> points = new ArrayList<>();
        runGetMaxDistanceTest(points, 0.0);

        points.add(p1);
        runGetMaxDistanceTest(points, 0.0);

        points.add(p2);
        runGetMaxDistanceTest(points, 15.0);

        points.add(p3);
        runGetMaxDistanceTest(points, 34.13);

        System.out.println("\n------ TEST 5: Check that getUniquePoints works correctly------");
        ArrayList<Point> emptyList = new ArrayList<>();
        runGetUniquePointsTest(emptyList, "[]");

        runGetUniquePointsTest(points, "[(10.0, 20.0), (-5.0, 20.0), (13.0, -9.0)]");

        points.add(p4);
        runGetUniquePointsTest(points, "[(10.0, 20.0), (-5.0, 20.0), (13.0, -9.0)]");
    }

    public static void runToStringTest(Point p, String expected)
    {
        String output = p.toString();
        printTestResult(testStringOutput("toString", output, expected));
    }

    public static void runEqualsTest(Point p1, Point p2, boolean expectedEquals)
    {
        boolean output = p1.equals(p2);
        printTestResult(testBooleanOutput("equals", output, expectedEquals));
    }

    public static void runGetDistanceTest(Point p1, Point p2, double expected)
    {
        double output = getDistance(p1, p2);
        printTestResult(testDoubleOutput("getDistance", output, expected, 2));
    }

    public static void runGetMaxDistanceTest(ArrayList<Point> points, double expected)
    {
        System.out.println("Testing on list " + points);
        double output = getMaxDistance(points);
        printTestResult(testDoubleOutput("getMaxDistance", output, expected, 2));
    }

    public static void runGetUniquePointsTest(ArrayList<Point> points, String expected)
    {
        System.out.println("Testing on list " + points);
        String output = getUniquePoints(points).toString();
        printTestResult(testStringOutput("getUniquePoints", output, expected));

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

    public static boolean testBooleanOutput(String methodName, boolean output, boolean expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (output != expected) {
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
}
