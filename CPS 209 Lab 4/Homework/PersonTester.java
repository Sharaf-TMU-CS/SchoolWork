/**
 * This code tests your Person class. You should NOT edit it. All changes to be made are in Person.java
 */
public class PersonTester
{

    public static void main(String[] args)
    {

        Person individual = new Person("Frodo");

        System.out.println("------ Check Before Any Friends Added ------");
        runTest(individual, 0, "");

        System.out.println("------ Check After Adding 3 Friends ------");
        individual.befriend(new Person("Samwise"));
        individual.befriend(new Person("Aragorn"));
        individual.befriend(new Person("Boromir"));

        runTest(individual, 3, "Samwise Aragorn Boromir ");

        System.out.println("------ Check After Unfriending Boromir ------");
        individual.unfriend(new Person("Boromir"));

        runTest(individual, 2, "Samwise Aragorn ");

        System.out.println("------ Check After Adding Friend Gandalf ------");
        individual.befriend(new Person("Gandalf"));
        runTest(individual, 3, "Samwise Aragorn Gandalf ");

        System.out.println("------ Unfriend Samwise ------");
        individual.unfriend(new Person("Samwise"));

        runTest(individual, 2, "Aragorn Gandalf ");

        System.out.println("------ Unfriend Someone Not in List------");
        individual.unfriend(new Person("Samwise"));

        runTest(individual, 2, "Aragorn Gandalf ");
    }

    public static void runTest(Person p, int expectedCount, String expectedNames)
    {
        boolean pass = true;

        String output = p.getFriendNames();
        System.out.println("OUTPUT of getSettings:   " + output);

        if (!output.equals(expectedNames)) {
            System.out.println("EXPECTED of getSettings: " + expectedNames);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        System.out.println("OUTPUT of getFriendCount:   " + p.getFriendCount());
        if (p.getFriendCount() != expectedCount) {
            System.out.println("EXPECTED of getFriendCount: " + expectedCount);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("\u001B[31m" + "*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************" + "\u001B[0m" + "\n");
        }
    }
}
