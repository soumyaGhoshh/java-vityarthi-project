package bankmanagement.src;

import java.util.ArrayList;
import java.util.List;

public class Bank{
    private String bankName;
    private List<Customer> customers;
    private List<BankAccount> allAccounts;
    
    public Bank(String bankName){
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.allAccounts = new ArrayList<>();
        initializeSampleData();
    }
    
    private void initializeSampleData(){
        // Create sample customers
        Customer customer1 = new Customer("C001", "Soumya Ghosh", "soumya001@email.com", "9845678909");
        Customer customer2 = new Customer("C002", "Soumi Banerjee", "soumi001@email.com", "9345673443");
        
        // Create sample accounts
        BankAccount acc1 = new BankAccount("ACC001", "Soumya Ghosh", 1000.0, "SAVINGS");
        BankAccount acc2 = new BankAccount("ACC002", "Soumi Banjerjee", 2500.0, "CURRENT");
        BankAccount acc3 = new BankAccount("ACC003", "Soumya Ghosh", 500.0, "SALARY");
        
         //customer linked accounts
        customer1.addAccount(acc1);
        customer1.addAccount(acc3);
        customer2.addAccount(acc2);
        
        //Add to bank records 
        customers.add(customer1);
        customers.add(customer2);
        allAccounts.add(acc1);
        allAccounts.add(acc2);
        allAccounts.add(acc3);
    }
    

    public void addCustomer(String customerId, String name, String email,String phone) {
        Customer customer = new Customer(customerId, name, email, phone);
        customers.add(customer);
        System.out.println("New student added: " + name);
    }
    
    public BankAccount openAccount(String customerId, String accountNumber, double initialDeposit, String accountType) {
        Customer customer = findCustomer(customerId);
        if(customer != null){
            BankAccount newAccount = new BankAccount(accountNumber, customer.getName(), initialDeposit, accountType);
            customer.addAccount(newAccount);
            allAccounts.add(newAccount);
            return newAccount;
        }
        System.out.println("Student not found!");
        return null;
    }
    
    public Customer findCustomer(String customerId){
        for(Customer customer : customers){
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public BankAccount findAccount(String accountNumber){
        for(BankAccount account : allAccounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
          }
        }
        return null;
    }
    

    public void displayAllCustomers(){
        System.out.println("\n--- All Students of " + bankName + " ---");
        for(Customer customer : customers){
            customer.displayCustomerInfo();
       }
    }
    
    public void displayAllAccounts(){
        System.out.println("\n--- All Accounts in " + bankName + " ---");
        for(BankAccount account : allAccounts){
            account.displayAccountInfo();
      }
    }
    
    public void displayBankSummary(){
        System.out.println("\n---" + bankName + " BANK SUMMARY ---");
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Accounts: " + allAccounts.size());
        
        double totalDeposits= 0;
        for(BankAccount account : allAccounts){
            totalDeposits += account.getBalance();
       }
        System.out.println("Total Bank Deposits: ₹" + totalDeposits);
    }
    public String toString(){
        return bankName;
    }
}