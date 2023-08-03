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

        Money money = new Money(0, 0, 0, 0, 0, 0, 0);
        MainView mainView = new MainView(money); //GUI

        VendingMachine vendingMachine = null;
        SpecialVendingMachine specialvendingMachine = null;
        Scanner scanner = new Scanner(System.in);
    }

}

