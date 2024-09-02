import java.util.ArrayList;

/**
 * A class for an ElectronicsStore. You are to complete the following:
 *
 * - Initialization of the array lists in the constructor
 * - The addComputerStock method
 * - The addTVStock method
 */
public class ElectronicsStore
{
    private ArrayList<Computer> computers;
    private ArrayList<TV> tvs;

    public ElectronicsStore()
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        computers = new ArrayList<Computer>();
        tvs = new ArrayList<TV>();

        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public int getNumberDifferentComputers()
    {
        return computers.size();
    }

    public int getNumberDifferentTVs()
    {
        return tvs.size();
    }

    public Computer getComputer(int index)
    {
        return computers.get(index);
    }

    public TV getTV(int index)
    {
        return tvs.get(index);
    }

    public void addComputerStock(Computer computer)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        // Check if the computer is already in the computers array list.
        // If it isn't, add a copy to the array list (NOT THE ORIGINAL REFERENCE)
        // If it is, then just add the new stock to the computer already in the array list
        // The arrayList.indexOf(element) command may be helpful for this. It finds the
        // element in arrayList and returns its index. If it isn't there, it returns -1
        // Note, that indexOf uses equals, so that must be implemented correctly
        boolean uniqueComputer = true;
        for (int i=0; i<computers.size();i++) {
            if (computer.equals(computers.get(i))) {
                computers.get(i).addStock(computer.getStock());
                uniqueComputer = false;
                break;
            }
        }
        if (uniqueComputer) {
            Computer newComputer = new Computer(computer);
            computers.add(newComputer);
            int temp = computer.getStock();
            newComputer.addStock(temp);
        }
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void addTVStock(TV tv)
    {
        //-----------Start below here. To do: approximate lines of code = 5
        //
        // Check if the tv is already in the tvs array list.
        // If it isn't, add a copy to the array list (NOT THE ORIGINAL REFERENCE)
        // If it is, then just add the new stock to the tv already in the array list
        // The arrayList.indexOf(element) command may be helpful for this. It finds the
        // element in arrayList and returns its index. If it isn't there, it returns -1
        // Note, that indexOf uses equals, so that must be implemented correctly
        boolean uniqueTV = true;
        for (int i=0; i<tvs.size();i++) {
            if (tv.equals(tvs.get(i))) {
                tvs.get(i).addStock(tv.getStock());
                uniqueTV = false;
                break;
            }
        }
        if (uniqueTV) {
            TV newTV = new TV(tv);
            tvs.add(newTV);
            int temp = tv.getStock();
            newTV.addStock(temp);
        }
        
    
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
