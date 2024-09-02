/**
 * Tests the Counter class. You should NOT edit anything below. Only edit Counter.java where indicated
 */
public class CounterTester
{
    public static void main(String[] args)
    {
		System.out.println("------ Test Simple 1 ------");
        Counter c = new Counter();
        c.setLimit(100);

		runTest(c, 50, 50, 0);

		runTest(c, 51, 0, 1);

		System.out.println("\n\n------ Test Simple 2 ------");
		c.setLimit(23);

		runTest(c, 52, 4, 2);

		System.out.println("\n\n------ Test With Limit 0 ------");
		c = new Counter();
		c.setLimit(0);

		runTest(c, 5, 0, 5);
    }


	public static void runTest(Counter c, int timesToCount, int expectedTally, int expectedLimitHits)
	{
		boolean pass = true;

		System.out.println("Calling count " + timesToCount + " times");
		for (int i = 0; i < timesToCount; i++) {
			c.count();
		}
		System.out.println("\t\"Limit Exceeded\" should be printed " + expectedLimitHits + " times ");
		int output = c.getValue();
		System.out.println("OUTPUT of getValue:   " + output);

		if (output != expectedTally) {
			System.out.println("EXPECTED of getValue: " + expectedTally);
			System.out.println("********************* INCORRECT OUTPUT *********************");
			pass = false;
		} else {
			System.out.println("    Output is correct");
		}
	}
}
