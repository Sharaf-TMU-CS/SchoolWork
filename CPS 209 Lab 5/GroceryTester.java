public class GroceryTester
{
    public static void main(String[] args)
    {
        System.out.println("------ Test GroceryStore Constructor and getInventory ------");
        System.out.println("- Store1 created with 40 lettuce, 150 tomato, 75 cucumbers");
        GroceryStore store1 = new GroceryStore("MLG Loblaws", 40, 150, 75);
        runStoreTest(store1, 40, 150, 75);

        System.out.println("- Store2 created with 30 lettuce, 100 tomato, 50 cucumbers");
        GroceryStore store2 = new GroceryStore("Dundas Square Loblaws", 30, 100, 50);
        runStoreTest(store2, 30, 100, 50);

        System.out.println("- Store3 created with 50 lettuce, 80 tomato, 60 cucumbers");
        GroceryStore store3 = new GroceryStore("West End Loblaws", 50, 80, 60);
        runStoreTest(store3, 50, 80, 60);

        System.out.println("\n------ Test add Inventory to GroceryStore ------");
        System.out.println("- Add 10 tomatoes to store1");
        store1.addInventory(GroceryStore.GroceryItem.TOMATO, 10);
        runStoreTest(store1, 40, 160, 75);

        System.out.println("- Add 10 cucumbers to store3");
        store3.addInventory(GroceryStore.GroceryItem.CUCUMBER, 10);
        runStoreTest(store3, 50, 80, 70);

        System.out.println("\n------ Test GroceryChain Constructor and getTotalInventory ------");
        System.out.println("- Creating Chain. No stores added so inventory should be 0");
        GroceryChain loblaws = new GroceryChain("loblaws");
        runChainTest(loblaws, 0, 0, 0);

        System.out.println("\n------ Test GroceryChain addGroceryStore and getTotalInventory ------");
        System.out.println("- adding three stores created above");
        loblaws.addGroceryStore(store1);
        loblaws.addGroceryStore(store2);
        loblaws.addGroceryStore(store3);

        runChainTest(loblaws, 120, 340, 195);

        System.out.println("- add 5 lettuce to store1, 10 tomato to store2, and 15 cucumber to store 3");

        store1.addInventory(GroceryStore.GroceryItem.LETTUCE, 5);
        store2.addInventory(GroceryStore.GroceryItem.TOMATO, 10);
        store3.addInventory(GroceryStore.GroceryItem.CUCUMBER, 15);
        runChainTest(loblaws, 125, 350, 210);
    }

    public static void runStoreTest(GroceryStore store, int expectedLettuce, int expectedTomato, int expectedCucumber)
    {
        boolean pass = true;

        if(!testIntOutput("getInventory for lettuce", store.getInventory(GroceryStore.GroceryItem.LETTUCE), expectedLettuce)) {
            pass = false;
        }

        if(!testIntOutput("getInventory for tomato", store.getInventory(GroceryStore.GroceryItem.TOMATO), expectedTomato)) {
            pass = false;
        }

        if(!testIntOutput("getInventory for cucumber", store.getInventory(GroceryStore.GroceryItem.CUCUMBER), expectedCucumber)) {
            pass = false;
        }

        printTestResult(pass);
    }

    public static void runChainTest(GroceryChain chain, int expectedLettuce, int expectedTomato, int expectedCucumber)
    {
        boolean pass = true;

        if(!testIntOutput("getInventory for lettuce", chain.getTotalInventory(GroceryStore.GroceryItem.LETTUCE), expectedLettuce)) {
            pass = false;
        }

        if(!testIntOutput("getInventory for lettuce", chain.getTotalInventory(GroceryStore.GroceryItem.TOMATO), expectedTomato)) {
            pass = false;
        }

        if(!testIntOutput("getInventory for lettuce", chain.getTotalInventory(GroceryStore.GroceryItem.CUCUMBER), expectedCucumber)) {
            pass = false;
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

    public static boolean testIntOutput(String methodName, int output, int expected)
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
