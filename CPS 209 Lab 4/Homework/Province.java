/**
 * This class represents a province with a name, population, and area. For this
 * problem, you should complete the following:
 * <p>
 * - Create a constructor that initializes the name, population, and area
 * according to given parameter values
 * - Complete the "getProvinceStats" method which returns a string with the
 * province's stats as specified
 * - Complete the "getPopulationDensity" method which returns the population
 * density
 * - Complete the "compareDensity" method which compares the density of another
 * province to this province and returns an integer value as specified
 * <p>
 * This class is tested by ProvinceTester.java, which will also help you further
 * understand the method definitions.
 */
public class Province
{

    private String name;
    private int population;
    private double area;

    /**
     * Create a constructor method that has 3 parameters,
     * one to initialize the name, one to initialize the
     * population and one to initialize the area
     */
    //-----------Start below here. To do: approximate lines of code = 4
    //
    public Province(String name, int population, double area){
        this.name = name;
        this.population = population;
        this.area = area;
    }

    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


    /**
     * Create a public method called getProvinceStats() that returns a String
     * containing the name of the province followed by " Population: " followed by
     * the population followed by " Area: " followed by the area
     */
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public String getProvinceStats() {
        return name + " Population: "+ population + " Area: " + area;
    } 
 
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


    /**
     * Create a public method getPopulationDensity() that returns a double
     * number representing the population density.
     */
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public double getPopulationDensity() {
        return population/area;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a public method int compareDensity(Province other) that returns
    // +1 if the this province density is > than the other province density
    // -1 if the this province density is < than the other province density
    // 0 if the densities are the same
    //-----------Start below here. To do: approximate lines of code = 4
    //
    public int compareDensity(Province other) {
        if ((population / area) > (other.population / other.area)) {
            return 1;
        }
        else if ((population / area) < (other.population / other.area)) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public String getName() {
        return name;
    }
}
