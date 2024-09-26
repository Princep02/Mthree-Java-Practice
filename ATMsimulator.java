
import java.util.Random;
import java.util.Scanner;

public class ATMsimulator {
    private static final int PIN = 1234; // Simulated correct PIN
    private static final int MAX_ATTEMPTS = 3;
    private static double balance = 1000.00; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the ATM Simulator");

        // PIN verification using do-while loop
        int attempts = 0;
        boolean pinVerified = false;
        do {
            System.out.print("Please enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                pinVerified = true;
                System.out.println("PIN accepted. Access granted.");
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
            }
        } while (!pinVerified && attempts < MAX_ATTEMPTS);

        if (!pinVerified) {
            System.out.println("Too many incorrect attempts. Your card has been blocked.");
            return;
        }

        // Main ATM menu using do-while loop
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: $%.2f\n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("$%.2f withdrawn. New balance: $%.2f\n", withdrawAmount, balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.printf("$%.2f deposited. New balance: $%.2f\n", depositAmount, balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Simulate processing time
            try {
                Thread.sleep(random.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (choice != 4);

        scanner.close();
    }
} 
