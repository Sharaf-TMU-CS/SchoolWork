/*
 * You are to complete a method that takes in a 2D array, and checks if all values in the array are the same.
 *
 * For example, in the 2D array ( 3 rows X 4 columns) :
 *
 *  7 7 7 7
 *  7 7 7 7
 *  7 7 7 7
 *
 *  all elements are equal to 7 and the method should return true.
 *
 *  In the 2D array (3 rows X 2 columns):
 *
 *  3 3
 *  3 5
 *  3 3
 *
 *  one element is 5 and the others are 3 therefore the array is not all equal and the method should return false.
 */

import java.util.Arrays;

public class AllEqual2D
{
    /**
     * Determines if all integer elements in a two-dimensional array are identical
     *
     * Array is assumed to have at least one element. The original array should not be changed in any way
     *
     * @param values two-dimensional array to be examined.
     * @return true if all values identical, false otherwise
     */
    public static boolean allEqualValues2DArray(int[][] values)
    {
        //-----------Start below here. To do: approximate lines of code = 6
        //
        // Notice that if all elements in the array are equal, then they must be equal to the element at valuest[0][0]
        // Thus, you can check if all elements are equal by checking if each element is equal to the value
        // at values[0][0].
        // Do so using a nested loop that goes through each integer element stored array and compares it to the
        // element at values[0][0]. If you ever find they are not equal, you can return false. If all comparisons
        // are true, you should return true.
        //
        // HINT: recall that values.length stores the number of rows in the 2D array, values[i].length stores the
        // number of elements in row i
    	for (int i=0; i<values.length; i++)  {
        	for  (int  j=0; j<(values[i]).length; j++) {
        		if (values[i][j] != values[0][0]) {
        			return false;
        		}
        	}
        }
        return true;

        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        int[][] not_equal_4x3 = {{0, 4, 5}, {2, 4, 9}, {0, 2, 7}, {7, 3, 6}};
        int[][] equal_4x2 = {{4, 4}, {4, 4}, {4, 4}, {4, 4}};
        int[][] equal_3x3 = {{8, 8, 8}, {8, 8, 8}, {8, 8, 8}};
        int[][] not_equal_3x3 = {{8, 8, 8}, {8, 7, 8}, {8, 8, 8}};

        System.out.println("------ Test on Non-Equal 4x3 array ------");
        runTest(not_equal_4x3, false);

        System.out.println("\n\n------ Test on Equal 4x2 array ------");
        runTest(equal_4x2, true);

        System.out.println("\n\n------ Test on Equal 3x3 array ------");
        runTest(equal_3x3, true);

        System.out.println("\n\n------ Test on Not Equal 3x3 array ------");
        runTest(not_equal_3x3, false);
    }

    public static void runTest(int[][] testArray, boolean expected_output)
    {
        int [][] copy = copy2DArray(testArray);
        System.out.println("The test array is " + Arrays.deepToString(copy));
        boolean output = allEqualValues2DArray(copy);

        boolean pass = true;
        System.out.println("OUTPUT of allEqualValues2DArray:   " + output);
        if (output != expected_output) {
            System.out.println("EXPECTED of allEqualValues2DArray: " + expected_output);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        if (!are2DArraysEqual(testArray, copy)) {
            System.out.println("    INCORRECT - The input array list has been changed to " + Arrays.deepToString(copy));
            pass = false;
        }

        if (pass) {
            System.out.println("*** TEST PASSES ***");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************");
        }
    }

    /**
     * Checks that the 2D integer arrays are equal
     *
     * @param array1 The first array
     * @param array2 The second array
     * @return If they are equal or not
     */
    public static boolean are2DArraysEqual(int [][] array1, int [][] array2) {
        if (array1 == null || array2 == null) {
            return array1 == array2;
        }

        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                return false;
            }
            for (int j = 0; j <array1[i].length; j++) {
                if (array1[i][j] != array2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Copies a 2D array.
     *
     * @param toCopy The array to copy
     * @return The copy
     */
    public static int [][] copy2DArray(int [][] toCopy) {
        int [][] copy = new int [toCopy.length][];
        for (int i = 0; i < toCopy.length; i++) {
            copy[i] = Arrays.copyOf(toCopy[i], toCopy[i].length);
        }
        return toCopy;
    }
}
