/**
 * A class for a Question on a quiz or test. You must create the checkAnswer method.
 */
class Question
{
    //instance variables
    private String text;
    private String answer;

    /**
     * A default constructor method that initializes text and answer
     */
    public Question()
    {
        text = "1 + 1 = ";
        answer = "2";
    }

    /**
     * A constructor method to initialize text to parameter questionText, set answer to empty String
     *
     * @param questionText the text of this question
     */
    public Question(String questionText)
    {
        text = questionText;
        answer = "";
    }

    /**
     * Sets the answer for this question.
     *
     * @param correctResponse the answer
     */
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse;
    }

    /**
     * Gets the answer for this question.
     *
     * @return the correct answer
     */
    public String getAnswer()
    {
        return answer;
    }

    /**
     * Checks a given response for correctness.
     *
     * @param response the response to check
     * @return true if the response was correct, false otherwise
     */
    //-----------Start below here. To do: approximate lines of code = 2
    // Create a method called checkAnswer that satisfies the above javadoc
    public boolean checkAnswer(String test){
        if (test.equals(answer)) {
            return true;
        }
        return false;
    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    /**
     * Sets the question text
     *
     * @param questionText the text of this question
     */
    public void setQuestion(String questionText)
    {
        text = questionText;
    }

    /**
     * Displays this question.
     */
    public void display()
    {
        System.out.println(text);
    }
}
