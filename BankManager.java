public class BankManager{
    public static void main(String[] args){

        // Creating a new empty Bank instance
        System.out.println("Test case 1: Creating an empty bank instance");
        Bank myBank = new Bank();
        System.out.println("There are " + myBank.size() + " accounts in the bank");
        
        // Adding accounts to the bank
        System.out.println("\nTest case 2: Creating a bank from a text file");
        myBank = new Bank("accounts.txt");
        System.out.println(myBank.size() + " accounts read from the file \"accounts.txt\"");
        System.out.println(myBank.toString());

        // Finding an account in the bank
        System.out.println("Test case 3: finding an account (success)");
        long number = 6163767899L;
        BankAccount found = myBank.find(number);
        if(found != null){
            System.out.println("Account found: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }

        // Withdrawing an acceptable amount from an account
        System.out.println("\nTest case 4: withdraw from account (success)");
        try{
            found.withdraw(100);
            System.out.println("Withdrawal completed successfully");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }
        catch(IllegalTransactionException e){
            System.out.println(e.getMessage());
        }

        // Withdrawing an amount above the balance
        System.out.println("\nTest case 5: withdraw from account (fail)");
        try{
            found.withdraw(300);
            System.out.println("Withdrawal completed successfully");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }
        catch(IllegalTransactionException e){
            System.out.println(e.getMessage());
        }

        // Deposit an amount in an account
        System.out.println("\nTest case 6: deposit money in an account");
        found.deposit(2000);
        System.out.println("Deposit completed successfully");
        System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));

         // Apply the monthly interest on a savings account
        System.out.println("\nTest case 7: Apply the monthly interest on a savings account");
        number = 2636761959L;
        found = myBank.find(number);
        if(found != null){
            System.out.println("Account found: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }
        double interest = ((Savings)found).applyMonthlyInterest();
        System.out.println("The amount " + String.format("$%.2f",interest) + " added to the account");
        System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));

        // apply profit on an investment account
        System.out.println("\nTest case 8: get the profit on an investment account");
        number = 4175493256L;
        found = myBank.find(number);
        if(found != null){
            System.out.println("Account found: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }
        double profitOrLoss = ((Investment)found).getProfitOrLoss(0.75);
        if(profitOrLoss > 0){
            System.out.println("Profit: the amount " + String.format("$%.2f", profitOrLoss) + " was added to the account");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }
        else{
            System.out.println("Loss: the amount " + String.format("$%.2f", -profitOrLoss) + " was deducted from the account");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }

        // apply loss on an investment account
        System.out.println("\nTest case 9: get the loss on an investment account");
        profitOrLoss = ((Investment)found).getProfitOrLoss(0.25);
        if(profitOrLoss > 0){
            System.out.println("Profit: the amount " + String.format("$%.2f", profitOrLoss) + " was added to the account");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }
        else{
            System.out.println("Loss: the amount " + String.format("$%.2f", -profitOrLoss) + " was deducted from the account");
            System.out.println("New balance: " + String.format("$%.2f",found.getBalance()));
        }

        // Finding an account that is not in the bank
        System.out.println("\nTest case 10: finding an account (fail)");
        number = 999999999L;
        found = myBank.find(number);
        if(found != null){
            System.out.println("Account found: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }

        // Removing an existent account
        System.out.println("\nTest case 11: removing an account (success)");
        number = 9191317817L;
        found = myBank.remove(number);
        if(found != null){
            System.out.println("Account found and removed: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }

        // Removing an account that is not in the bank
        System.out.println("\nTest case 12: removing an account (fail)");
        number = 999999999L;
        found = myBank.remove(number);
        if(found != null){
            System.out.println("Account found: " + found.toString());
        }
        else{
            System.out.println("Account number " + number + " not found.");
        }
        
        // View the list of the accounts after the updates
        System.out.println("\nTest case 13: viewing the list of accounts");
        System.out.println("There are " + myBank.size() + " accounts in the bank");
        System.out.println(myBank.toString());

        // Sorting the bank accounts by balance
        System.out.println("Test case 14: sorting the bank accounts by balance");
        myBank.sort();
        System.out.println(myBank.toString());

        // Save the list of the accounts after the updates to a file
        System.out.println("\nTest case 15: Saving the list of accounts to the file \"accounts.txt\"");
        myBank.save("accounts.txt");
        System.out.println(myBank.size() + " accounts saved to the file \"accounts.txt\"");

        // Check if the file contains the updated list of accounts
        System.out.println("\nTest case 16: Reading the accounts from the updated file \"accounts.txt\"");
        myBank = new Bank("accounts.txt");
        System.out.println(myBank.size() + " accounts read from the file \"accounts.txt\"");
        System.out.println(myBank.toString());

        
    }
}
