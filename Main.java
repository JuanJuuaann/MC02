import java.util.Scanner;

/**
 * The Main class is where the Vending Machine Management System starts. It is also where it is ran.
 * It provides a text console interface to create and test vending machines.
 */
public class Main {
    /**
     * The main method is the starting point of the program.
     * It displays the menu options and processes user input until the program is exited.
     *
     * @param args The command line arguments passed to the program.
     */
    public static void main(String[] args) {

        Money money = new Money(0,0,0,0,0,0,0);
        MainView mainView = new MainView(money); //GUI

        VendingMachine vendingMachine = null;
        SpecialVendingMachine  specialvendingMachine = null;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("oO--O--Oo");
        System.out.println("Welcome to the Vending Machine Management System!");
        System.out.println("oO--O--Oo");

        while (choice != 3) {
            scanner.nextLine();
            System.out.println("Menu:");
            System.out.println("1. Create a regular Vending Machine");
            System.out.println("2. Create a special Vending Machine");
            System.out.println("3. Test a Vending Machine");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Vending Machine created.");
                    mainView.createVendingMachine(); // Create a vending using GUI
                    vendingMachine = mainView.getVendingMachine();
                    if (vendingMachine != null) {
                        vendingMachine.listofitems(); // Call listofitems() after creating the vending machine
                    }
                    break;
                case 2:
                    System.out.println("Special Vending Machine created.");
                    mainView.createVendingMachine(); // Create a vending using GUI
                    specialvendingMachine = mainView.getSpecialVendingMachine();
                    break;    
                case 3:
                    if (vendingMachine != null && specialvendingMachine == null) {
                        vendingMachine.testVendingMachine();
                    } 
                    else if(specialvendingMachine != null && vendingMachine == null)
                    {
                        specialvendingMachine.testVendingMachine();
                    }
                    else {
                        System.out.println("Vending Machine not created yet. Please create one first.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Thank you for using Cravey Vendy");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

}

