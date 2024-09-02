/**
 * This program reverses each line in a file and writes it to another file.
 * The idea is that if the input filename is mouse.txt, and it contains
 * <p>
 * mouse
 * A mouse (plural: mice) is a small mammal belonging to the order
 * of rodents. The best known mouse species is the common house mouse
 * <p>
 * Then a file named esuom.txt will be created that contains
 * <p>
 * esuom
 * redro eht ot gnignoleb lammam llams a si )ecim :larulp( esuom A
 * esuom esuoh nommoc eht si seiceps esuom nwonk tseb ehT .stnedor fo
 * <p>
 * <p>
 * You are to complete the following tasks:
 *
 * - complete the reverseString method that takes in a String and reverses it
 * - complete the reverseFilename method that takes in a filename and comes up with the correct filename for the reverse
 * - write reverseFile, which takes in a file and creates a file with the reverse of each line
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Reverse
{
	/**
	 * Reverses the input string.
	 *
	 * @param s The string to reverse
	 * @return The reversed string
	 */
	public static String reverseString(String s) {
		//$start
		String reverse = "";

		for(int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		return reverse;
		//$end
	}

	/**
	 * Revered a given filename. Assume the filename ends with .txt and everything before .txt should be reversed.
	 * For example, if the filename is "happy.txt", the reversed filename is "yppah.txt".
	 *
	 * @param filename The filename to reverse
	 * @return The reversed filename
	 */
	public static String reverseFilename(String filename) {
		//$start
		// HINT: use your implemented reverse method
		int period = filename.indexOf(".");

		String newName = reverseString(filename.substring(0, period));
		newName += ".txt";
		return newName;
		//$end
	}

	/**
	 * Reverses each line in the file and outputs it to the file with the reversed filename. Note that the order
	 * of the lines should not be changed. So the first line in the input file is also the first line in the
	 * new file, but characters are reversed.
	 *
	 * DO NOT CATCH EXCEPTIONS HERE. SET THE FILE TO THROW IOException s
	 *
	 * @param filename The input file name (String)
	 */
	//$start Method is called reverseFile
	// HINT: Use the helper methods above
	public static void reverseFile(String filename) throws IOException {
		Scanner scanner = new Scanner(new File(filename));
		ArrayList<String> lines = new ArrayList<String>();

		String newFilename = reverseFilename(filename);
		PrintWriter pw = new PrintWriter(newFilename);

		while(scanner.hasNextLine()) {
			String next = scanner.nextLine();
			next = reverseString(next);
			pw.println(next);
		}

		scanner.close();
		pw.close();
	}
	//$end

	public static void main(String[] args)
	{
		System.out.println("------ Test 1: Check that reverseString Works ------");
		printTestResult(testStringOutput("reverseString(\"happy\")", reverseString("happy"), "yppah"));
		printTestResult(testStringOutput("reverseString(\"\")", reverseString(""), ""));
		printTestResult(testStringOutput("reverseString(\"hello world\")", reverseString("hello world"), "dlrow olleh"));

		System.out.println("\n------ Test 2: Check that reverseFilename Works ------");
		printTestResult(testStringOutput("reverseFilename(\"happy.txt\")", reverseFilename("happy.txt"), "yppah.txt"));
		printTestResult(testStringOutput("reverseFilename(\"blah.txt\")", reverseFilename("blah.txt"), "halb.txt"));
		printTestResult(testStringOutput("reverseFilename(\"mouse.txt\")", reverseFilename("mouse.txt"), "esuom.txt"));

		System.out.println("\n------ Test 3: Check that reverseFile Works on Small File -----");
		String expected = "enil tsrif eht si sihT\nenil dnoceS\nsenil fo tsedriht ehT\n";
		reverseFilenameTest("blah.txt", "halb.txt", expected);

		expected = " esuom\nredro eht ot gnignoleb lammam llams a si )ecim :larulp( esuom A\nesuom esuoh nommoc eht si seiceps esuom nwonk tseb ehT .stnedor fo\n";
		expected += "niatrec ,secalp emos nI .tep ralupop a osla si tI .)sulucsum suM(\n tsom yb netae si tnedor sihT .nommoc osla era ecim dleif fo sdnik\n";
		expected += " nwonk era yehT .selgae dna skwah sa hcus sdrib suorovinrac egral\n.retlehs yllanoisacco dna doof rof semoh edavni ot\n";
		reverseFilenameTest("mouse.txt", "esuom.txt", expected);
	}

	public static void reverseFilenameTest(String filename, String outFilename, String expected) {
		boolean pass = true;
		try {
			reverseFile(filename);
			Scanner scan = new Scanner(new File(outFilename));

			String output = "";
			while (scan.hasNextLine()) {
				output += scan.nextLine() + "\n";
			}
			pass = testStringOutput("check file " + outFilename, "\n" + output, "\n" + expected);
		} catch (IOException e) {
			pass = false;
			System.out.println("**** ERROR: EXCEPTION INCORRECTLY THROWN ****");
			System.out.println(e);
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
