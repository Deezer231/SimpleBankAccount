import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleBankAccount {

    public Map<String, Double> accounts; // A map to store account numbers and their corresponding balances

    public SimpleBankAccount() { // Constructor to initialize the accounts map
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) { // Method to create a new account

        if (accounts.containsKey(accountNumber)) { // Checks if the account already exists
            System.out.println("Account already exists.");
        } else {
            accounts.put(accountNumber, 0.0); // // Creates new account with starting balance 0.0
            System.out.println("Account created successfully.");
        }
    }

    public void deposit(String accountNumber, double amount) { // Method for depsiting money in the account
        if (accounts.containsKey(accountNumber)) { // Get the current balance, add deposit amount, and update the
                                                   // balance
            double balance = accounts.get(accountNumber);
            balance += amount;
            accounts.put(accountNumber, balance); // Update the account with the new balance
            System.out.println("Deposit successful.");
            System.out.println("Your New Balance is:" + "$" + balance);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void withdraw(String accountNumber, double amount) { // Method to withdraw money from an account
        if (accounts.containsKey(accountNumber)) { // // Check if the account already exists
            double balance = accounts.get(accountNumber); // // Gets the current balance
            if (balance >= amount) { // Checks if balance >= amount to withdraw
                balance -= amount; // balance left has to be less than or equal to amount of money in the account
                accounts.put(accountNumber, balance);
                System.out.println("Withdrawal successful.");
                System.out.println("Your New Balance is: " + "$" + balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void checkBalance(String accountNumber) { // Checks money in account
        if (accounts.containsKey(accountNumber)) { // If account exists
            double balance = accounts.get(accountNumber); // Gets the balance
            System.out.println("Account Balance:" + "$" + balance);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public static void main(String[] args) {
        SimpleBankAccount bank = new SimpleBankAccount();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine()); // Change user input to an integer
                    if (choice < 1 || choice > 5) {
                        throw new NumberFormatException(); // Force loop if user inputted number out of range (1-5)
                    }
                    break; // Exit the User input was valid asffff
                } catch (NumberFormatException e) { // If user input is not 1-5
                    System.out.print("INVALID INPUT." + "\n" + "Please enter a number between 1 and 5: ");
                }
            }

            switch (choice) {
                case 1: // Create Account
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    bank.createAccount(accountNumber);
                    break;
                case 2: // Deposit Money In Bank Account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    try {
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        bank.deposit(accountNumber, depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a valid number.");
                    }
                    break;
                case 3: // Withdraw money from bank account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    try {
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        bank.withdraw(accountNumber, withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a valid number.");
                    }
                    break;
                case 4: // Check Bank Account Balance
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bank.checkBalance(accountNumber);
                    break;
                case 5: // Exit Bank Account Screen
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
