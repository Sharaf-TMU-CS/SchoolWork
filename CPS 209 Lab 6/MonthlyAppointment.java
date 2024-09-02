
/**
 * A class for an appointment that occurs every month, starting on the given day.
 * You need to complete the following tasks:
 *
 * - Complete the constructor method
 * - Complete the occursOn method
 */
public class MonthlyAppointment extends Appointment
{
    /**
     * Initializes appointment for a given date.
     *
     * @param year        the year
     * @param month       the month
     * @param day         the day
     * @param description the text description of the appointment
     */
    public MonthlyAppointment(int year, int month, int day, String description)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Initialize the inherited variables - make use of the super() keyword
        // with proper parameters
        super(year, month, day, description);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * An appointment occurs on the given day if it is the same day of the month
     * but any month on or after the stored month.
     *
     * For example, if the appointment date is set for Feb 2, 2023. Then an
     * appointment will occur on Feb 2, 2023 and on Mar 2, 2023, and on April 2,
     * 2023, and on January 2, 2024, and so on. But it will not occur on Jan 2, 2023
     * or Feb 5, 2023.
     *
     * Note, you do not have to check if the given date is valid (ie. Feb 31).
     * .
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @return true if day matches the appointment date and is later than the
     * appointment date stored in this object
     */
    public boolean occursOn(int year, int month, int day)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        // Override the occursOn() method. Check to see if the appointment occurs on the
        // same day of the month and is later than the appointment date stored in this object .
        if (day == getDay())  {
            if (year >= getYear())  {
                if (year == getYear()) {
                    if (month >= getMonth()) {
                        return true;
                    }
                }
                else  {
                    return true;
                }
            }
        }
        return false;
    
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
