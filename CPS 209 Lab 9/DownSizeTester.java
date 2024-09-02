import java.util.LinkedList ;
import java.util.ListIterator ;
/**
   Write a static method which uses a ListIterator to remove every 2nd element from the LinkedList.
 */

public class DownSizeTester
{
	/**
	 Removes the first, third, fifth, ... elements from a list (i.e. the elements at indices 0, 2, 4, ...).
	 @param list a linked list of String elements
	 */
	public static void downsize(LinkedList<String> list)
	{
		//$start Use a ListIterator to iterate over the list and remove elements
		// Be careful about the end of the list
		ListIterator<String> iterator = list.listIterator() ;
		while (iterator.hasNext()) {
			iterator.next() ;
			iterator.remove() ;
			if (iterator.hasNext())
				iterator.next() ;
		}
		//$end
	}

	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;
		list.add("Sunday 1") ;
		list.add("Monday 2") ;
		list.add("Tuesday 3") ;
		list.add("Wednesday 4") ;
		list.add("Thursday 5") ;
		list.add("Friday 6") ;
		list.add("Saturday 7") ;
		list.add("Sunday 8") ;
		list.add("Monday 9") ;

		System.out.println("\n------ TEST 1: Remove when 9 elements ------");
		runDownsizeTest(list, "[Monday 2, Wednesday 4, Friday 6, Sunday 8]");

		System.out.println("\n------ TEST 2: Remove when 4 elements ------");
		runDownsizeTest(list, "[Wednesday 4, Sunday 8]");

		System.out.println("\n------ TEST 3: Remove when 2 elements");
		runDownsizeTest(list, "[Sunday 8]");

		System.out.println("\n------ TEST 4: Remove when 1 elements ------");
		runDownsizeTest(list, "[]");

		System.out.println("\n\n--- TEST 5: Remove when 0 elements");
		runDownsizeTest(list, "[]");
	}

	public static void runDownsizeTest(LinkedList<String> list, String expected) {
		System.out.println("Original list: " + list);
		downsize(list);

		printTestResult(testStringOutput("list.toString() after downsize", list.toString(), expected));
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
