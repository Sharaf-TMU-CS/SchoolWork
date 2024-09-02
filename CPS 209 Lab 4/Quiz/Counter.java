/**
 * This class models a tally counter. It stores the current count and a maximum
 * value. You should complete the following:
 *
 * - Implement the "count" method which increments the counter, and resets the
 * counter if the maximum is exceeded. When a reset happens, "Limit Exceeded"
 * should also be printed
 *
 * This class is tested by CounterTester.java
 */
public class Counter
{
    private int value = 0;
    private int max = 0;

    public void setLimit(int maximum)
    {
        max = maximum;
    }

    /**
     * Gets the current value of this counter.
     *
     * @return the current value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Advances the value of this counter by 1.
     */
    public void count()
    {
        //-----------Start below here. To do: approximate lines of code = 4
        // increments value by 1. if value exceeds limit, println "Limit Exceeded" and reset value to 0
        // Be careful about case and spaces in the "Limit Exceeded" String
        value++;
        if (value > max) {
            System.out.println("Limit Exceeded");
            value = 0;
        }
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Resets the value of this counter to 0.
     */
    public void reset()
    {
        value = 0;
    }
}
