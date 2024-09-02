// Name: Sharaf Hussain
// ID: 501246102
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMUberRegistered
{
    // These variables are used to generate user account and driver ids
    private static int firstUserAccountID = 900;
    private static int firstDriverId = 700;

    // Generate a new user account id
    public static String generateUserAccountId(ArrayList<User> current)
    {
        return "" + firstUserAccountID + current.size();
    }

    // Generate a new driver id
    public static String generateDriverId(ArrayList<Driver> current)
    {
        return "" + firstDriverId + current.size();
    }

    // Database of Preregistered users
    // In Assignment 2 these will be loaded from a file
    // The test scripts and test outputs included with the skeleton code use these
    // users and drivers below. You may want to work with these to test your code (i.e. check your output with the
    // sample output provided). 
    public static void loadPreregisteredUsers(ArrayList<User> users)
    {
        try {
            File file = new File("users.txt");
            Scanner text = new Scanner(file);
            while (text.hasNext()) {
                String name = text.nextLine();
                String address = text.nextLine();
                double wallet = text.nextDouble();
                if (text.hasNext())
                    text.nextLine();
                users.add(new User(generateUserAccountId(users), name, address, wallet));
            }
            text.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("users.txt File not Found");
        }
        catch (Exception ex) {
            System.out.println("Error in File Reading for users");
        }
    }

    // Database of Preregistered users
    // In Assignment 2 these will be loaded from a file
    public static void loadPreregisteredDrivers(ArrayList<Driver> drivers)
    {
        try {
            File file = new File("drivers.txt");
            Scanner text = new Scanner(file);
            while (text.hasNext()) {
                String name = text.nextLine();
                String car = text.nextLine();
                String plate = text.nextLine();
                String address = text.nextLine();
                drivers.add(new Driver(generateDriverId(drivers), name, car, plate, address));
            }
            text.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("drivers.txt File not Found");
        }
        catch (Exception ex) {
            System.out.println("Error in File Reading for drivers");
        }
    }
}

