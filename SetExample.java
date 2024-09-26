package Day7;
import java.util.HashSet;
import java.util.Scanner;
public class SetExample {
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

        // Create a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();

        // Loop through the array and add each element to the HashSet
        for (int arr1 : arr) {
            set.add(arr1);  // Only unique elements will be added
        }

        // Print the set, which now contains only unique elements
        System.out.println("Unique elements in the array: " + set);

        // Print the size of the set (i.e., the number of unique elements)
        System.out.println("Number of unique elements: " + set.size());

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
