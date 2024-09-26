package DaySix;

import java.util.Scanner;

public class SelectionSort {

    // Function to sort the array using Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through the entire array
        for (int i = 0; i < n - 1; i++) {
            // Assume the minimum element is the first element in unsorted part
            int minIndex = i;

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update minIndex if smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the size of the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Create an array and take its input
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort the array using selection sort
        selectionSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
