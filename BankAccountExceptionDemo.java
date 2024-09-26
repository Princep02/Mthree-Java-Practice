import java.util.Scanner;

// Custom checked exception
class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds. You need " + amount + " more to complete this transaction.");
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Custom unchecked exception
class InvalidAccountException extends RuntimeException {
    private String accountId;
    
    public InvalidAccountException(String accountId) {
        super("Invalid account ID: " + accountId);
        this.accountId = accountId;
    }
    
    public String getAccountId() {
        return accountId;
    }
}

// Main class demonstrating exception handling
public class BankAccountExceptionDemo {
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                // Demonstrate handling multiple types of exceptions
                System.out.print("Enter account ID: ");
                String accountId = scanner.nextLine();
                System.out.print("Enter amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                
                // This may throw InvalidAccountException or InsufficientFundsException
                account.withdraw(accountId, amount);
                
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                break;
            } catch (InsufficientFundsException e) {
                // Handle the custom checked exception
                System.out.println("Error: " + e.getMessage());
                System.out.println("You need $" + e.getAmount() + " more. Would you like to try again? (y/n)");
                if (!scanner.nextLine().equalsIgnoreCase("y")) {
                    break;
                }
            } catch (InvalidAccountException e) {
                // Handle the custom unchecked exception
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with a valid account ID.");
            } catch (NumberFormatException e) {
                // Handle invalid input for withdrawal amount
                System.out.println("Error: Invalid amount entered. Please enter a valid number.");
            } catch (Exception e) {
                // Generic exception handler for any unexpected exceptions
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
                break;
            } finally {
                // This block always executes, regardless of whether an exception occurred
                System.out.println("Transaction attempt completed.");
            }
        }
        
        scanner.close();
    }
}

// Bank account class with methods that may throw exceptions
class BankAccount {
    private String accountId;
    private double balance;
    
    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // This method demonstrates throwing both custom checked and unchecked exceptions
    public void withdraw(String accountId, double amount) throws InsufficientFundsException {
        // Validate account ID (may throw unchecked exception)
        if (!this.accountId.equals(accountId)) {
            throw new InvalidAccountException(accountId);
        }
        
        // Check for sufficient funds (may throw checked exception)
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException(shortfall);
        }
        
        // Perform withdrawal if all checks pass
        balance -= amount;
    }
}