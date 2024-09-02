import java.util.ArrayList;

/**
 * This class keeps track of a menu of items, stored as an ArrayList of
 * strings. For this question you should complete the following:
 * <p>
 * - Complete the Menu constructor to initialize an empty array list of
 * Strings
 * - Complete the "addOption" method to add a new menu option to the end
 * of the list
 * - Create the "getMenuString" method, which outputs the menu as specified
 * - Create the "getOption" method, which returns the requested menu
 * option, where the input starts at 1. If an invalid number is entered,
 * this method returns 0
 * <p>
 * This class is tested by MenuTester.java, which will also help you further
 * understand the method definitions.
 */
public class Menu
{
    private ArrayList<String> menuItems;


    /**
     * Constructs a menu with no options.
     */
    public Menu()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // initialize menuItems to an empty array list of Strings
        menuItems = new ArrayList<String>();
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Adds a new menu item to the end of this menu.
     *
     * @param item the menu item to add
     */
    public void addOption(String item)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // simply add the given item to the end of the array list
        menuItems.add(item);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    //-----------Start below here. To do: approximate lines of code = 6
    //
    // Create a public method called getMenuString which returns a String representation of the
    // the menu
    // Start by creating an empty String, then add one item to it at a time
    // for each item in the menu, print the menu item number (add 1 to the item number index in the array list)
    // followed by a ". " followed by the item name.
    public String getMenuString() {
        String menu = "";
        for (int i=0; i<menuItems.size(); i++)  {
            int num = 1+i;
            menu += (num+". "+menuItems.get(i)+"\n");
        }
        return menu;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    //-----------Start below here. To do: approximate lines of code = 4
    //
    // Create a public method called getOption which takes in an integer and
    // returns the item in the menu at that index
    // It should be indexed starting at 1 however
    // If the item number is not valid, return a ""
    public String getOption(int index) {
        try {
            return menuItems.get(index-1);
        }
        catch(Exception e) {
            return "";
        }
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
}
