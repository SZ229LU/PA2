/**
 * Class Investment to model the entity Investment Account
 * subclass of BankAccount
 * @author: Steven Zhang
 * @version: Java 11
 */
public class Investment extends BankAccount{
    private String type;

    /**
     * Constructor with 3 parameters
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @param type the type of investment (“Property”, ”Growth”, and ”Shares”)
     */
    public Investment(String owner, double balance, String type) throws BadFormatException {
        super(owner, balance);
        if(type == null || !(type.equals("Property") || type.equals("Growth") || type.equals("Shares"))) {
            throw new BadFormatException("Invalid investment type.");
        }
        this.type = type;
    }

    /**
     * Constructor with 4 parameters
     * @param number the account number
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @param type the type of investment (“Property”, ”Growth”, and ”Shares”)
     * @throws BadFormatException if the super contructor (BankAccount) throws it or if the type is not one of the valid options (“Property”, ”Growth”, and ”Shares”)
     */
    public Investment(long number, String owner, double balance, String type) throws BadFormatException {
        super(number, owner, balance);
        if(type == null || !(type.equals("Property") || type.equals("Growth") || type.equals("Shares"))) {
            throw new BadFormatException("Bad Investment type: \"" + type + "\", should be [Property|Growth|Shares]");
        }
        this.type = type;
    }

    /**
     * Getter for the investment type
     * @return the type of investment
     */
    public String getType(){
        return type;
    }

    /**
     * Setter for the investment type
     * @param type the new type of investment
     * @throws BadFormatException if the type is not one of the valid options (“Property”, ”Growth”, and ”Shares”)
     */
    public void setType(String type) throws BadFormatException {
        if(type == null || !(type.equals("Property") || type.equals("Growth") || type.equals("Shares"))) {
            throw new BadFormatException("Bad Investment type: " + type + ", should be [Property|Growth|Shares]");
        }
        this.type = type;
    }

    /**
     * Method to calculate profit or loss based on risk,
     * Adds 5% of the balance if value of risk is greater than or equal to 0.5
     * Deducts 2% of the balance if value of risk is less than 0.5
     * @param risk the risk factor
     * @return the profit or loss amount
     */
    public double getProfitOrLoss(double risk){
        double pol = 0;
        if(risk >= 0.5){
            pol = balance * .05;
            balance += pol;
        } else {
            pol = -1 * (balance * .02);
            balance += pol;
        }
        return pol;
    }

    /**
     * toString method for the Investment class
     * @return a string representation of the investment account
     */
    @Override
    public String toString() {
        return String.format("Investment \t%-10d\t%-30s\t$%-10.2f\t%-10s",
                         getNumber(), getOwner(), getBalance(), type);
    }

    /**
     * Method to return a formatted string for file output
     * @return a string representation of the bank account suitable CSV format for file storage
     */
    public String fileString(){
        return String.format("%s,%d,%s,%f,%s","Investment",getNumber(), getOwner(), getBalance(), type);
    }
}