/**
 * A class for testing static variable usage and method overloading. You should complete
 * the following:
 *
 * - Implement two constructors, one that takes in a string and a default constructor.
 * Both should count how many objects have been created
 * - Implement two versions of myMethod, which increments the method counter as
 * specified below
 * - Implement accessors for all private variables
 */
public class StaticVariableClass
{
    private static int constructor_counter = 0;
    private static int method_counter = 0;
    private String name;

    // Create a constructor with no parameters that sets the name to "default"
    // and increases the counter of how many objects of this type have been
    // created
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public StaticVariableClass() {
        name = "default";
        constructor_counter++;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a constructor that stores the name and increases the counter of
    // how many objects of this type have been created.
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public StaticVariableClass(String name) {
        this.name = name;
        constructor_counter++;
    }

    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    public void myMethod()
    {
        // Increment the method counter
        //-----------Start below here. To do: approximate lines of code = 1
        //
        method_counter++;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void myMethod(int toCount)
    {
        // Increase the method counter by the toCount value
        //-----------Start below here. To do: approximate lines of code = 1
        //
        method_counter += toCount;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Create a static accessor for the constructor counter
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public static int getConstructorCounter(){
        return constructor_counter;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a static accessor for the method counter
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public static int getMethodCounter(){
        return method_counter;
    }
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create an accessor for the name
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public String getName(){
        return name;
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

}
