/**
   For this question, you will use a ListIterator to remove all elements that contain
   the given String. For this question, you need to complete the removeContains method.
 */
import java.util.LinkedList ;
import java.util.ListIterator ;

public class ListRemoveContainsTester
{
	/**
	 * Removes all Strings in the given list that contain the given String as a substring.
	 * Run the tests to see expected behaviour.
	 *
	 * @param list The input list
	 * @param toRemove Remove any strings that contain this as a substring
	 */
	public static void removeContains(LinkedList<String> list, String toRemove)
	{
		//$start Use an iterator to remove all elements containing toRemove
		// Start by creating a list iterator.
		ListIterator<String> iterator = list.listIterator() ;
		while(iterator.hasNext()) {
			if (iterator.next().contains(toRemove))
				iterator.remove() ;
		}
		//$end
	}
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;

		System.out.println("------ Test 1: 5 Element List");
		list.add("throw");
		list.add("place");
		list.add("something");
		list.add("thing");
		list.add("tiny");
		removeContainsTest(list, "th", "[place, tiny]");

		System.out.println("\n------ TEST 2: Empty list ------");
		list.clear();
		removeContainsTest(list, "anything", "[]");

		System.out.println("\n------ TEST 3: Given string not contained in any element ------");
		for (int i = 1 ; i <= 25 ; i++) {
			list.add(i + "") ;
		}
		removeContainsTest(list, "A", "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]");

		System.out.println("\n------ TEST 4: Remove any Number with a 3 in it ------");
		removeContainsTest(list, "3", "[1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 25]");
	}

	public static void removeContainsTest(LinkedList<String> list, String toRemove, String expected) {
		System.out.println("Original list: " + list);
		System.out.println("Removing strings containing \"" + toRemove + "\"");
		removeContains(list, toRemove);
		printTestResult(testStringOutput("list.toString()", list.toString(), expected));
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