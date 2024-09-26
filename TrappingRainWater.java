package DaySix;
import java.util.Scanner;
class TrappingRainWater {
    public int trap(int[] height) {
      final int n = height.length;
      int ans = 0;
      int[] l = new int[n]; // l[i] := max(height[0..i])
      int[] r = new int[n]; // r[i] := max(height[i..n))
  
      for (int i = 0; i < n; ++i)
        l[i] = i == 0 ? height[i] : Math.max(height[i], l[i - 1]);
  
      for (int i = n - 1; i >= 0; --i)
        r[i] = i == n - 1 ? height[i] : Math.max(height[i], r[i + 1]);
  
      for (int i = 0; i < n; ++i)
        ans += Math.min(l[i], r[i]) - height[i];
  
      return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array input from the user
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        int[] height = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        // Creating an instance of TrappingRainWater class to call the trap method
        TrappingRainWater solution = new TrappingRainWater();
        int result = solution.trap(height);

        // Displaying the result
        System.out.println("The total amount of water that can be trapped is: " + result);

        scanner.close();
    }
}
