/**
 * This code tests your Student class. You should NOT edit it. All changes to be made are in Student.java
 */
public class StudentTester
{
    /**
     * Tests the methods of the Student class.
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        Student student = new Student("Jane Doe");

        System.out.println("------ Test Constructor ------");
        runTests(student, "Jane Doe", 0, 0);

        System.out.println("------ Test After Add 4 Quizzes ------");
        student.addQuiz(8);
        student.addQuiz(6);
        student.addQuiz(10);
        student.addQuiz(8);

        runTests(student, "Jane Doe", 4, 32);

        System.out.println("------ Test Average After 4 Quizzes ------");
        double expectedAv = 8.0;
        double av = student.getAverageScore();
        System.out.println("OUTPUT of getAverageScore:   " + av);
        if (Double.isNaN(av) || Math.abs(av - expectedAv) > 0.00001)
        {
            System.out.println("EXPECTED of getAverageScore: " + expectedAv);
            printTestResult(false);
        }

        System.out.println("------ Test After 5 Quizzes ------");
        student.addQuiz(18);
        runTests(student, "Jane Doe", 5, 50);

        System.out.println("------ Test Average After 4 Quizzes ------");
        expectedAv = 10.0;
        av = student.getAverageScore();
        System.out.println("OUTPUT of getAverageScore:   " + av);
        if (Double.isNaN(av) || Math.abs(av - expectedAv) > 0.00001)
        {
            System.out.println("EXPECTED of getAverageScore: " + expectedAv);
            printTestResult(false);
        }
    }

    public static void runTests(Student s, String expectedName, int expectedNumQuizzes, double expectedQuizTotal)
    {
        boolean pass = true;

        String name = s.getName();
        System.out.println("OUTPUT of getName:   " + name);
        if(!name.equals(expectedName)) {
            System.out.println("EXPECTED of getName: " + expectedName);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        int numQuizzes = s.getNumQuizzes();
        System.out.println("OUTPUT of getNumQuizzes:   " + numQuizzes);
        if(numQuizzes != expectedNumQuizzes) {
            System.out.println("EXPECTED of getNumQuizzes: " + expectedNumQuizzes);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        double quizTotal = s.getTotalScore();
        System.out.println("OUTPUT of getTotalScore:   " + quizTotal);
        if(quizTotal != expectedQuizTotal) {
            System.out.println("EXPECTED of getTotalScore: " + expectedQuizTotal);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        printTestResult(pass);
    }
    public static void printTestResult(boolean pass) {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }
}


