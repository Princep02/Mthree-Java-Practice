package firstday;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Greeting the user
        System.out.println("Welcome to the Calculator App!");
        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hi, " + userName + "! Let's do some calculations.");

        // Calculator functionality
        System.out.print("Enter the first number: ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double secondNumber = scanner.nextDouble();
        System.out.print("Enter the operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double calculationResult = 0;
        boolean validOperation = true;

        switch (operator) {
            case '+':
                calculationResult = firstNumber + secondNumber;
                break;
            case '-':
                calculationResult = firstNumber - secondNumber;
                break;
            case '*':
                calculationResult = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0) {
                    calculationResult = firstNumber / secondNumber;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                validOperation = false;
                break;
        }

        if (validOperation) {
            System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is: " + calculationResult);
        }

        scanner.close();
    }
}
