import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Abstract class BankAccount to model the entity BankAccount
 * @author: Steven Zhang
 * @version: Java 11
 */
public abstract class BankAccount {
    //Data members
    private long number;
    private String owner;
    protected double balance;
    private static long nextNumber = 1111111110;

    /**
     * Constructor with 2 parameters
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
    */
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.number = ++nextNumber;
    }
    /** Constructor with 3 parameters
     * @param number the account number
     * @param owner the name of the account owner
     * @param balance the initial balance of the account
     * @throws BadFormatException if the account number is not exactly 10 digits
    */
    public BankAccount(long number, String owner, double balance) throws BadFormatException {
        if(!String.valueOf(number).matches("\\d{10}")) {
            throw new BadFormatException("Invalid account number ( " + number + " ), must have 10 digits");
        }
        this.owner = owner;
        this.balance = balance;
        this.number = number;
    }

    /**Accessor for account number
     * @return the account number
     */
    public long getNumber() {
        return number;
    }

    /** Accessor for account owner
     * @return the account owner
     */
    public String getOwner() {
        return owner;
    }

    /** Accessor for account balance
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /** 
     * Mutator for the account number
     * @param n the new account number
     */
    public void setNumber(long n){
        number = n;
    }

    /**
     * Mutator for the account owner
     * @param o the new account owner
     */
    public void setOwner(String o) {
        owner = o;
    }

    /**
     * Method to deposit money into the account
     * @param amount the amount to deposit
     */
    public void deposit(double amount){
        balance += amount;
    }

    /**
     * Method to withdraw money from the account
     * @param amount the amount to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    public boolean withdraw(double amount) throws IllegalTransactionException {
        if(amount >= balance) {
            throw new IllegalTransactionException("Withdrawal failed. Not enough credit in the account.");
        }
        balance -= amount;
        return true;
    }

    /**
     * toString method for the BankAccount class
     * @return a string representation of the bank account and its information
     */
    public String toString(){
        return String.format("%-10d\t%-30s\t$%-10.2f", number, owner, balance);
    }
    /**
     * Method to return a formatted string for file output
     * @return a string representation of the bank account suitable CSV format for file storage
     */
    public String fileString(){
        return String.format("%d,%s,%f",number, owner, balance);
    }
}
