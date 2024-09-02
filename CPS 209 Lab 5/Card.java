/**
 * A class for id-type cards. Complete the following tasks:
 * <p>
 * - Add accessor methods for each of the instance variables
 */
public class Card
{
    private String name;
    private String id;
    private int expiryYear;

    public Card(String name, String id, int expiryYear)
    {
        this.name = name;
        this.id = id;
        this.expiryYear = expiryYear;
    }

    // Add accessor methods called getName, getID, getExpiryYear
    //-----------Start below here. To do: approximate lines of code = 6
    //
    public String getName(){
        return name;
    }
    
    public String getID(){
        return id;
    }
    public int getExpiryYear(){
        return expiryYear;
    }
    
    
    
    

    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

}
