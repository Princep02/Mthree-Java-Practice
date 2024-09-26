import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaControlStatements {

    public static void main(String[] args) {
        // 1. Conditional Statements
        executeConditionalStatements();

        // 2. Looping Statements
        executeLoopingStatements();

        // 3. Jump Statements
        executeJumpStatements();

        // 4. Exception Handling
        handleExceptions();

        // 5. Assertions
        checkAssertions();
    }

    // 1. Conditional Statements
    private static void executeConditionalStatements() {
        System.out.println("\n--- Conditional Statements ---");

        // 1.1 if statement
        int voterAge = 20;
        if (voterAge >= 18) {
            System.out.println("You are eligible to vote.");
        }

        // 1.2 if-else statement
        int examScore = 55;
        if (examScore >= 60) {
            System.out.println("You passed!");
        } else {
            System.out.println("You failed.");
        }

        // 1.3 if-else-if ladder
        int studentGrade = 75;
        if (studentGrade >= 90) {
            System.out.println("Grade: A");
        } else if (studentGrade >= 80) {
            System.out.println("Grade: B");
        } else if (studentGrade >= 70) {
            System.out.println("Grade: C");
        } else if (studentGrade >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        // 1.4 Nested if statements
        boolean hasDriverLicense = true;
        if (voterAge >= 18) {
            if (hasDriverLicense) {
                System.out.println("You can drive.");
            } else {
                System.out.println("You need to get a license first.");
            }
        } else {
            System.out.println("You are too young to drive.");
        }

        // 1.5 switch statement
        int currentDay = 5;
        switch (currentDay) {
            case 1:
                System.out.println("Day: Monday");
                break;
            case 2:
                System.out.println("Day: Tuesday");
                break;
            case 3:
                System.out.println("Day: Wednesday");
                break;
            case 4:
                System.out.println("Day: Thursday");
                break;
            case 5:
                System.out.println("Day: Friday");
                break;
            case 6:
            case 7:
                System.out.println("Day: Weekend");
                break;
            default:
                System.out.println("Invalid day");
        }
    }

    // 2. Looping Statements
    private static void executeLoopingStatements() {
        System.out.println("\n--- Looping Statements ---");

        // 2.1 for loop
        System.out.println("For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // 2.2 Enhanced for loop (for-each)
        System.out.println("\nEnhanced for loop:");
        int[] numbersArray = {1, 2, 3, 4, 5};
        for (int number : numbersArray) {
            System.out.println("Number: " + number);
        }

        // 2.3 while loop
        System.out.println("\nWhile loop:");
        int counter = 0;
        while (counter < 5) {
            System.out.println("Count: " + counter);
            counter++;
        }

        // 2.4 do-while loop
        System.out.println("\nDo-while loop:");
        int counterNum = 1;
        do {
            System.out.println("Counter: " + counterNum);
            counterNum++;
        } while (counterNum <= 5);
    }

    // 3. Jump Statements
    private static void executeJumpStatements() {
        System.out.println("\n--- Jump Statements ---");

        // 3.1 break statement
        System.out.println("Break statement:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break;
            }
            System.out.println("Iteration: " + i);
        }

        // 3.2 continue statement
        System.out.println("\nContinue statement:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Iteration: " + i);
        }

        // 3.3 return statement
        System.out.println("\nReturn statement:");
        System.out.println("Sum: " + calculateSum(8, 12));
    }

    private static int calculateSum(int num1, int num2) {
        return num1 + num2;
    }

    // 4. Exception Handling
    private static void handleExceptions() {
        System.out.println("\n--- Exception Handling ---");

        // 4.1 try-catch
        System.out.println("Try-catch:");
        try {
            int result = 20 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero - " + e.getMessage());
        }

        // 4.2 try-catch-finally
        System.out.println("\nTry-catch-finally:");
        try {
            int[] dataArray = {10, 20, 30};
            System.out.println(dataArray[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes.");
        }

        // 4.3 try-with-resources
        System.out.println("\nTry-with-resources:");
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String lineContent;
            while ((lineContent = br.readLine()) != null) {
                System.out.println(lineContent);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 5. Assertions
    private static void checkAssertions() {
        System.out.println("\n--- Assertions ---");
        int testAge = -3;
        assert testAge >= 0 : "Age cannot be negative";
        System.out.println("Age: " + testAge);
    }
}
