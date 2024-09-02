/**
 * A class to keep track of, print, and compare addresses with and
 * without apartment numbers.
 * <p>
 * You should complete the equals method below and the needed tasks in
 * AddressTester.java
 */
public class Address
{
    private int streetNumber;
    private String apartment;
    private String street;
    private String city;
    private String province;
    private String postalCode;

    /**
     * Constructs an address with everything but an apartment number.
     *
     * @param streetNumber the house number as a string
     * @param street       the street as a string
     * @param city         the city as a string
     * @param province     the province as a string
     * @param postalCode   the postal code as a string
     */
    public Address(int streetNumber, String street, String city, String province, String postalCode)
    {
        this.streetNumber = streetNumber;
        this.apartment = "";
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Constructs an address with an apartment number
     *
     * @param streetNumber the house number as a string
     * @param apartment    the apartment number as a string
     * @param street       the street as a string
     * @param city         the city as a string
     * @param province     the province as a string
     * @param postalCode   the postal code as a string
     */
    public Address(int streetNumber, String apartment, String street,
                   String city, String province, String postalCode)
    {
        this.streetNumber = streetNumber;
        this.apartment = apartment;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    public String toString()
    {
        if (apartment.equals("")) {
            return "[" + streetNumber + " " + street + ", " + city + ", " + province + ",  " + postalCode + "]";
        }
        return "[" + apartment + " - " + streetNumber + " " + street + ", " + city + ", " + province + ",  " + postalCode + "]";
    }

    /**
     * Compares two addresses by first comparing province, then city, street, streetNumber, apartment
     * This method must have the given signature as it is inherited from superclass Object
     *
     * @param other the other address
     * @return true if the addresses are equal, false otherwise
     */
    public boolean equals(Object other)
    {
        Address otherA = (Address) other;
        //-----------Start below here. To do: approximate lines of code = 3
        // compare the province, city, street, streetNumber, postal code, and apartment of this address and the other address otherA. If all are equal, return true
        // else return false. We will study the inherited equals method in class this week
        if (((otherA.province).equals(province))&&((otherA.city).equals(city))&&((otherA.street).equals(street))&&(otherA.streetNumber==streetNumber)&&((otherA.postalCode).equals(postalCode))&&((otherA.apartment).equals(apartment))) {
            return true;
        }
        return false;
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
