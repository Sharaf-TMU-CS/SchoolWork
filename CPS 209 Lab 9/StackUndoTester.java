import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * For this question, you will implement an undo functionality on a list of words.
 * The possible actions are "addFirst", which adds a given word to the beginning of
 * the list, and "addLast", which adds a given word to the end of the list. You
 * should complete the undo method, which undoes the next element in the actions stack.
 */
public class StackUndoTester
{
	/**
	 * Takes in a LinkedList of strings and a stack actions used to construct that list, and undoes the last action.
	 * For example, if the last action was "addLast", this method removes the String at the end of the list (since it
	 * was added last). The only two actions are "addLast" and "addFirst".
	 *
	 * @param list The list of Strings
	 * @param actions The stack of actions
	 */
	static void undo(LinkedList<String> list, Stack<String> actions)
	{
		//$start Use the actions stack to undo the last action applied to the list of words
		//an action is either "addFirst" or "addLast"  Hint: check to ensure the stack is not empty
		if (actions.isEmpty()) return;

		String action = actions.pop();

		if (action.equals("addLast"))
			list.removeLast();
		else if (action.equals("addFirst"))
			list.removeFirst();
		//$end
	}

	public static void main(String [] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		Stack<String> actions = new Stack<String>();

		// Build a list of words by performing a sequence of actions, where each action has a word parameter
		String commands = "addLast cat addLast bear addLast porcupine addFirst lion addFirst eagle";
		String action = "";
		String word = "";

		System.out.println("BUILDING WORD LIST");
		Scanner scanner = new Scanner(commands);
		while (scanner.hasNext())
		{
			action = scanner.next();
			word = scanner.next();
			System.out.println("Action: " + action + ", word: " + word);
			
			if (action.equals("addLast"))
			{
				list.addLast(word);
				actions.push(action);
			}
			if (action.equals("addFirst"))
			{
				list.addFirst(word);
				actions.push(action);
			}
			System.out.println("\tCurrent list: " + list);
		}

		System.out.println("\n\n------ TEST 1: First undo ------");
		undoTest(list, actions, "[lion, cat, bear, porcupine]", "[addLast, addLast, addLast, addFirst]");

		System.out.println("\n------ TEST 2: Second undo ------");
		undoTest(list, actions, "[cat, bear, porcupine]", "[addLast, addLast, addLast]");

		System.out.println("\n------ TEST 3: Third undo ------");
		undoTest(list, actions, "[cat, bear]", "[addLast, addLast]");

		System.out.println("\n------ TEST 4: Fourth undo ------");
		undoTest(list, actions, "[cat]", "[addLast]");

		System.out.println("\n------ TEST 5: Fifth undo ------");
		undoTest(list, actions, "[]", "[]");

		System.out.println("\n------ TEST 5: Call undo on empty list ------");
		undoTest(list, actions, "[]", "[]");
	}

	public static void undoTest(LinkedList<String> list, Stack<String> actions, String expectedList, String expectedStack) {
		System.out.println("Current list:  " + list);
		System.out.println("Current stack: " + actions);
		System.out.println();
		undo(list, actions);

		boolean pass = testStringOutput("list.toString() after undo", list.toString(), expectedList);
		if(!actions.toString().equals(expectedStack)) {
			System.out.println("    STACK HAS CHANGED INCORRECTLY");
			System.out.println("REMAINING STACK IS " + actions);
			System.out.println("EXPECTED STACK     " + expectedStack);
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
