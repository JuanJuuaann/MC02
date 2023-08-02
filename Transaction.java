/**
 * The Transaction class represents a transaction made during the vending machine operation.
 * It contains information about the purchased item, quantity, and total amount for transactions.
 */
public class Transaction {
    private Item item;
    private int quantity;
    private float totalAmount;

    /**
     * Constructs a new Transaction object with the specified item, quantity, and total amount.
     *
     * @param item        The purchased item.
     * @param quantity    The quantity of the purchased item.
     * @param totalAmount The total amount paid for the transaction.
     */
    public Transaction(Item item, int quantity, float totalAmount) {
        this.item = item;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    /**
     * Returns the purchased item.
     *
     * @return The purchased item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns the quantity of the purchased item.
     *
     * @return The quantity of the purchased item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns the total amount paid for the transaction.
     *
     * @return The total amount paid for the transaction.
     */
    public float getTotalAmount() {
        return totalAmount;
    }
}
