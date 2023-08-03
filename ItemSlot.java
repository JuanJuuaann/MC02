

/**
 * The ItemSlot class represents a slot in the vending machine that holds an item and specific information about the item given by the specs of the MP.
 * It contains information such as the item, quantity available, quantity sold, and amount collected.
 */
public class ItemSlot {
    private Item item;
    private int quantity;
    private int quantitySold;
    private float amountCollected;

    /**
     * Constructs a new ItemSlot object with default values for quantitySold and amountCollected.
     */
    public ItemSlot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;

        this.quantitySold = 0;
        this.amountCollected = 0;
    }

    /**
     * Sets the item in the slot.
     *
     * @param item The item to set in the slot.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Sets the quantity available in the slot.
     *
     * @param quantity The quantity to set in the slot.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the quantity sold from the slot.
     *
     * @param quantitySold The quantity sold to set for the slot.
     */
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    /**
     * Sets the amount collected from the slot.
     *
     * @param amountCollected The amount collected to set for the slot.
     */
    public void setAmountCollected(float amountCollected) {
        this.amountCollected = amountCollected;
    }

    /**
     * Returns the item in the slot.
     *
     * @return The item in the slot.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns the quantity available in the slot.
     *
     * @return The quantity available in the slot.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the quantity sold from the slot.
     *
     * @return The quantity sold from the slot.
     */
    public int getQuantitySold() {
        return quantitySold;
    }

    /**
     * Returns the amount collected from the slot.
     *
     * @return The amount collected from the slot.
     */
    public float getAmountCollected() {
        return amountCollected;
    }

    public void decreaseQuantity(int quantity2) {
    }
}
