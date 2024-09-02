/**
 * A class for an appointment that occurs every day, starting on the given day.
 * You need to complete the following tasks:
 *
 * - Complete the constructor method
 * - Complete the occursOn method
 */
public class DailyAppointment extends Appointment
{

    /**
     * Initializes appointment for a given date, and for all days
     * after the given date.
     *
     * @param year        the year
     * @param month       the month
     * @param day         the day
     * @param description the text description of the appointment
     */
    public DailyAppointment(int year, int month, int day, String description)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Initialize the inherited variables - make use of the super() keyword
        super(year, month, day, description);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * An appointment occurs on the given day if the date is later than the
     * stored day.
     * <p>
     * For example, if the appointment date is set for Feb 2, 2023. Then an
     * appointment will occur on Feb 3, 2023 and on Feb 4, 2023, and on March 1,
     * 2023, and on January 1, 2024, and so on. However, it will not occur on
     * Feb 1, 2023.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     * @return true if base appointment is earlier than the appointment date
     */
    public boolean occursOn(int year, int month, int day)
    {
        //-----------Start below here. To do: approximate lines of code = 9
        // Override occursOn. Checks the given date parameters year, month, day to see if it is a later
        // date than the appointment date stored in this object. Return true if so, false otherwise
        if (year >= getYear()) {
            if (year == getYear()) {
                if (month >= getMonth()) {
                    if (month == getMonth()) {
                        if (day >= getDay())
                        return true;
                    }
                    else  {
                        return true;
                    }
                }
            }
            else {
                return true;
            }
        }
        return false;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}

