/**
 * This code tests your Province class. You should NOT edit it. All changes to be made are in Province.java
 */
public class ProvinceTester
{
    public static void main(String[] args)
    {
        Province ontario = new Province("Ontario", 14570000, 1076000);
        Province pei = new Province("PEI", 156947, 5660);
        Province quebec = new Province("Quebec", 8485000, 1668000);

        Province [] provinces = {ontario, pei, quebec};
        String [] names = {"Ontario", "PEI", "Quebec"};

        System.out.println("------ Test Constructor and Province Stats ------");
        String [] expectedStats = {"Ontario Population: 14570000 Area: 1076000.0", "PEI Population: 156947 Area: 5660.0", "Quebec Population: 8485000 Area: 1668000.0"};

        boolean pass = true;
        for (int i = 0; i < provinces.length; i++) {
            System.out.println("  Testing on " + names[i]);
            String output = provinces[i].getProvinceStats();
            System.out.println("OUTPUT of getProvinceStats:   " + output);

            if(!output.equals(expectedStats[i])) {
                System.out.println("EXPECTED of getProvinceStats: " + expectedStats[i]);
                System.out.println("    INCORRECT OUTPUT");
                pass = false;
            }
        }
        printTestResult(pass);

        System.out.println("------ Test Density ------");
        double [] expectedDensity = {13.54, 27.73, 5.09};
        pass = true;

        for (int i = 0; i < provinces.length; i++) {
            System.out.println("  Testing on " + names[i]);
            double output = provinces[i].getPopulationDensity();
            System.out.printf("OUTPUT of getProvinceStats:   %.2f\n", output);

            if(Double.isNaN(output) || Math.abs(output - expectedDensity[i]) >= 0.01) {
                System.out.println("EXPECTED of getProvinceStats: " + expectedDensity[i]);
                System.out.println("    INCORRECT OUTPUT");
                pass = false;
            }
        }
        printTestResult(pass);

        System.out.println("------ Test Density Compare ------");
        int [][] expectedCompare = {{0, -1, 1}, {1, 0, 1}, {-1, -1, 0}};
        pass = true;

        for(int i = 0; i < provinces.length; i++) {
            for(int j = 0; j < provinces.length; j++) {
                int output = provinces[i].compareDensity(provinces[j]);
                System.out.println("OUTPUT of compareDensity between " + names[i] + " and " + names[j] + ":   " + output);

                if(output != expectedCompare[i][j]) {
                    System.out.println("EXPECTED of compareDensity between " + names[i] + " and " + names[j] + ": " + expectedCompare[i][j]);
                    System.out.println("    INCORRECT OUTPUT");
                    pass = false;
                }
            }
        }
        printTestResult(pass);
    }

    public static void printTestResult(boolean pass) {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }
}
