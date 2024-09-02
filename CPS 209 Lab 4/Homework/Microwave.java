/**
 * This class represents a microwave oven. It stores a timer as an integer and
 * a string indicating whether the power is high or low. For this problem, you
 * should complete the following:
 * <p>
 * - Complete the constructor to initialize the timer to 0 and the power level
 * to low
 * - Complete the "increaseTime" method to increase the time on the timer by
 * 30 seconds
 * - Complete the "switchPower" method to switch between low and high power, or
 * vice versa
 * - Complete the "reset" method which resets the timer to 0 and power level to
 * low
 * <p>
 * This class is tested by MicrowaveTester.java, which will also help you further
 * understand the method definitions.
 */
public class Microwave
{
    private int timer;
    private String power; //"HIGH" or "LOW"

    /**
     * Creates a microwave with 0 seconds on the timer and at LOW power.
     */
    public Microwave()
    {
        //-----------Start below here. To do: approximate lines of code = 2
        // Complete this constructor to initialize instance variables
        timer = 0;
        power = "LOW";
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Increases the time on the timer by 30 seconds.
     */
    public void increaseTime()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // complete the method
        timer += 30;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Switches the power level from LOW to HIGH, or vice versa.
     */
    public void switchPower()
    {
        //-----------Start below here. To do: approximate lines of code = 4
        // Complete this method.
        if (power.equals("LOW")) {
            power = "HIGH";
        }
        else if (power.equals("HIGH")) {
            power = "LOW";
        }
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Resets the microwave to its initial state.
     */
    public void reset()
    {
        //-----------Start below here. To do: approximate lines of code = 2
        // Complete this method.
        power = "LOW";
        timer = 0;        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public String getSettings()
    {
        return "Set for " + timer + " seconds at power " + power;
    }

}
