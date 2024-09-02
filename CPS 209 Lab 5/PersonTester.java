import java.util.ArrayList;

/**
 * This code tests your Person class. You should also complete the findPerson method below.
 */
public class PersonTester
{
    // Create a static method that returns true if a person with the given first name and last name
    // is in the given ArrayList of Person objects
    //
    // HINT: Use the equals method you defined in Person
    public static boolean findPerson(ArrayList<Person> people, String firstName, String lastName)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        for (int i =0; i<people.size(); i++) {
            if ((people.get(i)).getFullName().equals(firstName+" "+lastName)) {
                return true;
            }
        }
        return false;
        
    
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {

        System.out.println("------ Test Constructor ------");
        System.out.println("Test on \"Tom O'Brien\"");
        Person p1 = new Person("Tom", "O'Brien");
        runPersonTests(p1, "Tom O'Brien", "TO");

        System.out.println("Test on \"Alireza Sadeghian\"");
        Person p2 = new Person("Alireza", "Sadeghian");
        runPersonTests(p2, "Alireza Sadeghian", "AS");

        System.out.println("\n------ Test Find ------");
        Person p3 = new Person("Timothy", "O'Brien");
        ArrayList<Person> people = new ArrayList<Person>();

        System.out.println("- Test find on empty list");
        runFindPersonTests(people, "Rick", "Valenzano", false);

        System.out.println("- Find \"Alireza Sadeghian\" on Person list [Tom O'Brien, Alireza Sadeghian, Timothy O'Brien]");
        people.add(p1);
        people.add(p2);
        people.add(p3);
        runFindPersonTests(people, "Alireza", "Sadeghian", true);

        System.out.println("- Find \"Tom O'Brien\" on Person list [Tom O'Brien, Alireza Sadeghian, Timothy O'Brien]");
        runFindPersonTests(people, "Tom", "O'Brien", true);

        System.out.println("- Find \"Rick Valenzano\" on Person list [Tom O'Brien, Alireza Sadeghian, Timothy O'Brien]");
        runFindPersonTests(people, "Rick", "Valenzano", false);
    }

    public static void runPersonTests(Person p, String expectedName, String expectedInitials)
    {
        boolean pass = true;

        String fullName = p.getFullName();
        if (!testStringOutput("getFullName", fullName, expectedName)) {
            pass = false;
        }

        String initials = p.getInitials();
        if (!testStringOutput("getInitials", initials, expectedInitials)) {
            pass = false;
        }

        printTestResult(pass);
    }

    public static void runFindPersonTests(ArrayList<Person> people, String firstName, String lastName, boolean expected) {
        boolean found = findPerson(people, firstName, lastName);
        printTestResult(testBooleanOutput("findPerson", found, expected));
    }

    public static void printTestResult(boolean pass)
    {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }

    public static boolean testStringOutput(String methodName, String output, String expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (!output.equals(expected)) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }

    public static boolean testBooleanOutput(String methodName, boolean output, boolean expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);
        if (output != expected) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
