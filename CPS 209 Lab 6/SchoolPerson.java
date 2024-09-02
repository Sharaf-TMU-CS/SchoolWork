/**
 * A class representing a person at a school.
 */
public class SchoolPerson
{
    private String name;
    private int yearOfBirth;

    /**
     * Create a person with a given name and date of birth.
     *
     * @param name        the name
     * @param yearOfBirth the date of birth
     */
    public SchoolPerson(String name, int yearOfBirth)
    {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getBirthYear()
    {
        return yearOfBirth;
    }

    /**
     * Convert person to string form.
     */
    public String toString()
    {
        return this.getClass().getName() + " Name: " + name + " Year of Birth: " + yearOfBirth;
    }
}