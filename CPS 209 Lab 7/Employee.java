/**
 * A class for an employee. You are to complete the following
 * <p>
 * - Complete the constructor to initialize variables and throw an exception for hourly rate below minimum wage
 * - Complete the addHours to add hours and throw an exception for invalid input
 */
public class Employee
{
    private String name;
    private double hourlyRate;
    private double hours;
    private static final double MINIMUM_WAGE = 15.5;

    public Employee(String name, double hourlyRate)
    {
        //$start
        // Initialize all variables.
        // Throw an IllegalArgumentException if the given hourly rate is
        // below the minimum wage (use the static variable above for the amount).
        // Exception should have the message "Hourly rate below minimum wage"
        this.name = name;

        if (hourlyRate < MINIMUM_WAGE) {
            throw new IllegalArgumentException("Hourly rate below minimum wage");
        }
        this.hourlyRate = hourlyRate;
        this.hours = 0;
        //$end
    }

    public double getHours()
    {
        return hours;
    }

    public void addHours(double newHours)
    {
        //$start
        // Add newHours to the number of hours
        // If the given hours value is below 0.0, throw an IllegalArgumentException
        // with the message "Hours cannot be less than 0"
        if (newHours < 0.0) {
            throw new IllegalArgumentException("Hours cannot be less than 0");
        }
        hours += newHours;
        //$end
    }

    public double getPay()
    {
        double pay = hours * hourlyRate;
        hours = 0;
        return pay;
    }

    public String toString()
    {
        return "(Name: " + name + ", Rate: " + hourlyRate + ", Hours: " + hours + ")";
    }
}
