package bankmanagement.src;

import java.util.Scanner;

public class BankApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("VIT Bhopal Student Bank");

        System.out.println("Welcome to " + bank + " Management System!");
        
        while(true){
            displayMainMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // a line consuming 
            
            switch(choice){
                case 1:
                    bank.displayBankSummary();
                    break;
                case 2:
                    bank.displayAllCustomers();
                    break;
                case 3:
                    bank.displayAllAccounts();
                    break;
                case 4:
                    handleCustomerOperations(scanner, bank);
                    break;
                case 5:
                    handleAccountOperations(scanner, bank);
                    break;
                case 6:
                    handleTransactions(scanner, bank);
                    break;
                case 7:
                    addNewCustomer(scanner, bank);
                    break;
                case 8:
                    openNewAccount(scanner, bank);
                    break;
                case 9:
                    System.out.println("Thank you for banking with us!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! please try again.");
            }
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. View Bank Summary");
        System.out.println("2. View All Students");
        System.out.println("3. View All Accounts");
        System.out.println("4. Student Operations");
        System.out.println("5. Account Operations");
        System.out.println("6. Transactions");
        System.out.println("7. Add New Student");
        System.out.println("8. Open New Account");
        System.out.println("9. Exit");
    }
    
    private static void handleCustomerOperations(Scanner scanner, Bank bank){
        System.out.print("Enter Student ID: ");
        String customerId = scanner.nextLine();
        Customer customer = bank.findCustomer(customerId);
        if (customer != null) {
            customer.displayCustomerInfo();
            customer.displayAllAccounts();
        } else {
            System.out.println("Student not found!");
        }
    }
    
    private static void handleAccountOperations(Scanner scanner, Bank bank){
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        BankAccount account = bank.findAccount(accNumber);
        
        if(account != null){
            account.displayAccountInfo();
            System.out.println("\n1. View Transaction History");
            System.out.println("2. Back to Main Menu");
            System.out.print("Choose: ");
            int subChoice = scanner.nextInt();
            scanner.nextLine();
            
            if(subChoice == 1){
                account.displayTransactionHistory();
            }
        } else {
            System.out.println("Account not found!");
      }
    }
    
    private static void handleTransactions(Scanner scanner, Bank bank){
        System.out.println("\n --- TRANSACTION MENU ---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        BankAccount account = bank.findAccount(accNumber);
        
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        
        switch (choice) {
            case 1:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter recipient account number: ");
                String recipientAcc = scanner.nextLine();
                BankAccount recipient = bank.findAccount(recipientAcc);
                if (recipient != null) {
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(recipient, transferAmount);
                } else {
                    System.out.println("Recipient account is not found!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
       }
    }
    
    private static void addNewCustomer(Scanner scanner, Bank bank){
        System.out.print("Enter Student ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        bank.addCustomer(customerId, name, email, phone);
    }
    
    private static void openNewAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter Student ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter New Account Number: ");
        String accNumber = scanner.nextLine();
        System.out.print("Enter Initial Deposit: $");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Account Type (SAVINGS/CURRENT/SALARY): ");
        String accType = scanner.nextLine();
        
        bank.openAccount(customerId, accNumber, initialDeposit, accType);
    }
}