/**
 * A class for a driver's license. Complete the following tasks
 * <p>
 * - An accessor for the license type
 * - A method that updates the license type
 */
public class DriversLicense extends Card
{
    public enum LicenseType
    {G1, G2, G}

    private LicenseType type;

    public DriversLicense(String name, String id, int expiryYear, LicenseType type)
    {
        super(name, id, expiryYear);
        this.type = type;
    }

    // Add an accessor method called getLicenseType
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public LicenseType getLicenseType(){
        return type;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Add a method called updateLicenseType which takes in a license type and stores it
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public void updateLicenseType(LicenseType newType){
        type = newType;
    }
    

    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
