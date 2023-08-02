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

        // Add items to the inventory
        //Item item1 = new Item("Item1", 1.99F, 150);
        //Item item2 = new Item("Item2", 2.49F, 200);
        //inventory.addItem(item1);
        //inventory.addItem(item2);
        // Add more items as needed

        money = new Money(0, 0, 0, 0, 0, 0, 0);
    }

    public ArrayList<ItemSlot> getSlots() {
        return slots;
    }

    
    ////////////////////////////////////////////////////////////
    /**
     * Allows the user to test the features of a vending machine.
     * Provides options to test vending features or maintenance features.
     */
    public void testVendingMachine() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Test a Vending Machine:");
            System.out.println("1. Test Vending Features");
            System.out.println("2. Test Maintenance Features");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testVendingFeatures();
                    break;
                case 2:
                    testMaintenanceFeatures();
                    break;
                case 3:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    ////////////////////////////////////////////////////////////TEST VENDING FEATURES
    /**
     * Allows the user to test the vending features of the vending machine.
     * Displays the available items in the vending machine and provides options to select and buy an item.
     * The user can perform multiple tests until they choose to return to the main menu such as buying an item and providing money to the vending.
     */
    private void testVendingFeatures() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 2) {
            System.out.println("Test Vending Features:");
            System.out.println("Available Items in the Vending Machine:");
            displayItems();

            System.out.println("\n\n1. Select an item to buy");
            System.out.println("2. Return to the main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter slot number: ");
                    int slotNumber = scanner.nextInt();
                    selectItem(slotNumber - 1);
                    break;
                case 2:
                    System.out.println("Returning to the main menu..");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
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
     * Allows the user to test maintenance features of the vending machine.
     * This includes options to add, restock, remove, and modify items, as well as manage payments and display transaction summaries.
     */
    private void testMaintenanceFeatures() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 9) {
            System.out.println("Maintenance Features:");
            System.out.println("1. Add items");
            System.out.println("2. Restock items");
            System.out.println("3. Remove items");
            System.out.println("4. Modify item prices");
            System.out.println("5. Modify Calories");
            System.out.println("6. Collect/Replenish payments/money denomination");
            System.out.println("7. Display Items");
            System.out.println("8. Print transaction summary");
            System.out.println("9. Exit maintenance features");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter slot number: ");
                    int slotNumber = scanner.nextInt() - 1;
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter item price: ");
                    float itemPrice = scanner.nextFloat();
                    System.out.print("Enter calorie count: ");
                    int itemCalories = scanner.nextInt();

                    addItem(slotNumber, itemName, itemPrice, itemCalories);
                    break;
                case 2:
                    restockItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    setPrice();
                    break;
                case 5:
                    setCalories();
                    break;
                case 6:
                    vendingMoney();
                    break;
                case 7:
                    displayItems();
                    break;
                case 8:
                    summary();
                    break;
                case 9:
                    System.out.println("Exiting maintenance features.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
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




    /**
     * Removes an item from the specified slot in the vending machine.
     * If the slot is already empty, a message is displayed indicating that the slot is empty.
     */
    public void removeItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the slot number to remove an item: ");
        int slotNumber = scanner.nextInt() - 1;

        if (slotNumber < 0 || slotNumber >= slots.size()) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        if (selectedSlot == null) {
            System.out.println("Slot " + slotNumber + " is already empty. Press any button to continue.");
            scanner.nextLine();
        } else {
            selectedSlot.setItem(null);
            System.out.println("Item removed from slot " + slotNumber + " successfully.");
        }
    }


    /**
     * Displays the items available in the vending machine along with their respective quantities.
     * If a slot is empty, it is indicated as "Empty".
     */
    public void displayItems() {
        // Display the items available in the vending machine
        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);
            if (slot != null && slot.getItem() != null) {
                Item item = slot.getItem();
                int quantity = slot.getQuantity();

                System.out.println("Slot " + (i + 1) + ": " + item.getName() + " (Quantity: " + quantity + ")");
            } else {
                System.out.println("Slot " + (i + 1) + ": Empty");
            }
        }
    }


    /**
     * Restocks the quantity of items in a selected slot of the vending machine.
     * Prompts the user to choose a slot and enter the quantity to add to the stock.
     * The maximum capacity per slot is 10 items.
     * If the slot is empty or an invalid slot number is entered, an appropriate message is displayed.
     */
    public void restockItem() {
        Scanner scanner = new Scanner(System.in);

        displayItems();

        System.out.print("\n\nEnter the slot to restock (1-8): ");
        int slotNumber = scanner.nextInt() - 1;

        if (slotNumber < 0 || slotNumber >= slots.size()) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        Item item = selectedSlot.getItem();

        if (item == null) {
            System.out.println("Slot " + slotNumber + " is empty. Cannot restock.");
        } else {
            boolean counter = false;

            while (!counter) {
                System.out.println("Item: " + item.getName());
                System.out.println("Current quantity: " + selectedSlot.getQuantity());
                System.out.print("Enter the quantity to add to the stock (Maximum of 10 Capacity): ");
                int quantityToRestock = scanner.nextInt();

                int totalQuantity = selectedSlot.getQuantity() + quantityToRestock;

                if (totalQuantity > 10) {
                    System.out.println("Exceeded maximum capacity. Try again.");
                    return;
                } else {
                    selectedSlot.setQuantity(totalQuantity);
                    System.out.println("Restocked " + quantityToRestock + " more items in slot " + slotNumber + ".");
                    counter = true;
                }
            }
        }
    }


    /**
     * Sets the price for an item in a selected slot of the vending machine.
     * Prompts the user to choose a slot and enter the new price for the item.
     * If the slot is empty or an invalid slot number is entered, an appropriate message is displayed.
     */
    public void setPrice() {
        Scanner scanner = new Scanner(System.in);

        displayItems();

        System.out.print("\n\nEnter the slot to set the price (1-8): ");
        int slotNumber = scanner.nextInt() - 1;

        if (slotNumber < 0 || slotNumber >= slots.size()) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        Item item = selectedSlot.getItem();

        if (item == null) {
            System.out.println("Slot " + slotNumber + " is empty. Cannot set the price.");
        } else {
            System.out.println("Item: " + item.getName());
            System.out.println("Current price: $" + item.getPrice());

            System.out.print("Enter the new price for the item: $");
            float newPrice = scanner.nextFloat();

            item.setPrice(newPrice);
            System.out.println("Price updated successfully for slot " + slotNumber + ".");
        }
    }


    /**
     * Sets the calorie count for an item in a selected slot of the vending machine.
     * Prompts the user to choose a slot and enter the new calorie count for the item.
     * If the slot is empty or an invalid slot number is entered, an appropriate message is displayed.
     */
    public void setCalories(){
        Scanner scanner = new Scanner(System.in);

        displayItems();

        System.out.print("\n\nEnter the slot to modify the calories (1-8): ");
        int slotNumber = scanner.nextInt() - 1;

        if (slotNumber < 0 || slotNumber >= slots.size()) {
            System.out.println("Invalid slot number. Please try again.");
            return;
        }

        ItemSlot selectedSlot = slots.get(slotNumber);
        Item item = selectedSlot.getItem();

        if (item == null) {
            System.out.println("Slot " + slotNumber + " is empty. Cannot set the calories.");
        } else {
            System.out.println("Item: " + item.getName());
            System.out.println("Current calories: " + item.getCalories());

            System.out.print("Enter the new calories: ");
            int newCalorie = scanner.nextInt();

            item.setCalories(newCalorie);
            System.out.println("Calories updated successfully for slot " + slotNumber + ".");
        }
    }


    /**
     * Allows maintenance personnel to manage the money in the vending machine.
     * Prompts the user to choose from various options such as adding bills or coins,
     * collecting money, and displaying the current amount of money in the machine.
     * The user can continue performing actions until choosing to exit the money feature.
     */
    public void vendingMoney() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 9) {
            System.out.println("\nCurrent Money in the Machine: $" + money.getTotalAmount() + newTotalMoney);

            System.out.println("\n1. Add 1 dollar bills");
            System.out.println("2. Add 5 dollar bills");
            System.out.println("3. Add 10 dollar bills");
            System.out.println("4. Add quarters");
            System.out.println("5. Add dimes");
            System.out.println("6. Add nickels");
            System.out.println("7. Add Pennies");
            System.out.println("8. Collect Money");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            System.out.print("\n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the number of one dollar bills: ");
                    int oneDollarBills = scanner.nextInt();
                    money.addOneDollarBills(oneDollarBills);
                    break;

                case 2:
                    System.out.print("Enter the number of five dollar bills: ");
                    int fiveDollarBills = scanner.nextInt();
                    money.addFiveDollarBills(fiveDollarBills);
                    break;

                case 3:
                    System.out.print("Enter the number of ten dollar bills: ");
                    int tenDollarBills = scanner.nextInt();
                    money.addTenDollarBills(tenDollarBills);
                    break;

                case 4:
                    System.out.print("Enter the number of quarters: ");
                    int quarters = scanner.nextInt();
                    money.addQuarters(quarters);
                    break;

                case 5:
                    System.out.print("Enter the number of dimes: ");
                    int dimes = scanner.nextInt();
                    money.addDimes(dimes);
                    break;

                case 6:
                    System.out.print("Enter the number of nickels: ");
                    int nickels = scanner.nextInt();
                    money.addNickels(nickels);
                    break;

                case 7:
                    System.out.print("Enter the number of pennies: ");
                    int pennies = scanner.nextInt();
                    money.addPennies(pennies);
                    break;

                case 8:
                    System.out.print("How much money would you like to collect?: ");
                    float moneyCollect = scanner.nextFloat();

                    if (moneyCollect > money.getTotalAmount() || moneyCollect < money.getTotalAmount()) {
                        System.out.print("Make sure to collect within the total amount of money in the machine. Try again.");
                        return;
                    } else {
                        System.out.println("\nCollecting the Money...");
                        money.reset();
                        System.out.println("Money collected. Press any button to continue.");
                        scanner.nextLine();
                        break;
                    }

                case 9:
                    System.out.println("Exiting Money feature.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    /**
     * Displays a summary of the vending machine's inventory and sales.
     * The method displays the starting inventory, sales summary (quantity sold and amount collected),
     * total amount collected, total money in the machine, and ending inventory.
     */
    public void summary() {
        // Display starting inventory
        System.out.println("\nStarting Inventory:");
        displayItems();

        // Static starting money at creation of vending
        float totalAmountCollected = 0;

        // Display quantity of each item sold and calculate total amount collected
        System.out.println("\nSales Summary: ");

        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);

            if (slot != null) {
                Item item = slot.getItem();
                int quantitySold = slot.getQuantitySold();
                float amountCollected = slot.getAmountCollected();

                System.out.println("Item: " + item.getName());
                System.out.println("Quantity Sold: " + quantitySold);
                System.out.println("Amount Collected: $" + amountCollected);

                totalAmountCollected += amountCollected;
            }
        }

        // Display total amount collected
        System.out.println("\nTotal Amount Collected: $" + totalAmountCollected);

        System.out.println("\nTotal money in the machine: $" + newTotalMoney);

        // Display ending inventory
        System.out.println("\nEnding Inventory:");
        displayItems();
    }
    public void listofitems() {
        
        
        addItem(1, "Rice", 1F, 150);
        addItem(2, "Noodles", 1F, 200);
        addItem(3, "Chicken", 2.49F, 400);
        addItem(4, "Beef", 3.49F, 500);
        addItem(5, "Pork", 3F, 500);
        addItem(6, "Soup", 0.49F, 15);
        addItem(7, "Sauce", 0.49F, 15);
        addItem(8, "Drink", 1F, 50);
    }
}
