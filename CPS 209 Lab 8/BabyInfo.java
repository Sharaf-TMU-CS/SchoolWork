/**
 * A class to hold baby information
 */
public class BabyInfo
{
    private String name;
    private int count;

    public BabyInfo(String name, int count)
    {
        this.name = name;
        this.count = count;
    }

    public String getName()
    {
        return name;
    }

    public int getCount()
    {
        return count;
    }

    public String toString()
    {
        return name + "\t" + count;
    }
}
