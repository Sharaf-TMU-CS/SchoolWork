import java.util.ArrayList;

/**
 * A class to test the student and instructor subclasses. Complete those
 * classes. In addition, you are to complete the getOldest method which finds
 * the oldest person in the given array list and returns them
 */
public class SchoolPersonTester
{

    /**
     * Finds the oldest person in the given ArrayList and returns them. Returns null
     * if the ArrayList is empty.
     *
     * @param people The list of people
     * @return The oldest person in the array
     */
    public static SchoolPerson getOldest(ArrayList<SchoolPerson> people)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        if (people.size() > 0) {
            SchoolPerson oldest = people.get(0);
            for (int i=1; i<people.size(); i++) {
                if (oldest.getBirthYear()>people.get(i).getBirthYear()) {
                    oldest = people.get(i);
                }
            }
            return oldest;
        }
        return null;
        
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        System.out.println("------ TEST 1: Check that toString works correctly ------");
        System.out.println("check first Student");
        SchoolPerson student1 = new Student("Ali", 2002, "CS");
        runToStringTest(student1, "Student Name: Ali Year of Birth: 2002 Major: CS");

        System.out.println("Check second student");
        SchoolPerson student2 = new Student("Cody", 2003, "Chem");
        runToStringTest(student2, "Student Name: Cody Year of Birth: 2003 Major: Chem");

        System.out.println("check first instructor");
        SchoolPerson instructor1 = new Instructor("Sam", 1991, 100000);
        runToStringTest(instructor1, "Instructor Name: Sam Year of Birth: 1991 Salary: 100000");

        System.out.println("check second instructor");
        SchoolPerson instructor2 = new Instructor("Valerie", 1994, 110000);
        runToStringTest(instructor2, "Instructor Name: Valerie Year of Birth: 1994 Salary: 110000");

        System.out.println("\n------ TEST 2: Check that getOldest works on an empty arraylist ------");
        ArrayList<SchoolPerson> people = new ArrayList<SchoolPerson>();
        runGetOldestTest(people, null);

        System.out.println("\n------ TEST 3: Check that getOldest works in standard cases ------");
        System.out.println("Adding first student");
        people.add(student1);
        runGetOldestTest(people, "Student Name: Ali Year of Birth: 2002 Major: CS");

        System.out.println("Adding second student");
        people.add(student2);
        runGetOldestTest(people, "Student Name: Ali Year of Birth: 2002 Major: CS");

        System.out.println("Adding first instructor");
        people.add(instructor1);
        runGetOldestTest(people, "Instructor Name: Sam Year of Birth: 1991 Salary: 100000");

        System.out.println("Adding second instructor");
        people.add(instructor2);
        runGetOldestTest(people, "Instructor Name: Sam Year of Birth: 1991 Salary: 100000");

        System.out.println("Adding Person named Jeff in 2001");
        SchoolPerson person = new SchoolPerson("Jeff", 2001);
        people.add(person);
        runGetOldestTest(people, "Instructor Name: Sam Year of Birth: 1991 Salary: 100000");
    }

    public static void runToStringTest(SchoolPerson person, String expected)
    {
        String output = person.toString();
        printTestResult(testStringOutput("toString", output, expected));
    }

    public static void runGetOldestTest(ArrayList<SchoolPerson> people, String expected)
    {
        System.out.println("Testing on list: " + people);
        SchoolPerson output = getOldest(people);

        boolean pass = true;
        if (output == null) {
            if (expected != null) {
                pass = false;
            }
        } else {
            pass = testStringOutput("getOldest", output.toString(), expected);
        }
        printTestResult(pass);

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
}

