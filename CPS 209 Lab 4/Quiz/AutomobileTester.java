/**
 * This code tests your Automobile class. You should NOT edit it. All changes to be made are in Automobile.java
 */
public class AutomobileTester
{
    /**
     * Tests the methods of the Automobile class.
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        Automobile auto = new Automobile(15);
        System.out.println("------ Testing Initialization ------");
        runTest(auto, 0);

        System.out.println("\n------ First Test Adding Gas and Driving ------");
        addGas(auto, 20);
        runTest(auto, 20);

        drive(auto, 150);
        runTest(auto, 10.0);

        addGas(auto, 50);
        runTest(auto, 60.0);

        drive(auto, 69.0);
        drive(auto, 49.0);
        runTest(auto, 52.13);

        System.out.println("\n------ Second Test Adding Gas and Driving ------");
        auto = new Automobile(10);
        runTest(auto, 0);

        addGas(auto, 30);
        runTest(auto, 30);

        drive(auto, 20);
        runTest(auto, 28.0);

        addGas(auto, 15);
        runTest(auto, 43.0);

        drive(auto, 99);
        runTest(auto, 33.1);
    }

    public static void addGas(Automobile auto, double gas)
    {
        System.out.println("Adding " + gas + " fuel");
        auto.addGas(gas);
    }

    public static void drive(Automobile auto, double km)
    {
        System.out.println("Driving " + km + " km");
        auto.drive(km);
    }

    public static void runTest(Automobile auto, double expectedFuel)
    {
        boolean pass = true;
        System.out.printf("OUTPUT of getGasInTank:   %.2f\n", auto.getGasInTank());
        if (Math.abs(auto.getGasInTank() - expectedFuel) >= 0.01) {
            System.out.println("EXPECTED of getGasInTank: " + expectedFuel);
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



