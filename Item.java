
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String description;
    private double weight;

    /**
     * Create an item with a description and weight.
     * @param description What the item is.
     * @param weight The item's weight.
     */
    public Item(String description, double weight)
    {
        this.description = description;
        this.weight = weight;
    }

    /**
     * @return The description of the item.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The weight of the item.
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * @return A long description of the item.
     */
    public String getLongDescription()
    {
        return description + " (weight: " + weight + ")";
    }
}