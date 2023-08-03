import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class MainView {
    private JFrame mainFrame;
    private VendingMachine vendingMachine; //VendingMachine variable
    private SpecialVendingMachine specialvendingMachine;
    private Money money;
    private ArrayList<Integer> selectedSlots = new ArrayList<>();


    public MainView(Money money) {
        this.money = money;

        money = new Money(0,0,0,0,0,0,0);

        mainFrame = new JFrame("Vending Machine Management System");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Initialization methods
        initializeGreetingElements();
        initializeAlignmentElements();

        mainFrame.setVisible(true);
    }

    private void initializeGreetingElements() {
        JLabel greetingLabel = new JLabel("Welcome to the Vending Machine Management System!");
        mainFrame.add(greetingLabel);
    }

    private void initializeAlignmentElements() {
        JPanel alignmentPanel = new JPanel();
        alignmentPanel.setLayout(new FlowLayout());

        JButton createVendingMachineButton = new JButton("Create a normal Vending Machine");
        JButton createSpecialVendingMachineButton = new JButton("Create a special Vending Machine");
        JButton testVendingMachineButton = new JButton("Test a Vending Machine");
        JButton exitButton = new JButton("Exit");

        createVendingMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createVendingMachine();
            }
        });
        createSpecialVendingMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSpecialVendingMachine();
            }
        });

        testVendingMachineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickVendingMachine();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        alignmentPanel.add(createVendingMachineButton);
        alignmentPanel.add(createSpecialVendingMachineButton);
        alignmentPanel.add(testVendingMachineButton);
        alignmentPanel.add(exitButton);

        mainFrame.add(alignmentPanel);
    }

    public void createVendingMachine() {
        if (vendingMachine == null) {
            // Create the ItemSlot array and pass to the VendingMachine constructor
            ArrayList<ItemSlot> slots = createItemSlots();
            vendingMachine = new VendingMachine(slots);
            showMessage("Vending Machine created.");
        } else {
            showMessage("Vending Machine already created.");
        }
    }
    public void createSpecialVendingMachine() {
        if (specialvendingMachine == null) {
            // Create the ItemSlot array and pass to the VendingMachine constructor
            ArrayList<ItemSlot> slots = createSpecialItemSlots();
            specialvendingMachine = new SpecialVendingMachine(slots);
            showMessage("Special Vending Machine created.");
        } else {
            showMessage("Special Vending Machine already created.");
        }
    }

    private void pickVendingMachine(){
        if (vendingMachine != null || specialvendingMachine != null) {
            Object[] options = {"Test Normal Vending Machine", "Test Special Vending Machine", "Cancel"};
            int choice = JOptionPane.showOptionDialog(
                    mainFrame,
                    "Test a Vending Machine:",
                    "Test Vending Machine",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case JOptionPane.YES_OPTION:
                    testVendingMachine();
                    break;
                case JOptionPane.NO_OPTION:
                    testSpecialVendingMachine();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    break;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        } else {
            showMessage("Vending Machine not created yet. Please create one first.");
        }
    }
    private void testVendingMachine() {
        if (vendingMachine != null || specialvendingMachine == null) {
            Object[] options = {"Test Vending Features", "Test Maintenance Features", "Cancel"};
            int choice = JOptionPane.showOptionDialog(mainFrame, "Test a Vending Machine:", "Test Vending Machine", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case JOptionPane.YES_OPTION:
                    testVendingFeatures();
                    break;
                case JOptionPane.NO_OPTION:
                    testMaintenanceFeatures1();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    break;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
        else {
            showMessage("Vending Machine not created yet. Please create one first.");
        }
    }
    private void testSpecialVendingMachine() {
        if (vendingMachine == null || specialvendingMachine != null) {
            Object[] options = {"Test Vending Features", "Test Maintenance Features", "Cancel"};
            int choice = JOptionPane.showOptionDialog(mainFrame, "Test a Vending Machine:", "Test Vending Machine", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case JOptionPane.YES_OPTION:
                    testSpecialVendingFeatures();
                    break;
                case JOptionPane.NO_OPTION:
                    testSpecialVendingMachineFeat();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    break;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
        else {
            showMessage("Vending Machine not created yet. Please create one first.");
        }
    }
    private void testVendingFeatures() {
        while (true) {
            Object[] options = { "Select an item to buy", "Return to the main menu" };
            int choice = JOptionPane.showOptionDialog(mainFrame, "Test Vending Features:\nAvailable Items in the Vending Machine:\n" + getItemsString(), "Test Vending Features", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == JOptionPane.YES_OPTION) {
                selectItem();
            } else if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                break;
            } else if (choice == JOptionPane.CLOSED_OPTION) {
                //If user closed the dialog without selecting an option.
                JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                break;
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
            }
        }
    }
    private void testSpecialVendingFeatures() {
        while (true) {
            Object[] options = { "Select an item to buy", "Return to the main menu" };
            int choice = JOptionPane.showOptionDialog(mainFrame, "Test Vending Features:\nAvailable Items in the Vending Machine:\n" + sgetItemsString(), "Test Vending Features", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            if (choice == JOptionPane.YES_OPTION) {
                sselectItem();
            } else if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                break;
            } else if (choice == JOptionPane.CLOSED_OPTION) {
                //If user closed the dialog without selecting an option.
                JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                break;
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
            }
        }
    }
    private String getItemsString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ItemSlot> slots = vendingMachine.getSlots();
        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);
            sb.append(i + 1).append(". ");
            if (slot.getItem() != null) {
                sb.append(slot.getItem().getName()).append(" - $").append(slot.getItem().getPrice()).append(" - Quantity: ").append(slot.getQuantity());
            } else {
                sb.append("Empty");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    private String sgetItemsString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ItemSlot> slots = specialvendingMachine.getSlots();
        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);
            sb.append(i + 1).append(". ");
            if (slot.getItem() != null) {
                sb.append(slot.getItem().getName()).append(" - $").append(slot.getItem().getPrice()).append(" - Quantity: ").append(slot.getQuantity());
            } else {
                sb.append("Empty");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    private void selectItem() {
        String input = JOptionPane.showInputDialog(mainFrame, "Enter the slot number:");
        try {
            int slotNumber = Integer.parseInt(input);
            String result = vendingMachine.selectItem(slotNumber - 1);
            showMessage(result);
        } catch (NumberFormatException e) {
            showMessage("Invalid slot number. Please enter a valid number.");
        }
    }
    public void sselectItem() {
        String input = JOptionPane.showInputDialog(mainFrame, "Enter the slot number:");
        try {
            int slotNumber = Integer.parseInt(input);
            String result = specialvendingMachine.selectItem(slotNumber - 1);
            showMessage(result);

            selectedSlots.add(slotNumber);
            printSpecialMessage(selectedSlots);
        } catch (NumberFormatException e) {
            showMessage("Invalid slot number. Please enter a valid number.");
        }
    }

    private void testMaintenanceFeatures1() {

        JPanel maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));

        JButton addRegularItemsButton = new JButton("Add regular items");
        JButton restockItemsButton = new JButton("Restock items");
        JButton removeItemsButton = new JButton("Remove items");
        JButton modifyItemPricesButton = new JButton("Modify item prices");
        JButton nextPageButton = new JButton("Modify Calories");
        JButton cancelButton = new JButton("Cancel");

        // Add action listeners for each button as needed

        maintenancePanel.add(addRegularItemsButton);
        maintenancePanel.add(restockItemsButton);
        maintenancePanel.add(removeItemsButton);
        maintenancePanel.add(modifyItemPricesButton);
        maintenancePanel.add(nextPageButton);
        maintenancePanel.add(cancelButton);

        mainFrame.add(maintenancePanel);
        while (true) {
            Object[] options = {
                    "Add regular items",
                    "Restock items",
                    "Remove items",
                    "Modify item prices",
                    "Next Page",
                    "Cancel"
            };

            int choice = JOptionPane.showOptionDialog(
                    mainFrame,
                    "Maintenance Features:",
                    "Maintenance Features",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    addRegularItems();
                    break;
                case 1:
                    restockItems();
                    break;
                case 2:
                    removeItems();
                    break;
                case 3:
                    modifyItemPrices();
                    break;
                case 4:
                    testMaintenanceFeatures2();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    return;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void testMaintenanceFeatures2() {

        JPanel maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));

        JButton modifyCaloriesButton = new JButton("Modify Calories");
        JButton collectPaymentsButton = new JButton("Collect/Replenish payments/money denominations");
        JButton displayItemsButton = new JButton("Display Items");
        JButton prevPageButton = new JButton("Previous Page");
        JButton cancelButton = new JButton("Cancel");

        // Add action listeners for each button as needed

        maintenancePanel.add(modifyCaloriesButton);
        maintenancePanel.add(collectPaymentsButton);
        maintenancePanel.add(displayItemsButton);
        maintenancePanel.add(prevPageButton);
        maintenancePanel.add(cancelButton);

        mainFrame.add(maintenancePanel);
        while (true) {
            Object[] options = {
                    "Modify Calories",
                    "Collect/Replenish payments/money denominations",
                    "Display Items",
                    "Previous Page",
                    "Cancel"
            };

            int choice = JOptionPane.showOptionDialog(
                    mainFrame,
                    "Maintenance Features:",
                    "Maintenance Features",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    modifyCalories();
                    break;
                case 1:
                    collectOrReplenishPayments(money);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    testMaintenanceFeatures1();
                    return;
                case 4:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    return;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addRegularItems() {
        JTextField slotNumberField = new JTextField(5);
        JTextField itemNameField = new JTextField(15);
        JTextField itemPriceField = new JTextField(10);
        JTextField itemCaloriesField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Slot Number (1-8):"));
        inputPanel.add(slotNumberField);
        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(itemNameField);
        inputPanel.add(new JLabel("Item Price:"));
        inputPanel.add(itemPriceField);
        inputPanel.add(new JLabel("Item Calories:"));
        inputPanel.add(itemCaloriesField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Add Regular Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = Integer.parseInt(slotNumberField.getText()) - 1;
                String itemName = itemNameField.getText();
                float itemPrice = Float.parseFloat(itemPriceField.getText());
                int itemCalories = Integer.parseInt(itemCaloriesField.getText());

                vendingMachine.addItem(slotNumber, itemName, itemPrice, itemCalories);
                showMessage("Regular item added successfully.");
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter valid numbers.");
            }
        }
    }
    private void restockItems() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField quantityField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Quantity to Restock (Maximum of 10 Capacity):"));
        inputPanel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Restock Items", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                int quantityToRestock = Integer.parseInt(quantityField.getText());

                ItemSlot selectedSlot = specialvendingMachine.getSlots().get(slotNumber);
                int totalQuantity = selectedSlot.getQuantity() + quantityToRestock;

                if (totalQuantity > 10) {
                    showMessage("Exceeded maximum capacity. Try again.");
                }
                else {
                    selectedSlot.setQuantity(totalQuantity);
                    showMessage("Restocked " + quantityToRestock + " more items in slot " + (slotNumber + 1) + ".");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void srestockItems() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < specialvendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField quantityField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Quantity to Restock (Maximum of 10 Capacity):"));
        inputPanel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Restock Items", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                int quantityToRestock = Integer.parseInt(quantityField.getText());

                ItemSlot selectedSlot = vendingMachine.getSlots().get(slotNumber);
                int totalQuantity = selectedSlot.getQuantity() + quantityToRestock;

                if (totalQuantity > 10) {
                    showMessage("Exceeded maximum capacity. Try again.");
                }
                else {
                    selectedSlot.setQuantity(totalQuantity);
                    showMessage("Restocked " + quantityToRestock + " more items in slot " + (slotNumber + 1) + ".");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void removeItems() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Remove Items", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            int slotNumber = slotComboBox.getSelectedIndex();
            ItemSlot selectedSlot = vendingMachine.getSlots().get(slotNumber);
            Item item = selectedSlot.getItem();

            if (item == null) {
                showMessage("Slot " + (slotNumber + 1) + " is already empty.");
            } else {
                selectedSlot.setItem(null);
                selectedSlot.setQuantity(0);
                showMessage("Item removed from slot " + (slotNumber + 1) + " successfully.");
            }
        }
    }
    private void modifyItemPrices() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField newPriceField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Enter New Price:"));
        inputPanel.add(newPriceField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Modify Item Prices", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                float newPrice = Float.parseFloat(newPriceField.getText());

                ItemSlot selectedSlot = vendingMachine.getSlots().get(slotNumber);
                Item item = selectedSlot.getItem();

                if (item == null) {
                    showMessage("Slot " + (slotNumber + 1) + " is empty. Cannot modify prices.");
                } else {
                    item.setPrice(newPrice);
                    showMessage("Price for the item in slot " + (slotNumber + 1) + " modified successfully.");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void smodifyItemPrices() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < specialvendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField newPriceField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Enter New Price:"));
        inputPanel.add(newPriceField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Modify Item Prices", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                float newPrice = Float.parseFloat(newPriceField.getText());

                ItemSlot selectedSlot = vendingMachine.getSlots().get(slotNumber);
                Item item = selectedSlot.getItem();

                if (item == null) {
                    showMessage("Slot " + (slotNumber + 1) + " is empty. Cannot modify prices.");
                } else {
                    item.setPrice(newPrice);
                    showMessage("Price for the item in slot " + (slotNumber + 1) + " modified successfully.");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void modifyCalories() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < vendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField newCaloriesField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Enter New Calories:"));
        inputPanel.add(newCaloriesField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Modify Item Calories", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                int newCalories = Integer.parseInt(newCaloriesField.getText());

                ItemSlot selectedSlot = vendingMachine.getSlots().get(slotNumber);
                Item item = selectedSlot.getItem();

                if (item == null) {
                    showMessage("Slot " + (slotNumber + 1) + " is empty. Cannot modify calories.");
                } else {
                    item.setCalories(newCalories);
                    showMessage("Calorie count for the item in slot " + (slotNumber + 1) + " modified successfully.");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void smodifyCalories() {
        JComboBox<String> slotComboBox = new JComboBox<>();
        for (int i = 0; i < specialvendingMachine.getSlots().size(); i++) {
            slotComboBox.addItem("Slot " + (i + 1));
        }

        JTextField newCaloriesField = new JTextField(5);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Select Slot:"));
        inputPanel.add(slotComboBox);
        inputPanel.add(new JLabel("Enter New Calories:"));
        inputPanel.add(newCaloriesField);

        int result = JOptionPane.showConfirmDialog(mainFrame, inputPanel, "Modify Item Calories", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int slotNumber = slotComboBox.getSelectedIndex();
                int newCalories = Integer.parseInt(newCaloriesField.getText());

                ItemSlot selectedSlot = specialvendingMachine.getSlots().get(slotNumber);
                Item item = selectedSlot.getItem();

                if (item == null) {
                    showMessage("Slot " + (slotNumber + 1) + " is empty. Cannot modify calories.");
                } else {
                    item.setCalories(newCalories);
                    showMessage("Calorie count for the item in slot " + (slotNumber + 1) + " modified successfully.");
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.");
            }
        }
    }
    private void collectOrReplenishPayments(Money money) {
        String[] options = {"Collect", "Replenish"};
        int result = JOptionPane.showOptionDialog(mainFrame, "Do you want to collect or replenish payments?", "Collect/Replenish Payments", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION) {
            boolean isCollect = (result == JOptionPane.YES_OPTION);

            if (isCollect) {
                money.reset();
                showMessage("Money collected successfully.");
            } else {
                int option = 0;

                while (option != 8) {
                    String message = "\nCurrent Money in the Machine: $" + money.getTotalAmount() + "\n\n";
                    message += "1. Add 1 dollar bills\n";
                    message += "2. Add 5 dollar bills\n";
                    message += "3. Add 10 dollar bills\n";
                    message += "4. Add quarters\n";
                    message += "5. Add dimes\n";
                    message += "6. Add nickels\n";
                    message += "7. Add Pennies\n";
                    message += "8. Exit\n";

                    try {
                        option = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, message + "\nEnter your choice:"));
                    } catch (NumberFormatException e) {
                        showMessage("Invalid input. Please enter a valid number.");
                        continue;
                    }

                    switch (option) {
                        case 1:
                            try {
                                int oneDollarBills = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of one dollar bills:"));
                                money.addOneDollarBills(oneDollarBills);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 2:
                            try {
                                int fiveDollarBills = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of five dollar bills:"));
                                money.addFiveDollarBills(fiveDollarBills);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 3:
                            try {
                                int tenDollarBills = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of ten dollar bills:"));
                                money.addTenDollarBills(tenDollarBills);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 4:
                            try {
                                int quarters = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of quarters:"));
                                money.addQuarters(quarters);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 5:
                            try {
                                int dimes = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of dimes:"));
                                money.addDimes(dimes);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 6:
                            try {
                                int nickels = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of nickels:"));
                                money.addNickels(nickels);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 7:
                            try {
                                int pennies = Integer.parseInt(JOptionPane.showInputDialog(mainFrame, "Enter the number of pennies:"));
                                money.addPennies(pennies);
                            } catch (NumberFormatException e) {
                                showMessage("Invalid input. Please enter a valid number.");
                            }
                            break;

                        case 8:
                            showMessage("Exiting Money feature.");
                            break;

                        default:
                            showMessage("Invalid option. Please try again.");
                            break;
                    }
                }
            }
        }
    }


    private void display() {
        ArrayList<ItemSlot> slots = vendingMachine.getSlots();
        StringBuilder itemList = new StringBuilder("Items in the Vending Machine:\n");

        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);
            String itemName = slot.getItem() != null ? slot.getItem().getName() : "Empty";
            itemList.append(i + 1).append(". ").append(itemName).append("\n");
        }

        JOptionPane.showMessageDialog(mainFrame, itemList.toString());
    }
    private void sdisplay() {
        ArrayList<ItemSlot> slots = specialvendingMachine.getSlots();
        StringBuilder itemList = new StringBuilder("Items in the Vending Machine:\n");

        for (int i = 0; i < slots.size(); i++) {
            ItemSlot slot = slots.get(i);
            String itemName = slot.getItem() != null ? slot.getItem().getName() : "Empty";
            itemList.append(i + 1).append(". ").append(itemName).append("\n");
        }

        JOptionPane.showMessageDialog(mainFrame, itemList.toString());
    }
    private ArrayList<ItemSlot> createItemSlots() {

        ArrayList<ItemSlot> slots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            slots.add(new ItemSlot(null, 0));
        }
        return slots;
    }
    private ArrayList<ItemSlot> createSpecialItemSlots() {

        ArrayList<ItemSlot> slots = new ArrayList<>();
        Item riceitem = new Item("Rice", 1, 150);
        slots.add(new ItemSlot(riceitem, 10));
        Item noodlesitem = new Item("Noodles", 1, 200);
        slots.add(new ItemSlot(noodlesitem, 10));
        Item chickenitem = new Item("Chicken", 2.49F, 400);
        slots.add(new ItemSlot(chickenitem, 10));
        Item beefitem = new Item("Beef", 3.49F, 500);
        slots.add(new ItemSlot(beefitem, 10));
        Item porkitem = new Item("Pork", 3, 500);
        slots.add(new ItemSlot(porkitem, 10));
        Item soupitem = new Item("Soup", 0.49F, 15);
        slots.add(new ItemSlot(soupitem, 10));
        Item sauceitem = new Item("Sauce", 0.49F, 15);
        slots.add(new ItemSlot(sauceitem, 10));
        Item drinkitem = new Item("Drink", 1, 50);
        slots.add(new ItemSlot(drinkitem, 10));

            return slots;
        }

    private void testSpecialVendingMachineFeat() {

        JPanel maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));

        JButton restockItemsButton = new JButton("Restock items");
        JButton modifyItemPricesButton = new JButton("Modify item prices");
        JButton nextPageButton = new JButton("Modify Calories");
        JButton cancelButton = new JButton("Cancel");

        // Add action listeners for each button as needed

        maintenancePanel.add(restockItemsButton);
        maintenancePanel.add(modifyItemPricesButton);
        maintenancePanel.add(nextPageButton);
        maintenancePanel.add(cancelButton);

        mainFrame.add(maintenancePanel);
        while (true) {
            Object[] options = {
                    "Restock items",
                    "Modify item prices",
                    "Next Page",
                    "Cancel"
            };

            int choice = JOptionPane.showOptionDialog(
                    mainFrame,
                    "Maintenance Features:",
                    "Maintenance Features",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    srestockItems();
                    break;
                case 1:
                    smodifyItemPrices();
                    break;
                case 2:
                    testSpecialVendingMachine2();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    return;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
    


    }
    private void testSpecialVendingMachine2() {

        JPanel maintenancePanel = new JPanel();
        maintenancePanel.setLayout(new BoxLayout(maintenancePanel, BoxLayout.Y_AXIS));

        JButton modifyCaloriesButton = new JButton("Modify Calories");
        JButton collectPaymentsButton = new JButton("Collect/Replenish payments/money denominations");
        JButton displayItemsButton = new JButton("Display Items");
        JButton prevPageButton = new JButton("Previous Page");
        JButton cancelButton = new JButton("Cancel");

        // Add action listeners for each button as needed

        maintenancePanel.add(modifyCaloriesButton);
        maintenancePanel.add(collectPaymentsButton);
        maintenancePanel.add(displayItemsButton);
        maintenancePanel.add(prevPageButton);
        maintenancePanel.add(cancelButton);

        mainFrame.add(maintenancePanel);
        while (true) {
            Object[] options = {
                    "Modify Calories",
                    "Collect/Replenish payments/money denominations",
                    "Display Items",
                    "Previous Page",
                    "Cancel"
            };

            int choice = JOptionPane.showOptionDialog(
                    mainFrame,
                    "Maintenance Features:",
                    "Maintenance Features",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (choice) {
                case 0:
                    smodifyCalories();
                    break;
                case 1:
                    collectOrReplenishPayments(money);
                    break;
                case 2:
                    sdisplay();
                    break;
                case 3:
                    testMaintenanceFeatures1();
                    return;
                case 4:
                    JOptionPane.showMessageDialog(mainFrame, "Returning to the main menu.");
                    return;
                default:
                    JOptionPane.showMessageDialog(mainFrame, "Invalid choice. Please try again.");
                    break;
            }
        }
    }


    public void printSpecialMessage(ArrayList<Integer> selectedSlots) {
        boolean hasChicken = false;
        boolean hasBeef = false;
        boolean hasRice = false;
        boolean hasNoodle = false;

        for (int slotNumber : selectedSlots) {
            ItemSlot selectedSlot = specialvendingMachine.getSlots().get(slotNumber - 1);
            Item item = selectedSlot.getItem();
            if (item != null) {
                String itemName = item.getName().toLowerCase();
                if (itemName.equals("chicken")) {
                    hasChicken = true;
                } else if (itemName.equals("beef")) {
                    hasBeef = true;
                } else if (itemName.equals("rice")) {
                    hasRice = true;
                } else if (itemName.equals("noodle soup")) {
                    hasNoodle = true;
                }
            }
        }

        StringBuilder messageBuilder = new StringBuilder();

        if (hasChicken && hasRice) {
            messageBuilder.append("You bought Chicken Rice!\n");
        }

        if (hasBeef && hasRice) {
            messageBuilder.append("You bought Beef Rice!\n");
        }

        if (hasChicken && hasNoodle) {
            messageBuilder.append("You bought Chicken Noodle Soup!\n");
        }

        if (hasBeef && hasNoodle) {
            messageBuilder.append("You bought Beef Noodle Soup!\n");
        }

        // Display the special messages using a dialog
        if (messageBuilder.length() > 0) {
            showMessage(messageBuilder.toString());
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    //GETTERS SETTERS
    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }
    public SpecialVendingMachine getSpecialVendingMachine() {
        return specialvendingMachine;
    }
    public ArrayList<Integer> getSelectedSlots() {
        return selectedSlots;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

}
