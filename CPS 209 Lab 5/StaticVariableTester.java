/**
 * Tests the StaticVariableClass
 */
public class StaticVariableTester
{
    public static void main(String[] args)
    {
        System.out.println("------ Before Creating Objects ------");
        runStaticTests(0, 0);

        System.out.println("\n------ Create 3 Objects ------");
        System.out.println("- Creates 3 objects. The first is named \"first\", second is created using default constructor, third is named \"third\"");
        StaticVariableClass o1 = new StaticVariableClass("first");
        StaticVariableClass o2 = new StaticVariableClass();
        StaticVariableClass o3 = new StaticVariableClass("third");

        runStaticTests(3, 0);

        System.out.println("\n------ Test getName ------");
        System.out.println("- Check on o1");
        runGetNameTests(o1, "first");

        System.out.println("- Check on o2");
        runGetNameTests(o2, "default");

        System.out.println("- Check on o3");
        runGetNameTests(o3, "third");

        System.out.println("\n------ Test getMethod ------");
        System.out.println("- call default myMethod once");
        o1.myMethod();
        runStaticTests(3, 1);

        System.out.println("- call myMethod with 5");
        o2.myMethod(5);
        runStaticTests(3, 6);

        System.out.println("- call myMethod with 23, and default myMethod twice");

        o3.myMethod(23);
        o1.myMethod();
        o2.myMethod();
        runStaticTests(3, 31);

        System.out.println("\n------ Make One More Object ------");
        StaticVariableClass o4 = new StaticVariableClass();
        runStaticTests(4, 31);
    }

    public static void runStaticTests(int expectedObjectCount, int expectedMethodCounter)
    {
        boolean pass = true;
        int objectCount = StaticVariableClass.getConstructorCounter();

        if (!testIntOutput("getConstructorCounter", objectCount, expectedObjectCount)) {
            pass = false;
        }

        int methodCount = StaticVariableClass.getMethodCounter();
        if (!testIntOutput("getMethodCounter", methodCount, expectedMethodCounter)) {
            pass = false;
        }

        printTestResult(pass);
    }

    public static void runGetNameTests(StaticVariableClass o, String expectedName) {
        boolean pass = true;
        String output = o.getName();


        if (!testStringOutput("getName", output, expectedName)) {
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
