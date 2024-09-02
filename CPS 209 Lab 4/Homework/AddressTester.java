/**
 * Complete the indexOfAddress method below and the equals method in Address.java
 */

import java.util.ArrayList;

public class AddressTester
{
    /**
     * Finds the index at which the given address appears in the given list of addresses.
     * <p>
     * Returns -1 if it does not appear. Should not change either addresses or toFind
     *
     * @param addresses The address list
     * @param toFind    The address to find
     * @return The index of the desired address or -1 if it is not there
     */
    public static int indexOfAddress(ArrayList<Address> addresses, Address toFind)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        // Hint: Complete the .equals method in Address.java first, then use it here
        for (int i=0; i<addresses.size(); i++) {
            if (toFind.equals(addresses.get(i)))
                return i;
        }
        return -1;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    }

    public static void main(String[] args)
    {
        System.out.println("------ Test Correctly Equal No Apartment ------");
        Address test1First = new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4");
        Address test1Second = new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4");
        runEqualityTest(test1First, test1Second, true);

        System.out.println("\n------ Test Correctly Equal With Apartment ------");
        Address test2First = new Address(26, "Suite 2B", "Avenue Road", "Toronto", "ON", "M5C 2H4");
        Address test2Second = new Address(26, "Suite 2B", "Avenue Road", "Toronto", "ON", "M5C 2H4");
        runEqualityTest(test2First, test2Second, true);

        System.out.println("\n------ Test Not Equal ------");
        Address test3First = new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4");
        Address test3Second = new Address(314, "Yonge Street", "Toronto", "ON", "M5B 2K3");
        runEqualityTest(test3First, test3Second, false);

        System.out.println("\n------ Test Off By One ------");
        Address test4First = new Address(67, "Bay Street", "Toronto", "ON", "M5X 2B1");

        // Street number wrong
        Address test4streetno = new Address(66, "Bay Street", "Toronto", "ON", "M5X 2B1");
        runEqualityTest(test4First, test4streetno, false);
        System.out.println();
        // Street name wrong
        Address test4street = new Address(67, "Baye Street", "Toronto", "ON", "M5X 2B1");
        runEqualityTest(test4First, test4street, false);
        System.out.println();
        // City name wrong
        Address test4city = new Address(67, "Bay Street", "Hamilton", "ON", "M5X 2B1");
        runEqualityTest(test4First, test4city, false);
        System.out.println();
        // Province name wrong
        Address test4prov = new Address(67, "Bay Street", "Toronto", "BC", "M5X 2B1");
        runEqualityTest(test4First, test4prov, false);
        System.out.println();
        // Postal code wrong
        Address test4postal = new Address(67, "Bay Street", "Toronto", "ON", "M5X 2B2");
        runEqualityTest(test4First, test4postal, false);
        // Extra apartment
        Address test4apt = new Address(67, "1067", "Bay Street", "Toronto", "ON", "M5X 2B1");
        runEqualityTest(test4First, test4apt, false);
        // Missing apartment
        runEqualityTest(test4apt, test4First, false);

        System.out.println("\n------ Test FindIndex Regular ------");
        ArrayList<Address> addresses = new ArrayList<Address>();

        addresses.add(new Address(314, "Yonge Street", "Toronto", "ON", "M5B 2K3"));
        addresses.add(new Address(13, "Suite 5", "Jarvis Street", "Toronto", "ON", "M4X 1H1"));
        addresses.add(new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4"));
        addresses.add(new Address(67, "Bay Street", "Toronto", "ON", "M5X 2B1"));
        addresses.add(new Address(314, "Yonge Street", "Toronto", "ON", "M5B 2K3"));
        addresses.add(new Address(666, "501", "Spadina Avenue", "Toronto", "ON", "M53 2K3"));
        System.out.println("The List Of Addresses is\n\t" + addresses);

        System.out.println();
        Address toFind1 = new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4");
        runIndexOfTest(addresses, toFind1, 2);

        System.out.println();
        Address toFind2 = new Address(666, "501", "Spadina Avenue", "Toronto", "ON", "M53 2K3");
        runIndexOfTest(addresses, toFind2, 5);

        System.out.println();
        Address toFind3 = new Address(26, "Avenue Road", "Hamilton", "ON", "M5C 2H4");
        runIndexOfTest(addresses, toFind3, -1);

        System.out.println("\n------ Test FindIndex Empty Address List ------");
        addresses = new ArrayList<Address>();
        Address toFind4 = new Address(26, "Avenue Road", "Toronto", "ON", "M5C 2H4");
        runIndexOfTest(addresses, toFind4, -1);
    }

    public static void runEqualityTest(Address first, Address second, boolean expected)
    {
        System.out.println("Comparing the following addresses:");
        System.out.println("\t" + first.toString());
        System.out.println("\t" + second.toString());

        String firstString = first.toString();
        String secondString = second.toString();

        boolean output = first.equals(second);

        boolean pass = true;
        System.out.println("OUTPUT of equals:   " + output);
        if (output != expected) {
            System.out.println("EXPECTED of equals: " + expected);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        if (!firstString.equals(first.toString())) {
            System.out.println("    INCORRECT - The first address has been changed to " + first.toString());
            pass = false;
        }
        if (!secondString.equals(second.toString())) {
            System.out.println("    INCORRECT - The first address has been changed to " + first.toString());
            pass = false;
        }

        if (pass) {
            System.out.println("*** TEST PASSES ***");
        } else {
            System.out.println("\u001B[31m" + "*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************" + "\u001B[0m");
        }
    }

    public static void runIndexOfTest(ArrayList<Address> addresses, Address toFind, int expected)
    {
        System.out.println("The address to find is " + toFind);
        String addressesString = addresses.toString();
        String toFindString = toFind.toString();

        int output = indexOfAddress(addresses, toFind);

        boolean pass = true;
        System.out.println("OUTPUT of indexOf:   " + output);
        if (expected != output) {
            System.out.println("EXPECTED of indexOf: " + expected);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }

        if (!addressesString.equals(addresses.toString())) {
            System.out.println("    INCORRECT - The addresses list has changed to " + addresses.toString());
            pass = false;
        }
        if (!toFindString.equals(toFind.toString())) {
            System.out.println("    INCORRECT - The address to find has been changed to " + toFind.toString());
            pass = false;
        }

        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }
}
