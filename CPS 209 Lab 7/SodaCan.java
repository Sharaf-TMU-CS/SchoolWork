/**
 * Class to get surface area and volume of a soda can. You are to
 * write the class definition and implement the getMeasure method.
 */
//$start Define the class SodaCan and have it implement Measurable
public class SodaCan implements Measurable
//$end
{
    private double height;
    private double radius;

    /**
     * Initializes a can with given height and radius.
     *
     * @param height the height
     * @param radius the radius
     */
    public SodaCan(double height, double radius)
    {
        this.height = height;
        this.radius = radius;
    }

    /**
     * Calculates the surface area of the soda can.
     *
     * @return the surface area of the soda can
     */
    public double getSurfaceArea()
    {
        return 2 * Math.PI * radius * (radius + height);
    }

    /**
     * Calculates the volume of the soda can.
     *
     * @return the volume of the soda can
     */
    public double getVolume()
    {
        return Math.PI * radius * radius * height;
    }

    public String toString() {
        return "Height: " + height + ", Radius: " + radius;
    }

    /**
     * Returns the area of the soda can.
     *
     * @return the area of the soda can
     */
    //$start write a method that correctly implements the Measurable interface
    // The method should return the surface area of the sodaCan object
    public double getMeasure()
    {
        return getSurfaceArea();
    }
    //$end
}
