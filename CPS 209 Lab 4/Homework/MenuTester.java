/**
 * This code tests your Menu class. You should NOT edit it. All changes to be made are in Menu.java
 */
public class MenuTester
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        System.out.println("------ Test Before Adding Menu Items ------");
        getMenuStringTest(menu, "");
        getOptionTest(menu, 1, "");

        System.out.println("\n------ Test After Adding 3 Items ------");
        menu.addOption("Lasagna");
        menu.addOption("Pizza Diavolo");
        menu.addOption("Pizza Magherita");

        getMenuStringTest(menu, "1. Lasagna\n2. Pizza Diavolo\n3. Pizza Magherita\n");
        getOptionTest(menu, 1, "Lasagna");
        getOptionTest(menu, 2, "Pizza Diavolo");
        getOptionTest(menu, 3, "Pizza Magherita");
        getOptionTest(menu, 4, "");

        System.out.println("\n------ Test After Adding Another 3 Items ------");
        menu.addOption("Pizza Sicilian");
        menu.addOption("Chicken Parmigiana");
        menu.addOption("Chicken Linguine");

        getMenuStringTest(menu, "1. Lasagna\n2. Pizza Diavolo\n3. Pizza Magherita\n4. Pizza Sicilian\n5. Chicken Parmigiana\n6. Chicken Linguine\n");

        getOptionTest(menu, 2, "Pizza Diavolo");
        getOptionTest(menu, 6, "Chicken Linguine");
        getOptionTest(menu, 0, "");
        getOptionTest(menu, 8, "");
    }

    public static void getMenuStringTest(Menu menu, String expected)
    {
        boolean pass = true;

        String output = menu.getMenuString();
        System.out.println("OUTPUT of getMenuString:\n" + output);

        if (!output.equals(expected)) {
            System.out.println("EXPECTED of getMenuString:\n" + expected);
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

    public static void getOptionTest(Menu menu, int num, String expected)
    {
        boolean pass = true;

        System.out.println("Getting option " + num);
        String output = menu.getOption(num);
        System.out.println("OUTPUT of getOption:   " + output);

        if (!output.equals(expected)) {
            System.out.println("EXPECTED of getOption: " + expected);
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
