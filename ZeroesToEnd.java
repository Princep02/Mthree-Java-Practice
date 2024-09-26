package Day7;
import java.util.Arrays;
public class ZeroesToEnd {
    public static void pushZeroes(int[] arr) {
        int n = arr.length;
        int nonZero= 0; 
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZero] = arr[i];
                nonZero++;
            }
        }
        while (nonZero < n) {
            arr[nonZero] = 0;
            nonZero++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 0, 3, 12, 0, 5, 0, 9};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Push zeroes to the end
        pushZeroes(arr);

        System.out.println("Array after pushing zeroes to the end: " + Arrays.toString(arr));
    }
}