/**
 * A class for a Task that has a priority and an expected time in minutes.
 * You are to complete the following:
 *
 * - Add the compareTo method needed so that Task properly implements Comparable
 */
public class Task implements Comparable<Task>
{
    private String description;
    private int priority;
    private int estimatedMinutes;

    public Task(String description, int priority, int estimatedMinutes)
    {
        this.description = description;
        this.priority = priority;
        this.estimatedMinutes = estimatedMinutes;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPriority()
    {
        return priority;
    }

    public int getEstimatedMinutes()
    {
        return estimatedMinutes;
    }

    public String toString()
    {
        return description;
    }

    //$start
    // Add a compareTo method. Should compare by priority first
    // and then break ties using the estimated minutes left (lower is better)
    public int compareTo(Task o)
    {
        if(priority != o.priority)
        {
            return priority - o.priority;
        }
        return estimatedMinutes - o.estimatedMinutes;
    }
    //$end
}
