import java.util.ArrayList;

/**
 * A class for a grocery chain which stores an array list of stores.
 *
 * - Add the constructor
 * - Add a method that adds a grocery store to the chain
 * - Implement the getTotalInventory method
 */
public class GroceryChain
{
    private ArrayList<GroceryStore> stores;
    private String name;

    // Add a constructor which takes in a name for the grocery chain and
    // initializes ArrayList
    //-----------Start below here. To do: approximate lines of code = 3
    //
    public GroceryChain(String name){
        this.name = name;
        stores = new ArrayList<GroceryStore>();
    }
    

    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Create a method called addGroceryStore which takes in a GroceryStore
    // and adds it to the ArrayList
    //-----------Start below here. To do: approximate lines of code = 2
    //
    public void addGroceryStore(GroceryStore newStore) {
        stores.add(newStore);
    }
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Calculate the total inventory of the given item over all stores
    // in the ArrayList
    public int getTotalInventory(GroceryStore.GroceryItem type)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        int total = 0;
        for (int i=0; i<stores.size(); i++) {
            total += stores.get(i).getInventory(type);
        }
        return total;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
