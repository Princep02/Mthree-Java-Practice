package DayFive;
import java.util.HashMap;
import java.util.Map;
public class ComplementFinder {

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2};
        int target = 6;
        findComplementIndices(nums, target);
    }

    public static void findComplementIndices(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("Element: " + nums[i] + " has complement: " + complement + " at index: " + map.get(complement));
            }
        }
    }
}
