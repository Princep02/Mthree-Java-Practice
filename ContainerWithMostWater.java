package DaySix;

import java.util.Scanner;

class ContainerWithMostWater {

    // Function to find the maximum area of water that can be contained
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            final int minHeight = Math.min(height[l], height[r]);
            ans = Math.max(ans, minHeight * (r - l));
            if (height[l] < height[r])
                ++l;
            else
                --r;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input from the user
        System.out.println("Enter the number of vertical lines (size of the array):");
        int n = scanner.nextInt();

        int[] height = new int[n];
        System.out.println("Enter the heights of the vertical lines:");

        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        // Creating an instance of ContainerWithMostWater class to call the maxArea method
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int result = solution.maxArea(height);

        // Displaying the result
        System.out.println("The maximum area of water that can be contained is: " + result);

        scanner.close();
    }
}
