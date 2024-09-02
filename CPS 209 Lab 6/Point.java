/**
 * A class for holding the x-y coordinates of a point in 2D space.
 * You are to complete the following tasks:
 * <p>
 * - complete the equals method
 * - complete the toString method
 */
public class Point
{
    private double x_coord;
    private double y_coord;

    public Point(double x_coord, double y_coord)
    {
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public double getX()
    {
        return x_coord;
    }

    public double getY()
    {
        return y_coord;
    }

    // Should check that the x and y coordinates are equal
    public boolean equals(Object other)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        if (other.toString().equals(toString()))
            return true;
        return false;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public String toString()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //
        // Should output a string like "(5, 1)" for x-coordinate 5 and y-coordinate 1
        return "("+x_coord+", "+y_coord+")";
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
