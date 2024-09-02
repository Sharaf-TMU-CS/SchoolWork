/**
 * This code tests your LoginForm class. You should NOT edit it. All changes to be made are in LoginForm.java
 */
public class LoginFormTester
{
    public static void main(String[] args)
    {
        LoginForm form = new LoginForm("tim.mcinerney", "abc123");

        System.out.println("------ Test Before Input ------");
        System.out.println("Checking logged in");
        runLoggedInTest(form, false);

        System.out.println("\n------ Check After First Input, But No Submit ------");
        System.out.println("Login info is correct so areLoggedIn should fail");
        form.input("tim.mcinerney");
        form.input("abc123");

        runLoggedInTest(form, false);

        System.out.println("\n------ Check After Click Submit ------");
        System.out.println("Should now be logged in since credentials were inputted correctly");
        form.click("Submit");
        runLoggedInTest(form, true);

        System.out.println("\n------ Check After Click Reset ------");
        System.out.println("Should no longer be logged in since reset was clicked");
        form.click("Reset");
        runLoggedInTest(form, false);

        System.out.println("\n------ Check After Input Bad Credentials ------");
        System.out.println("Should not be logged in because password is incorrect");
        form.input("tim.mcinerney");
        form.input("ab123");

        form.click("Submit");
        runLoggedInTest(form, false);
    }

    public static void runLoggedInTest(LoginForm form, boolean expected) {
        System.out.println("OUTPUT of areLoggedIn:   " + form.areLoggedIn());
        if (form.areLoggedIn() != expected) {
            System.out.println("EXPECTED of areLoggedIn: " + expected);
            System.out.println("    INCORRECT OUTPUT");
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************");
        } else {
            System.out.println("*** TEST PASSES ***\n");
        }
    }

}
