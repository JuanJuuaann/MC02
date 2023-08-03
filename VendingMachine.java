import java.util.*;

/**
 * The VendingMachine class represents a vending machine that contains multiple item slots and accepts money for purchases.
 * It provides various functionalities such as creating a vending machine, testing vending features, and performing maintenance tasks.
 */
public class VendingMachine {

    private ArrayList<ItemSlot> slots;
    private Money money;
    public float newTotalMoney;

    /**
     * Constructs a new VendingMachine object with the specified item slots.
     *
     * @param slots an array of ItemSlot objects representing the slots in the vending machine
     */
    public VendingMachine(ArrayList<ItemSlot> slots) {
        // Initialize Vending Machine
        this.slots = slots;

        money = new Money(0, 0, 0, 0, 0, 0, 0);
    }

    public ArrayList<ItemSlot> getSlots() {
        return slots;
    }

    /**
     * Allows the user to select an item and purchase the item from the vending machine.
     *
     * @param slotNumber the slot number of the item to be selected (1-based index)
     */
    public String selectItem(int slotNumber) {
        if (slotNumber < 0 || slotNumber >= slots.size()) {
            return "Invalid slot number. Please enter a valid slot number.";
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        Item selectedItem = selectedSlot.getItem();

        if (selectedItem == null) {
            return "Slot " + (slotNumber + 1) + " is empty.";
        }

        if (selectedSlot.getQuantity() == 0) {
            return "Item " + selectedItem.getName() + " is out of stock.";
        }

        // Implement the logic to process the item selection here
        // For example, you could decrement the quantity and calculate the change to return.

        return "Item " + selectedItem.getName() + " purchased successfully. Enjoy!";
    }

    ////////////////////////////////////////////////////////////TEST VENDING FEATURES

    ////////////////////////////////////////////////////////////TEST MAINTENANCE FEATURES

    /**
     * Adds an item to the specified slot in the vending machine.
     *
     * @param slotNumber  the slot number where the item will be added (1-based index)
     * @param itemName    the name of the item to be added
     * @param itemPrice   the price of the item to be added
     * @param itemCalories  the calorie count of the item to be added
     */
    public void addItem(int slotNumber, String itemName, float itemPrice, int itemCalories) {
        if (slotNumber < 0 || slotNumber >= slots.size()) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        if (selectedSlot == null || selectedSlot.getItem() != null) {
            System.out.println("Slot " + slotNumber + " is already occupied. Please choose another slot.");
            return;
        }

        Item item = new Item(itemName, itemPrice, itemCalories);
        selectedSlot.setItem(item);

        System.out.println("Item added to slot " + slotNumber + 1 + " successfully.");
    }
    public VendingMachine(Money money) {
        this.money = money;
    }

}
