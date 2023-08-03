

/**
 * The Item class represents an item that can be stored and sold in a vending machine.
 * It contains information such as the item's name, price, and calories.
 */
public class Item {
    private String name;
    private float price;
    private int calories;

    /**
     * Constructs a new Item object with the specified name, price, and calories.
     *
     * @param name     The name of the item.
     * @param price    The price of the item.
     * @param calories The calories of the item.
     */
    public Item(String name, float price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the calories of the item.
     *
     * @return The calories of the item.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Sets the price of the item.
     *
     * @param price The price to set for the item.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Sets the calories of the item.
     *
     * @param calories The calories to set for the item.
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }
}
