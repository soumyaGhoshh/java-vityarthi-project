package bankmanagement.src;
import java.util.ArrayList;
import java.util.List;

public class BankAccount{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;
    private List<Transaction> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(new Transaction("INITIAL_DEPOSIT", initialBalance, balance));
    }

    // Getters
    public String getAccountNumber(){return accountNumber;}
    public String getAccountHolder(){return accountHolder;}
    public double getBalance(){return balance;}
    public String getAccountType(){return accountType;}
    public List<Transaction> getTransactionHistory(){return transactionHistory;}

    // Banking operations
    public boolean deposit(double amount){
        if(amount > 0){
            balance += amount;
            transactionHistory.add(new Transaction("DEPOSIT", amount, balance));
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
            return true;
        }
        System.out.println("Invalid deposit amount!");
        return false;
    }
    
    public boolean withdraw(double amount){
        if(amount> 0 && amount <= balance){
            balance -= amount;
            transactionHistory.add(new Transaction("WITHDRAWAL", -amount, balance));
            System.out.println("Withdrawn:" + amount + " | New Balance: " + balance);
            return true;
        }else if (amount > balance){
            System.out.println("Insufficient funds! Available: $" + balance);
        }else {
            System.out.println(" Invalid withdrawal amount!");
    }
       return false;
    }
    
    public boolean transfer(BankAccount recipient, double amount){
        if(amount > 0 && amount <= balance){
            this.balance -= amount;
            recipient.balance += amount;
            
            this.transactionHistory.add(new Transaction("TRANSFER_TO_" + recipient.getAccountNumber(), -amount, balance));
            recipient.transactionHistory.add(new Transaction("TRANSFER_FROM_" + this.accountNumber, amount, recipient.getBalance()));
            
            System.out.println(" Transferred: $" + amount + " to " + recipient.getAccountHolder());
            System.out.println(" Your new balance: $" + balance);
            return true;
        }
        System.out.println(" Transfer failed! Check amount and balance.");
        return false;
    }
    
    public void displayAccountInfo(){
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
        System.out.println("Total Transactions: " + transactionHistory.size());
    }

    public void displayTransactionHistory(){
        System.out.println("\n--- Transaction History for " + accountNumber + " ---");
        if(transactionHistory.isEmpty()){
            System.out.println("No transactions yet.");
        }else{
            for (Transaction transaction : transactionHistory){
                System.out.println(transaction);
            }
        }
    }
}