/**
 * This class represents a student with a name, number of completed quizzes,
 * and total score on all quizzes. For this problem, you should complete the
 * following:
 * <p>
 * - Complete the "getAverageScore" method
 * - Complete the "addQuiz" method which adds a new quiz and its score to the
 * students totals
 * - Complete the "getTotalScore" method which returns the total quiz score
 * for the student
 * - Complete the "getName" method which returns the student's name
 * <p>
 * This class is tested by StudentTester.java, which will also help you further
 * understand the method definitions.
 */
public class Student
{
    private String name; // the name of the student
    private int numQuizzes; // number of quizzes
    private double totalQuizScore; // total score for the student

    /**
     * Constructor method: initialize name with given name1,
     * set other instance variables to 0
     *
     * @param name1 the name of the student
     */
    public Student(String name1)
    {
        name = name1;
        numQuizzes = 0;
        totalQuizScore = 0.0;
    }

    /**
     * Gets the average quiz score
     *
     * @return the average of all quizzes
     */
    public double getAverageScore()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Complete this method
        return totalQuizScore/numQuizzes;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Adds on another quiz - add to total quiz score and number of quizzes
     *
     * @param score the score the student had on the quiz
     */
    public void addQuiz(double score)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        // Complete this method
        totalQuizScore += score;
        numQuizzes++;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Gets the current totalQuizScore level of the student.
     *
     * @return the current totalQuizScore
     */
    public double getTotalScore()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Complete this method
        return totalQuizScore;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Gets the number of quizzes this student has taken.
     *
     * @return The number of quizzes this student has taken
     */
    public int getNumQuizzes()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Complete this method
        return numQuizzes;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Gets the name of the student
     *
     * @return the name
     */
    public String getName()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Complete this method
        return name;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}



