/**
 * Tests the card class. Complete the two getCardInfo methods, one that returns
 * a String representation of a CreditCard and one that returns a String
 * representation of a Driver's License.
 */
public class CardTester
{
    // For a given credit card, returns a string of the form
    //
    // "Name: Tom Jones, ID: 123, Expiry: 2025, Balance: 5000"
    public static String getCardInfo(CreditCard card)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        return "Name: "+card.getName()+", ID: "+card.getID()+", Expiry: "+card.getExpiryYear()+", Balance: "+card.getBalance();
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // For a given driver's license, returns a string of the form
    //
    // "Name: Tom Jones, ID: 123, Expiry: 2025, Type: G"
    //
    // HINT: Remember to handle the different license types with different strings
    public static String getCardInfo(DriversLicense card)
    {
        //-----------Start below here. To do: approximate lines of code = 9
        //
        return "Name: "+card.getName()+", ID: "+card.getID()+", Expiry: "+card.getExpiryYear()+", Type: "+card.getLicenseType();
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        System.out.println("------ Test DriversLicense Constructor and getCardInfo------");
        DriversLicense license = new DriversLicense("Tim Jones", "V54 98H 763", 2024, DriversLicense.LicenseType.G1);
        runDriversLicenseTest(license, "Name: Tim Jones, ID: V54 98H 763, Expiry: 2024, Type: G1");

        System.out.println("\n------ Test CreditCard Constructor and getCardInfo ------");
        CreditCard credit = new CreditCard("Bob Turner", "1023431", 2023, 15000.0);
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 15000.0");

        System.out.println("\n------ Test updateLicenseType ------");
        license = new DriversLicense("Jon Tims", "V99 92H 763", 2025, DriversLicense.LicenseType.G1);
        runDriversLicenseTest(license, "Name: Jon Tims, ID: V99 92H 763, Expiry: 2025, Type: G1");

        license.updateLicenseType(DriversLicense.LicenseType.G2);
        runDriversLicenseTest(license, "Name: Jon Tims, ID: V99 92H 763, Expiry: 2025, Type: G2");

        license.updateLicenseType(DriversLicense.LicenseType.G);
        runDriversLicenseTest(license, "Name: Jon Tims, ID: V99 92H 763, Expiry: 2025, Type: G");

        System.out.println("\n------ Test purchase ------");
        System.out.println("- check that the purchase succeeds correctly");
        runPurchaseTest(credit, 10000, true);
        System.out.println("- check that the balance is updated correctly");
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 5000.0");

        System.out.println("- check that the purchase succeeds correctly");
        runPurchaseTest(credit, 3000, true);
        System.out.println("- check that the balance is updated correctly");
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 2000.0");

        System.out.println("- check that the purchase fails correctly");
        runPurchaseTest(credit, 5000, false);
        System.out.println("- check that the balance is not updated");
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 2000.0");

        System.out.println("\n------ Check that payOffBalance ------");
        System.out.println("- pay off the balance and ensure it is set correctly");
        credit.payOffBalance();
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 15000.0");

        System.out.println("- check that the purchase succeeds correctly");
        runPurchaseTest(credit, 3000, true);
        System.out.println("- check that the balance is updated correctly");
        runCreditCardTest(credit, "Name: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 12000.0");
    }

    public static void runDriversLicenseTest(DriversLicense license, String expectedInfo) {
        String cardInfo = getCardInfo(license);
        printTestResult(testStringOutput("getCardInfo", cardInfo, expectedInfo));
    }

    public static void runCreditCardTest(CreditCard card, String expectedInfo) {
        String cardInfo = getCardInfo(card);
        printTestResult(testStringOutput("getCardInfo", cardInfo, expectedInfo));
    }

    public static void runPurchaseTest(CreditCard card, double purchaseAmount, boolean expected) {
        boolean output = card.purchase(purchaseAmount);

        printTestResult(testBooleanOutput("purchase " + purchaseAmount, output, expected));
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
