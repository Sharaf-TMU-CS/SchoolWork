/**
 * For this question, you are to complete a method which takes in a Queue and the
 * number of elements in that queue to remove, and returns that number of elements
 * in a LinkedList. If more elements are requested than are left in the Queue, then
 * all remaining elements should be returned.
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueTester
{

	/**
	 * Removes and returns a group of Strings from the list. The list is returned as a LinkedList of Strings.
	 * If there are more elements requested than are in a list, then all remaining elements should be returned.
	 *
	 * @param queue The queue to remove elements from
	 * @param groupMemberSize The number of elements in the next group to remove
	 * @return A LinkedList of the removed elements
	 */
	public static LinkedList<String> getNextGroup(Queue<String> queue, int groupMemberSize)
	{
		//$start Create an empty Linked List of Strings to hold the group members
		// Then remove groupMemberSize strings (representing the names of people in the group) from the queue
		// and add each name string to the list
		LinkedList<String> groupList = new LinkedList<String>();

		for (int i = 0; i < groupMemberSize; i++)
		{
			if (queue.isEmpty())
			{
				return groupList;
			}
			groupList.add(queue.remove());
		}
		return groupList;
		//$end
	}

	public static void main(String [] args)
	{
		String [] names = {"Will", "Grace",
				"Rachel", "Ross", "Phoebe", "Chandler", "Monica", "Joey",
				"Jerry", "Elaine", "Kramer", "George",
				"Beth"
		};

		Queue<String> queue = new LinkedList<String>();
		
		for (String name : names)
		{
			queue.add(name);
		}

		System.out.println("----- TEST 1: First 2 elements ------");
		getNextGroupTest(queue, 2, "[Will, Grace]", "[Rachel, Ross, Phoebe, Chandler, Monica, Joey, Jerry, Elaine, Kramer, George, Beth]");

		System.out.println("\n------ TEST 2: Next 6 elements ------");
		getNextGroupTest(queue, 6, "[Rachel, Ross, Phoebe, Chandler, Monica, Joey]", "[Jerry, Elaine, Kramer, George, Beth]");

		System.out.println("\n------ TEST 3: Next 0 elements ------");
		getNextGroupTest(queue, 0, "[]", "[Jerry, Elaine, Kramer, George, Beth]");

		System.out.println("\n------ TEST 4: Next 4 elements ------");
		getNextGroupTest(queue, 4, "[Jerry, Elaine, Kramer, George]", "[Beth]");

		System.out.println("\n------ TEST 5: Next 3 elements though only 1 left ------");
		getNextGroupTest(queue, 3, "[Beth]", "[]");

		System.out.println("\n--- TEST 1: Get 2 elements though it is empty");
		getNextGroupTest(queue, 2, "[]", "[]");
	}

	public static void getNextGroupTest(Queue<String> queue, int groupSize, String expectedList, String expectedRemaining) {
		System.out.println("Removing " + groupSize + " elements from  " + queue);
		String output = getNextGroup(queue, groupSize).toString();
		String queueToString = queue.toString();

		boolean pass = testStringOutput("getNextGroup", output, expectedList);
		if (!queueToString.equals(expectedRemaining)) {
			System.out.println("    QUEUE HAS CHANGED INCORRECTLY");
			System.out.println("REMAINING QUEUE IS " + queue);
			System.out.println("EXPECTED QUEUE     " + expectedRemaining);
			pass = false;
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
		if (!output.equals(expected)) {
			System.out.println("EXPECTED of " + methodName + ": " + expected);
			System.out.println("    INCORRECT OUTPUT");
			return false;
		}
		return true;
	}
}
