/**
   For this question, you have to write a static getStringOfList(list, index) method
   that constructs a string representation of a LinkedList and its iterator, given the list
   itself and the index that the iterator is at.

   For example, if the LinkedList contains elements "A", "B", "C", and "D" in that order, and
   the given index is 2, then the returned String should be "AB|CD", where the "|" indicates
   the location of the iterator.
 */
import java.util.LinkedList ;
import java.util.ListIterator ;

public class ListIteratorTester
{
	/**
	 A static method to return a string representation of the
	 list and the iterator.  Note that the listIterator method
	 nextIndex gives the index of the next element that would be
	 returned by a call to next, or list size if the list iterator
	 is at the end of the list. The four possible pictures for a
	 list [A,B,C] are:
	 |ABC             here index would be 0
	 A|BC             here index would be 1
	 AB|C             here index would be 2
	 ABC|             here index would be 3 (i.e., the size of the list)

	 @param list the linked list of type LinkedList<String>
	 @param index of next element that the iterator would return by next
	 @return a string representation like A|BC
	 */

	public static String getStringOfList(LinkedList<String> list, int index)
	{
		//$start 1. initialize result to empty string ;
		String result = "" ;
		//2. if index is 0 ;
		if (index == 0)
			//then put "|" on result ;
			result += "|" ;
		//3. initialize count ;
		int count = 0 ;
		//4. for each element in the list ;
		for (String str : list) {
			//5. append element to result ;
			result += str ;
			//6. increment count ;
			count++ ;
			//7. if count is index ;
			if (count == index)
				//then append "|" ;
				result += "|" ;
		}
		//8. return result.
		return result ;
		//$end
	}

	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;
		ListIterator<String> iterator = list.listIterator() ;

		// List is empty
		System.out.println("----- Test 1: Empty list ------");
		testGetStringOfList(list, iterator.nextIndex(), "|");

		// Add one element using iterator
		System.out.println("--- Test 2: Added one element");
		System.out.println("Adding \"A\" using iterator");
		iterator.add("A") ;
		testGetStringOfList(list, iterator.nextIndex(), "A|");

		// Add second element using iterator
		System.out.println("------ Test 3: Added second element ------");
		System.out.println("Adding \"B\" using iterator");
		iterator.add("B") ;
		testGetStringOfList(list, iterator.nextIndex(), "AB|");

		// Add third element using iterator
		System.out.println("------ Test 4: Added third element ------");
		System.out.println("Adding \"C\" using iterator");
		iterator.add("C") ;
		testGetStringOfList(list, iterator.nextIndex(), "ABC|");

		// Add fourth element using iterator
		System.out.println("------ Test 5: Added fourth element ------");
		System.out.println("Adding \"D\" using iterator");
		iterator.add("D") ;
		testGetStringOfList(list, iterator.nextIndex(), "ABCD|");

		// Reset iterator to the beginning
		System.out.println("------ Test 6: Reset iterator ------");
		iterator = list.listIterator() ;
		testGetStringOfList(list, iterator.nextIndex(), "|ABCD");

		// Remove next element (first element) if it is A
		System.out.println("------ Test 7: Remove first element ------");
		System.out.println("Call iterator.next() and then iterator.remove()");
		iterator.next();
		iterator.remove() ;
		testGetStringOfList(list, iterator.nextIndex(), "|BCD");

		// Move iterator forward one step
		System.out.println("------ Test 8: Move iterator forward one step ------");
		System.out.println("Call iterator.next()");
		iterator.next();
		testGetStringOfList(list, iterator.nextIndex(), "B|CD");

		System.out.println("------ Test 9: Iterate through remaining elements ------");
		// Iterator through remaining elements
		System.out.println("Call iterator.next() twice");
		iterator.next();
		iterator.next();
		testGetStringOfList(list, iterator.nextIndex(), "BCD|");
	}

	public static void testGetStringOfList(LinkedList<String> list, int index, String expected) {
		String output = getStringOfList(list, index);
		printTestResult(testStringOutput("getStringOfList", output, expected));
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
