package Day7;
import java.util.Scanner;
public class DuplicateElement{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array size from the user
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Creating an array of size n
        int[] arr = new int[n];
        
        // Taking array elements as input from the user
        System.out.println("Enter " + n + " sorted elements (with possible duplicates):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calling the function to remove duplicates
        int k = removeDuplicates(arr);

        // Printing the unique elements in the array
        System.out.println("The array after removing duplicate elements is:");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }

    // Function to remove duplicates from a sorted array
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;  // If array is empty, return 0

        int i = 0;  // Pointer to place unique elements
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {  // If we find a new unique element
                i++;                 // Move i to the next position
                arr[i] = arr[j];      // Copy the unique element to position i
            }
        }
        return i + 1;  // Return the number of unique elements (i + 1)
    }
}
