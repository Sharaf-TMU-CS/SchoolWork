import java.util.Arrays;
import java.util.Comparator;

/**
 * Below, you will test how to sort an array in multiple ways using a comparator.
 * You are to complete the following tasks:
 * <p>
 * - Create a Comparator for Person objects that can be used to sort according
 * to name, and use it to sort the array
 * - Create a Comparator for Person objects that can be used to sort according
 * to age in ascending order, and use it to sort the array
 * - Create a Comparator for Person objects that can be used to sort according
 * to age in ascending order, and use it to sort the array
 */
public class PersonSorter
{
    public static void main(String[] args)
    {
        //$start Create a simple (inner) class that implements the Comparator interface
        // to sort two person objects by name
        // compare last name alphabetically. If they are equal then compare first names
        // Hint: make use of the class String compareTo() method to compare name strings
        class PersonNameComparator implements Comparator<Person>
        {
            public int compare(Person a, Person b)
            {
                if (a.getLastName().compareTo(b.getLastName()) == 0)
                    return a.getFirstName().compareTo(b.getFirstName());
                return a.getLastName().compareTo(b.getLastName());
            }
        }
        //$end

        //$start Create a simple (inner) class that implements the Comparator interface
        // to sort two person objects by age (youngest to oldest)
        class PersonAgeComparator implements Comparator<Person>
        {
            public int compare(Person a, Person b)
            {
                return a.getAge() - b.getAge();
            }
        }

        // call Array.sort with two parameters - one passing in the array of persons
        // and one passing in an object of the inner class

        //$end

        //$start Create a simple (inner) class that implements the Comparator interface
        // to sort two person objects by age (oldest to youngest)
        class DescendingPersonAgeComparator implements Comparator<Person>
        {
            public int compare(Person a, Person b)
            {
                return b.getAge() - a.getAge();
            }
        }
        //$end

        Person[] people = {
                new Person("Elvis", "Goodyear", 56),
                new Person("Stanley", "Clark", 8),
                new Person("Jane", "Graff", 16),
                new Person("Nancy", "Goodyear", 69),
                new Person("Alice", "Goodyear", 100)
        };

        Person[] directors = {
                new Person("Greta", "Gerwig", 40),
                new Person("Martin", "Scorsese", 81),
                new Person("Justine", "Triet", 45),
                new Person("Christopher", "Nolan", 53),
                new Person("Yorgos", "Lanthimos", 50),
                new Person("Jonathan", "Glazer", 58)
        };

        System.out.println("------ TEST 1: Sort the array alphabetically ------");
        runSortTest(people, new PersonNameComparator(), "[(Clark, Stanley. Age: 8), (Goodyear, Alice. Age: 100), (Goodyear, Elvis. Age: 56), (Goodyear, Nancy. Age: 69), (Graff, Jane. Age: 16)]");
        runSortTest(directors, new PersonNameComparator(), "[(Gerwig, Greta. Age: 40), (Glazer, Jonathan. Age: 58), (Lanthimos, Yorgos. Age: 50), (Nolan, Christopher. Age: 53), (Scorsese, Martin. Age: 81), (Triet, Justine. Age: 45)]");

        System.out.println("\n------ TEST 2: Sort the array by age ------");
        runSortTest(people, new PersonAgeComparator(), "[(Clark, Stanley. Age: 8), (Graff, Jane. Age: 16), (Goodyear, Elvis. Age: 56), (Goodyear, Nancy. Age: 69), (Goodyear, Alice. Age: 100)]");
        runSortTest(directors, new PersonAgeComparator(), "[(Gerwig, Greta. Age: 40), (Triet, Justine. Age: 45), (Lanthimos, Yorgos. Age: 50), (Nolan, Christopher. Age: 53), (Glazer, Jonathan. Age: 58), (Scorsese, Martin. Age: 81)]");

        System.out.println("\n------ TEST 3: Sort the array by age in descending order ------");
        runSortTest(people, new DescendingPersonAgeComparator(), "[(Goodyear, Alice. Age: 100), (Goodyear, Nancy. Age: 69), (Goodyear, Elvis. Age: 56), (Graff, Jane. Age: 16), (Clark, Stanley. Age: 8)]");
        runSortTest(directors, new DescendingPersonAgeComparator(), "[(Scorsese, Martin. Age: 81), (Glazer, Jonathan. Age: 58), (Nolan, Christopher. Age: 53), (Lanthimos, Yorgos. Age: 50), (Triet, Justine. Age: 45), (Gerwig, Greta. Age: 40)]");
    }

    public static void runSortTest(Person[] people, Comparator<Person> comp, String expected)
    {
        System.out.println("The initial array is     " + Arrays.toString(people));
        Arrays.sort(people, comp);

        String output = Arrays.toString(people);

        printTestResult(testStringOutput("Arrays.sort", output, expected));
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
