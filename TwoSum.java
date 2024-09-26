package DaySix;

import java.util.HashMap;
import java.util.Scanner;

class TwoSum{

    // Function to find two indices that sum up to the target
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the indices of the elements
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (target - current number)
            int complement = target - nums[i];

            // If the complement exists in the map, return the pair of indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the number and its index in the map
            map.put(nums[i], i);
        }

        // If no solution is found, throw an exception (this won't happen in valid inputs)
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the array size
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Create an array and take its input
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Take the target sum as input
        System.out.println("Enter the target sum:");
        int target = scanner.nextInt();

        // Create an instance of the solution class
        TwoSum solution = new TwoSum();

        // Find and print the result
        try {
            int[] result = solution.twoSum(nums, target);
            System.out.println("The two indices that sum up to the target are: " + result[0] + " and " + result[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
