package DaySix;

import java.util.Arrays;
import java.util.Scanner;

class maxsubarray{

    // Function to find the maximum sum subarray
    public int maxSubArray(int[] nums) {
        // dp[i] := the maximum sum subarray ending at index i
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // Returning the maximum value in the dp array, which is the result
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input from the user
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Creating an instance of Solution class to call the maxSubArray method
        maxsubarray solution = new maxsubarray();
        int result = solution.maxSubArray(nums);

        // Displaying the result
        System.out.println("The maximum sum of the subarray is: " + result);

        scanner.close();
    }
}
