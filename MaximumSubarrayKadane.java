package DaySix;
import java.util.Scanner;
public class MaximumSubarrayKadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int maxSum = kadaneAlgorithm(nums);
        System.out.println("The maximum sum of a contiguous subarray is: " + maxSum);
        sc.close();
    }
    public static int kadaneAlgorithm(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
