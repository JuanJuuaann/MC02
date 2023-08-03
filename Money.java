/**
 * the Money class represents a collection of different denominations of currency that you would find or use for a vending machine.
 * It allows counting and manipulation of different bill and coin denominations for a vending machine.
 */
public class Money {
    private int oneDollarBillCount;
    private int fiveDollarBillCount;
    private int tenDollarBillCount;
    private int quarterCount;
    private int dimeCount;
    private int nickelCount;
    private int pennyCount;

    /**
     * Constructs a new Money object with the specified counts of different denominations.
     *
     * @param oneDollarBillCount    The count of one dollar bills.
     * @param fiveDollarBillCount   The count of five dollar bills.
     * @param tenDollarBillCount    The count of ten dollar bills.
     * @param quarterCount          The count of quarters.
     * @param dimeCount             The count of dimes.
     * @param nickelCount           The count of nickels.
     * @param pennyCount            The count of pennies.
     */
    public Money(int oneDollarBillCount, int fiveDollarBillCount, int tenDollarBillCount, int quarterCount, int dimeCount, int nickelCount, int pennyCount) {
        this.oneDollarBillCount = oneDollarBillCount;
        this.fiveDollarBillCount = fiveDollarBillCount;
        this.tenDollarBillCount = tenDollarBillCount;
        this.quarterCount = quarterCount;
        this.dimeCount = dimeCount;
        this.nickelCount = nickelCount;
        this.pennyCount = pennyCount;
    }

    /**
     * Returns the count of one dollar bills.
     *
     * @return The count of one dollar bills.
     */
    public int getOneDollarBillCount() {
        return oneDollarBillCount;
    }

    /**
     * Adds the specified count of one dollar bills to the current count.
     *
     * @param count The count of one dollar bills to add.
     */
    public void addOneDollarBills(int count) {
        this.oneDollarBillCount += count;
    }

    /**
     * Returns the count of five dollar bills.
     *
     * @return The count of five dollar bills.
     */
    public int getFiveDollarBillCount() {
        return fiveDollarBillCount;
    }

    /**
     * Adds the specified count of five dollar bills to the current count.
     *
     * @param count The count of five dollar bills to add.
     */
    public void addFiveDollarBills(int count) {
        this.fiveDollarBillCount += count;
    }

    /**
     * Returns the count of ten dollar bills.
     *
     * @return The count of ten dollar bills.
     */
    public int getTenDollarBillCount() {
        return tenDollarBillCount;
    }

    /**
     * Adds the specified count of ten dollar bills to the current count.
     *
     * @param count The count of ten dollar bills to add.
     */
    public void addTenDollarBills(int count) {
        this.tenDollarBillCount += count;
    }

    /**
     * Returns the count of quarters.
     *
     * @return The count of quarters.
     */
    public int getQuarterCount() {
        return quarterCount;
    }

    /**
     * Adds the specified count of quarters to the current count.
     *
     * @param count The count of quarters to add.
     */
    public void addQuarters(int count) {
        this.quarterCount += count;
    }

    /**
     * Returns the count of dimes.
     *
     * @return The count of dimes.
     */
    public int getDimeCount() {
        return dimeCount;
    }

    /**
     * Adds the specified count of dimes to the current count.
     *
     * @param count The count of dimes to add.
     */
    public void addDimes(int count) {
        this.dimeCount += count;
    }

    /**
     * Returns the count of nickels.
     *
     * @return The count of nickels.
     */
    public int getNickelCount() {
        return nickelCount;
    }

    /**
     * Adds the specified count of nickels to the current count.
     *
     * @param count The count of nickels to add.
     */
    public void addNickels(int count) {
        this.nickelCount += count;
    }

    /**
     * Returns the count of pennies.
     *
     * @return The count of pennies.
     */
    public int getPennyCount() {
        return pennyCount;
    }

    /**
     * Adds the specified count of pennies to the current count.
     *
     * @param count The count of pennies to add.
     */
    public void addPennies(int count) {
        this.pennyCount += count;
    }

    /**
     * Calculates and returns the total amount of money represented by the counts of different denominations.
     *
     * @return The total amount of money.
     */
    public int getTotalAmount() {
        int totalAmount = oneDollarBillCount +
                fiveDollarBillCount * 5 +
                tenDollarBillCount * 10 +
                quarterCount * 25 +
                dimeCount * 10 +
                nickelCount * 5 +
                pennyCount;

        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        // Convert total amount from dollars to cents
        int totalAmountCents = (int) (totalAmount * 100);

        // Calculate the counts of different denominations based on the total amount in cents
        tenDollarBillCount = totalAmountCents / 1000;
        totalAmountCents %= 1000;

        fiveDollarBillCount = totalAmountCents / 500;
        totalAmountCents %= 500;

        oneDollarBillCount = totalAmountCents / 100;
        totalAmountCents %= 100;

        quarterCount = totalAmountCents / 25;
        totalAmountCents %= 25;

        dimeCount = totalAmountCents / 10;
        totalAmountCents %= 10;

        nickelCount = totalAmountCents / 5;
        pennyCount = totalAmountCents % 5;
    }

    /**
     * Resets the counts of all denominations to zero.
     */
    public void reset() {
        oneDollarBillCount = 0;
        fiveDollarBillCount = 0;
        tenDollarBillCount = 0;
        quarterCount = 0;
        dimeCount = 0;
        nickelCount = 0;
        pennyCount = 0;
    }
}
