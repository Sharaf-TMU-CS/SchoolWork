/**
 * This code tests your CashRegister class. You should NOT edit it. All changes to be made are in CashRegister.java
 */
public class CashRegisterTester
{
    public static void main(String[] args)
    {
        final double NICKEL_VALUE = 0.05;
        final double DIME_VALUE = 0.1;
        final double QUARTER_VALUE = 0.25;

        Coin quarter = new Coin(QUARTER_VALUE, "quarter");
        Coin nickel = new Coin(NICKEL_VALUE, "nickel");
        Coin dime = new Coin(DIME_VALUE, "dime");

        System.out.println("------ Test Payments ------");
        CashRegister register = new CashRegister();
        makePurchase(register, 0.82);
        pay(register, 3, quarter);
        pay(register, 2, nickel);

        runTest(register, 0.03);

        register = new CashRegister();
        makePurchase(register, 0.15);
        makePurchase(register, 0.98);
        makePurchase(register, 0.33);
        pay(register, 4, quarter);
        pay(register, 3, dime);
        pay(register, 4, nickel);

        runTest(register, 0.04);

        System.out.println("\n------ No Purchase Made ------");
        register = new CashRegister();
        runTest(register, 0);
    }

    public static void makePurchase(CashRegister register, double itemPrice)
    {
        System.out.println("Purchase of cost " + itemPrice);
        register.recordPurchase(itemPrice);
        System.out.println("\tCurrent state of register: " + register.toString());
    }

    public static void pay(CashRegister register, int coinCount, Coin coinType)
    {
        System.out.println("Paying with " + coinCount + " coins of type " + coinType.getName());
        register.enterPayment(coinCount, coinType);
        System.out.println("\tCurrent state of register: " + register.toString());
    }

    public static void runTest(CashRegister register, double expected)
    {
        boolean pass = true;

        double change = register.giveChange();
        System.out.printf("OUTPUT of giveChange:   %.2f\n", change);

        if (Math.abs(change - expected) > 0.00000001) {
            System.out.println("EXPECTED of giveChange: " + expected);
            System.out.println("    INCORRECT OUTPUT");
            pass = false;
        }
        System.out.println("\tCurrent state of register: " + register.toString());

        if (register.getTotalPayment() != 0) {
            System.out.println("    INCORRECT - total payment should be reset to 0. Payment is " + register.getTotalPayment());
            pass = false;
        }

        if (register.getTotalPurchased() != 0) {
            System.out.println("    INCORRECT - total purchased should be reset to 0. Purchased is " + register.getTotalPurchased());
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
