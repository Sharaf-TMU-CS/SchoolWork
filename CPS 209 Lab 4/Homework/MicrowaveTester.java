/**
 * This code tests your Microwave class. You should NOT edit it. All changes to be made are in Microwave.java
 */
public class MicrowaveTester
{
    public static void main(String[] args)
    {

        Microwave appliance = new Microwave();

        System.out.println("------ Check Constructor is Correct ------");
        runTest(appliance, "Set for 0 seconds at power LOW");

        appliance.increaseTime();
        appliance.increaseTime();
        appliance.increaseTime();

        System.out.println("\n------ Check Increase Time ------");
        runTest(appliance, "Set for 90 seconds at power LOW");

        System.out.println("\n------ Check Switch Power ------");
        appliance.switchPower();
        runTest(appliance, "Set for 90 seconds at power HIGH");

        System.out.println("\n------ Check Reset ------");
        appliance.reset();
        runTest(appliance, "Set for 0 seconds at power LOW");

        System.out.println("\n------ Check Increase and Switch Twice ------");
        appliance.increaseTime();
        appliance.switchPower();
        appliance.switchPower();
        runTest(appliance, "Set for 30 seconds at power LOW");
    }

    public static void runTest(Microwave app, String expected)
    {
        boolean pass = true;

        String output = app.getSettings();
        System.out.println("OUTPUT of getSettings:   " + output);

        if (!output.equals(expected)) {
            System.out.println("EXPECTED of getSettings: " + expected);
            System.out.println("    INCORRECT OUTPUT");
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
