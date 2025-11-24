package bankmanagement.src;

import java.util.ArrayList;
import java.util.List;

public class Customer{
    private String name;
    private String customerId;
    private String email;
    private String phone;
    private List<BankAccount> accounts;

    public Customer(String customerId, String name, String email, String phone){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accounts = new ArrayList<>();

    }

    // getters
    public String getCustomerId(){return customerId;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}
    public List<BankAccount> getAccounts(){return accounts;}

    public void addAccount(BankAccount account){
        accounts.add(account);
        System.out.println("New account added: " + account.getAccountNumber());
    }
    public void displayCustomerInfo(){
        System.out.println("\n --- STUDENT INFO --- \n");
        System.out.println("Student ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println(" Total Accounts: " + accounts);
    }
    public void displayAllAccounts(){
        System.out.println(" --- ALL ACCOUNTS FOR " + name + " --- ");
        if(accounts.isEmpty()){
            System.out.println("No accounts found");
        }
        else{
            for(BankAccount account: accounts){
                account.displayAccountInfo();
            }
        }
    }
    public BankAccount findAccount(String accountNumber){
        for(BankAccount account: accounts){
            if (account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }


}
