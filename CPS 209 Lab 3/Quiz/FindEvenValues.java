/**
 * Create a method called findEvenValues which takes in an ArrayList of integers and returns an array list of integers
 * containing the even numbers in the input list in the same order they appear.
 *
 * For example, if the input is [3, 5, 4, 8, 7, 11, 20, 5, 8, 44, 78], then the output should be [4, 8, 20, 8, 44, 78]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class FindEvenValues
{

    //-----------Start below here. To do: approximate lines of code = 6
    //
    // Create a method called findEvenValues that has a single input parameter which is a ArrayList<Integer>.
    // It should return an ArrayList<Integer> which contains the values in the input list that are even
    public static ArrayList<Integer> findEvenValues(ArrayList<Integer> x) {
    	ArrayList<Integer> y = new ArrayList<Integer>();
    	for (int i=0;  i<x.size(); i++)  {
    		if (x.get(i)%2 == 0)  {
    			y.add(x.get(i));
    		}
    	}
    	return y;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public static void main(String[] args)
    {
        System.out.println("------ Test on ArrayList of Size 11 ------");
        int [] data1 = {3, 5, 4, 8, 7, 11, 20, 5, 8, 44, 78};
        int [] expected1 = {4, 8, 20, 8, 44, 78};

        runTest(data1, expected1);

        System.out.println("\n\n------ Test on ArrayList of Size 7 ------");
        int [] data2 = {20, 2, 4, 8, 7, 11, 77};
        int [] expected2 = {20, 2, 4, 8};

        runTest(data2, expected2);

        System.out.println("\n\n------ Test on Empty ArrayList ------");
        int [] data3 = {};
        int [] expected3 = {};

        runTest(data3, expected3);
    }

    public static void runTest(int [] testArray, int [] expected) {
        ArrayList<Integer> testList = getArrayListFromArray(testArray);
        ArrayList<Integer> copy = getArrayListFromArray(testArray);
        ArrayList<Integer> expectedList = getArrayListFromArray(expected);

        System.out.println("The test array is " + testList);
        ArrayList<Integer> output = findEvenValues(copy);

        boolean pass = true;
        System.out.println("OUTPUT of findEvenValues:   " + output);
        if (!output.equals(expectedList)) {
            System.out.println("EXPECTED of findEvenValues: " + expectedList);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        if (!copy.equals(testList)) {
            System.out.println("    INCORRECT - The input array list has been changed to " + copy);
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
     * Creates an ArrayList from a given array of values.
     *
     * @param values The array of values
     * @return An ArrayList
     */
    public static ArrayList<Integer> getArrayListFromArray(int [] values) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        return list;
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
