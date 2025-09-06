import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Bank{
    private BankAccount[] accounts;
    private int count;

    /**
     * Default constructor that creates the array accounts with a length 50, and sets count to 0.
     */
    public Bank(){
        accounts = new BankAccount[50];
        count = 0;
    }

    public Bank(String filename) {
        accounts = new BankAccount[50];
        count = 0;
        read(filename);
    }

    /**
     * Method to get the number of accounts in the bank.
     * @return the number of accounts in the bank
     */
    public int size(){
        return count;
    }

    /**
     * Adds a BankAccount to the bank.
     * Increments the count of accounts.
     * @param ba the BankAccount to add
     */
    public void add(BankAccount ba){
        accounts[count] = ba;
        count++;
    }

    /**
     * Finds a BankAccount by its account number.
     * @param number the account number to search for
     * @return the BankAccount with the specified account number, or null if not found
     */
    public BankAccount find(long number){
        for(int i = 0; i < count; i++){
            if(accounts[i].getNumber() == number){
                return accounts[i];
            }
        }
        return null;
    }

    /**
     * Removes a BankAccount by its account number.
     * Shifts all subsequent accounts down to remove and fill the gaps
     * Decrements the count of accounts if removal is successful
     * @param number the account number of the BankAccount to remove
     * @return the removed BankAccount, or null if not found
     */ 
    public BankAccount remove(long number){
        for(int i = 0; i < count; i++){
            if(accounts[i].getNumber() == number){
                BankAccount removed = accounts[i];
                for(int j = i; j < count - 1; j++){
                    accounts[j] = accounts[j + 1];
                }
                accounts[count - 1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }

    /**
     * Sorts an array of BankAccounts by balance using insertion sort.
     * @param list the array of BankAccounts to sort
     */
    public void sort() {
        for (int i = 1; i < count; i++) {

        BankAccount currentVal = accounts[i];
        int j = i;
    
        while (j > 0 && currentVal.getBalance() < accounts[j - 1].getBalance() ) {
            accounts[j] = accounts[j - 1];
            j--;
        }
        accounts[j] = currentVal;
        }
    }

    /**
     * Returns a string representation of each bank account in arrays accounts.
     * @return a string containing the all account information
     */
    public String toString(){
        String Banklogs = "";
        Banklogs += String.format("%-10s\t%-10s\t%-30s\t%-10s\t%-10s\n", "Type", "Number", "Owner", "Balance", "Interest/Type");
        for(int i=0; i<accounts.length; i++){
            if(accounts[i] != null){
                Banklogs += accounts[i].toString() + "\n";
            }
        }
        return Banklogs;
    }

    private void read(String filename) {
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                try {
                    String[] categories = line.split(",");
                    String acctype = categories[0];
                    long number = Long.parseLong(categories[1]);
                    String owner = categories[2];
                    double balance = Double.parseDouble(categories[3]);
                    switch (acctype) {
                        case "Checking":
                            Checking checking = new Checking(number, owner, balance);
                            accounts.add(checking);
                            break;
                        case "Savings":
                            double yInterestRate = Double.parseDouble(categories[4]);
                            Savings savings = new Savings(number, owner, balance, yInterestRate);
                            accounts.add(savings);
                            break;
                        case "Investment":
                            String type = categories[4];
                            Investment investment = new Investment(number, owner, balance, type);
                            accounts.add(investment);
                            break;
                        default:
                            throw new BadFormatException("Invalid account type");
                    }
                }
                catch (Exception e){
                    System.out.println("Error reading line: " + line);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    
}