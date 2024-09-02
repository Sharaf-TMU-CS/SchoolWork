/**
 * This code tests your VotingMachine class. You should NOT edit it. All changes to be made are in VotingMachine.java
 */
public class VotingMachineTester
{
    public static void main(String[] args)
    {
        System.out.println("------ Test the Constructor ------");
        VotingMachine vm = new VotingMachine("Democrats", "Republicans");
        runTests(vm, "Democrats", "Republicans", 0, 0, "Democrats and Republicans tied with 0 votes");

        System.out.println("\n------ Test Party 1 Wins ------");
        int votes1 = 7736;
        for (int i = 0; i < votes1; i++)
            vm.voteParty1();

        int votes2 = 7624;
        for (int i = 0; i < votes2; i++)
            vm.voteParty2();

        runTests(vm, "Democrats", "Republicans", 7736, 7624, "Democrats wins the election with 7736 votes");

        System.out.println("\n------ Test after Resetting Election ------");
        vm.newElection();

        runTests(vm, "Democrats", "Republicans", 0, 0, "Democrats and Republicans tied with 0 votes");

        vm.voteParty1();
        vm.voteParty1();
        vm.voteParty2();
        vm.voteParty2();

        runTests(vm, "Democrats", "Republicans", 2, 2, "Democrats and Republicans tied with 2 votes");

        System.out.println("\n------ Test the Constructor New Names ------");
        vm = new VotingMachine("Blue Party", "Red Party");
        runTests(vm, "Blue Party", "Red Party", 0, 0, "Blue Party and Red Party tied with 0 votes");

        vm.voteParty1();
        vm.voteParty1();
        vm.voteParty2();
        vm.voteParty2();
        vm.voteParty2();
        vm.voteParty2();

        System.out.println("\n------ Test Party 2 Wins ------");
        runTests(vm, "Blue Party", "Red Party", 2, 4, "Red Party wins the election with 4 votes");
    }

    public static void runTests(VotingMachine v, String expectedName1, String expectedName2, int expectedVotes1, int expectedVotes2, String expectedWinnerString)
    {
        boolean pass = true;

        String party1Name = v.getParty1Name();
        if (!testStringOutput("getParty1Name", party1Name, expectedName1)) {
            pass = false;
        }

        String party2Name = v.getParty2Name();
        if (!testStringOutput("getParty2Name", party2Name, expectedName2)) {
            pass = false;
        }

        int party1Votes = v.getNumVotes1();
        if (!testIntOutput("getNumVotes1", party1Votes, expectedVotes1)) {
            pass = false;
        }

        int party2Votes = v.getNumVotes2();
        if (!testIntOutput("getNumVotes2", party2Votes, expectedVotes2)) {
            pass = false;
        }

        String winnerString = v.getWinner();
        if (!testStringOutput("getWinner", winnerString, expectedWinnerString)) {
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
