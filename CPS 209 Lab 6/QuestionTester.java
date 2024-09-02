/**
 * This class tests the Question classes and subclasses.
 * Your work is in the todo region in FillInQuestion.java.
 * DO NOT CHANGE ANYTHING IN THIS FILE
 */
public class QuestionTester
{
    public static void main(String[] args)
    {

        System.out.println("------ Test CheckAnswer on Default Question ------");
        Question defaultQ = new Question();
        runCheckTest(defaultQ, "2", true);
        runCheckTest(defaultQ, "3", false);

        System.out.println("------ Test CheckAnswer on Given Question ------");
        Question basicQ = new Question("What does OOP stand for?");
        basicQ.setAnswer("Object-Oriented Programming");

        runCheckTest(basicQ, "Object-Oriented Programming", true);
        runCheckTest(basicQ, "Functional Programming", false);

        System.out.println("------ Test GetAnswer on FillInQuestion ------");
        Question fillIn = new FillInQuestion("The inventor of Java was _James Gosling_.");
        runGetAnswerTest(fillIn, "James Gosling");

        System.out.println("------ Test GetAnswer on FillInQuestion ------");
        Question fillIn2 = new FillInQuestion("The inventor of the theory of general relativity is _Albert Einstein_.");
        runCheckTest(fillIn2, "Albert Einstein", true);
        runCheckTest(fillIn2, "Henri Poincare", false);
    }

    public static void runGetAnswerTest(Question q, String expectedAnswer)
    {
        System.out.print("Question: ");
        q.display();

        String answer = q.getAnswer();
        printTestResult(testStringOutput("getAnswer", answer, expectedAnswer));
    }

    public static void runCheckTest(Question q, String answer, boolean expectedResult)
    {
        System.out.print("Question: ");
        q.display();
        System.out.println("Answer to check: " + answer);

        boolean isCorrect = q.checkAnswer(answer);
        printTestResult(testBooleanOutput("checkAnswer", isCorrect, expectedResult));
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

    public static boolean testBooleanOutput(String methodName, boolean output, boolean expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (output != expected) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
