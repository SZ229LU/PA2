/**
 * Class Savings to model the entity Savings Account
 * subclass of BankAccount
 * @author: Steven Zhang
 * @version: Java 11
 */
public class Savings extends BankAccount {
    private double YearlyInterestRate;

    /**
     * Constructor with 3 parameters
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @param yInterestRate the yearly interest rate for the savings account
    */
    public Savings(String owner, double balance, double yInterestRate) {
        super(owner, balance);
        YearlyInterestRate = yInterestRate;
    }

    /**
     * Constructor with 4 parameters
     * @param number the account number
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @param yInterestRate the yearly interest rate for the savings account
     * @throws BadFormatException exception if the super contructor (BankAccount) throws it
     */
    public Savings(long number, String owner, double balance, double yInterestRate) throws BadFormatException {
        super(number, owner, balance);
        YearlyInterestRate = yInterestRate;
    }

    /**
     * Getter for the yearly interest rate
     * @return the value of the yearly interest rate
    */
    public double getYearlyInterestRate() {
        return YearlyInterestRate;
    }

    /**
     * Method that adds Monthly Interest to the account
     * @return the value of the monthly interest
    */
    public double applyMonthlyInterest() {
        double x = (((YearlyInterestRate/12)/100)*balance);
        super.deposit(x);
        return x;
    }

    /**
     * Setter for the yearly interest rate
     * @param y the new yearly interest rate
    */
    public void setYearlyInterestRate(double y) {
        YearlyInterestRate = y;
    }

    /**
     * toString method for the Savings class
     * @return a string representation of the savings account
    */
    @Override
    public String toString() {
        return String.format("Savings \t%-10d\t%-30s\t$%-10.2f\t%-10.2f",
                         getNumber(), getOwner(), getBalance(), YearlyInterestRate);
    }

    /**
     * Method to return a formatted string for file output
     * @return a string representation of the bank account suitable CSV format for file storage
     */
    public String fileString(){
        return String.format("%s,%d,%s,%f,%f","Savings",getNumber(), getOwner(), getBalance(), YearlyInterestRate);
    }

}