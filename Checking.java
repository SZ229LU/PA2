/**
 * Class Checking to model the entity Checking Account
 * subclass of BankAccount
 * @author: Steven Zhang
 * @version: Java 11
 */
public class Checking extends BankAccount{

    /**
     * Constructor with 2 parameters
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     */
    public Checking(String owner, double balance){
        super(owner, balance);
    }

    /**
     * Constructor with 3 parameters
     * @param number the account number
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @throws BadFormatException exception if the super contructor (BankAccount) throws it
     */
    public Checking(long number, String owner, double balance) throws BadFormatException {
        super(number, owner, balance);
    }

    /**
     * toString method
     * @return a formatted string with all the atttributes of Checking
     */
    @Override
    public String toString(){
        return String.format("Checking\t%-10d\t%-30s\t$%-10.2f", getNumber(), getOwner(), getBalance());
    }

    /**
     * Method to return a formatted string for file output
     * @return a string representation of the bank account suitable CSV format for file storage
     */
    public String fileString(){
        return String.format("C,%d,%s,%f",getNumber(), getOwner(), getBalance());
    }
}