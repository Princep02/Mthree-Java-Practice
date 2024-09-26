package Day7;
import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[size];

        // Ask the user to input the array elements
        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find the second largest element
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (arr[i] > largest) {
                secondLargest = largest; // Update second largest
                largest = arr[i];        // Update largest
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];  // Update second largest
            }
        }

        // Check if the second largest element exists
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
