/**
 * A class for TVs. You should complete the following:
 *
 * - Complete the regular constructor
 * - Complete the "copy" constructor
 * - Complete toString
 * - Complete equals
 */
public class TV extends ElectronicsProduct
{
    public enum Type
    {
        LED, OLED, LCD
    }

    private Type type;
    private double screenSize;

    public TV(String name, Type type, double screenSize)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        super(name);
        this.type = type;
        this.screenSize = screenSize;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public TV(TV tv)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        // Remember to copy all values from the given TV.
        // See the ElectronicsProduct constructor of this type for an example
        // You can use super to copy the values in ElectronicsProduct
        super(tv.getModelName());
        this.type = tv.type;
        this.screenSize = tv.screenSize;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public String toString()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //
        // Remember to use super to get toString for needed parts
        return super.toString() + ", Type: "+type+", Screen Size: "+screenSize;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public boolean equals(Object other)
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        // Use super.equals to compare parts in ElectronicsProduct
        TV otherProd = (TV) other;
        if(super.equals(other)&&type==otherProd.type&&screenSize==otherProd.screenSize)
            return true;
        return false;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
