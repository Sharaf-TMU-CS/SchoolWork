/**
 * A class for an electronics product.
 *
 * You do not have to modify the following.
 */
public class ElectronicsProduct
{
    private String name;
    private int stock;

    public ElectronicsProduct(String name)
    {
        this.name = name;
        stock = 0;
    }

    public ElectronicsProduct(ElectronicsProduct p)
    {
        // Notice that the values are copied over from p
        this.name = p.name;
        this.stock = p.stock;
    }

    public String getModelName()
    {
        return name;
    }

    public void addStock(int amount)
    {
        stock += amount;
    }

    public int getStock()
    {
        return stock;
    }

    public boolean equals(Object other)
    {
        ElectronicsProduct otherProd = (ElectronicsProduct) other;
        return name.equals(otherProd.name);
    }

    public String toString()
    {
        return "Model: " + name + ", Stock: " + stock;
    }
}
