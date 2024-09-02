/**
 * A class for a Person object that stores first name and last name.
 *
 * You should create the following methods:
 * - Create a constructor that takes in a first name and last name
 * - Create a getFullName method which returns the full name of the person
 * - Create a getInitials method which returns the initials of the person
 * - Create an equals method which returns whether two Person objest are equal
 */
public class Person
{
    private String firstName;
    private String familyName;

    // Create a Constructor Method with two arguments to set the
    // firstName and familyName instance variables
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public Person(String firstName, String familyName){
        this.firstName = firstName;
        this.familyName = familyName;
    }
    

    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


    // Create a public method called getFullName() that returns a string containing
    // the first name followed by a blank space followed by the family name
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public String getFullName(){
        return firstName+" "+familyName;
    }
    

    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a public method call getInitials() that returns a string containing the
    // first letter of the first name followed by the first letter of
    // the family name. Hint: use the substring method of class String.
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public String getInitials(){
        return firstName.substring(0,1)+familyName.substring(0, 1);
    }
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


    // Create a method boolean equals(Person other) - **using this exact method signature!!** -
    // this method will return true if and only if the two person objects have the same first
    // and last name.
    //
    // Don't forget you must use the equals method of class String when comparing familyName strings
    // That means that the equals method of class Person will be calling the equals method of class String using
    // the familyName variable but these are two different equals methods!!
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public boolean equals(Person other) {
        if (other.familyName.equals(familyName) && other.firstName.equals(firstName)) {
            return true;
        }
        return false;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
