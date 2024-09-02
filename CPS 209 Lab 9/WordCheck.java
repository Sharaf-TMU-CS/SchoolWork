import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
   This program checks to see what percent of the unique words in one file
   are used in another file. You are to complete the following:

     - Write a static method called readWords that reads in the words in a file into a Set
     - Complete the percentageWords method
 */
public class WordCheck
{
	/**
	 Reads all words from a file and puts them into a set. All the words should be converted to lower case before
	 added to the set.

	 @param filename the name of the file
	 @return a set with all lowercase words in the file. Here, a
	 word is a sequence of upper- and lowercase letters.
	 */
	//$start Create a static method called readWords which takes in a filename and returns a Set of String objects
	// Make it throw a FileNotFoundException
	public static Set<String> readWords(String filename) throws FileNotFoundException
	{
		// Iterate through the file using a scanner
		// Use scanner.useDelimiter("[^a-zA-Z]+");
		// This line sets the delimiter as anything that is not a letter
		// Make sure all the words are turned to lower case
		Set<String> words = new TreeSet<String>();
		Scanner scanner = new Scanner(new File(filename));
		scanner.useDelimiter("[^a-zA-Z]+");
		while (scanner.hasNext()) {
			words.add(scanner.next().toLowerCase());
		}
		return words;
	}
	//$end

	/**
	 * Returns the percentage of words in set1 that also appear in set2. So if there are 50 words in set1
	 * and 30 of them appear in set2 (which holds 45 words), then the returned value is 100.0 * 30/ 50.0 = 60.0
	 *
	 * @param set1 The first set
	 * @param set2 The second set
	 * @return The percentage of words
	 */
	public static double getWordPercentage(Set<String> set1, Set<String> set2)
	{
		//$start
		int count = 0 ;

		for (String word : set1) {
			if (set2.contains(word)) {
				count++;
			}
		}
		return 100.0 * count / (double) set1.size() ;
		//$end
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("------- Test 1: Testing readWords ------");
		System.out.println("WARNING: THIS TEST ONLY CHECKS THAT THE RIGHT NUMBER OF WORDS WERE FOUND");
		System.out.println("IT DOES NOT CHECK THAT YOU EXTRACTED THE RIGHT SET OF WORDS");

		runReadWordsTest("catInHat.txt", 236);
		runReadWordsTest("catInTheHatHalf.txt", 50);
		runReadWordsTest("small_text.txt", 8);

		System.out.println("------ Test 2: Percentage of words in catInTheHat.txt that are in catInTheHatHalf.txt ------");
		runGetPercentageTest("catInHat.txt", "catInTheHatHalf.txt", 21.2);

		System.out.println("------ Test 3: catInTheHatHalf.txt in catInHat.txt------");
		runGetPercentageTest("catInTheHatHalf.txt", "catInHat.txt", 100.0);

		System.out.println("------ Test 3: catInHat.txt in small_text.txt------");
		runGetPercentageTest("catInHat.txt", "small_text.txt", 0.8);

		System.out.println("------ Test 3: small.txt in catInHat.txt :------");
		runGetPercentageTest("small_text.txt", "catInHat.txt", 25.0);
	}

	public static void runReadWordsTest(String filename, int numWords) throws FileNotFoundException {

		System.out.println("Read file " + filename);
		Set<String> set = readWords(filename);

		printTestResult(testIntOutput("set.size()", set.size(), numWords));
	}

	public static void runGetPercentageTest(String filename1, String filename2, double expected) throws FileNotFoundException {
		System.out.println("Filename 1: " + filename1);
		System.out.println("Filename 2: " + filename2);
		Set<String> set1 = readWords(filename1);
		Set<String> set2 = readWords(filename2);

		double output = getWordPercentage(set1, set2);
		printTestResult(testDoubleOutput("getWordPercentage", output, expected, 1));
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

