package DaySix;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ComplementFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            int element = sc.nextInt();
            map.put(element, i);
        }
        System.out.println("Enter the target:");
        int target = sc.nextInt();
        findComplements(map, target);
        
        sc.close();
    }
    public static void findComplements(Map<Integer, Integer> map, int target) {
        for (int num : map.keySet()) {
            int complement = target - num;
            if (map.containsKey(complement) && map.get(complement) != map.get(num)) {
                System.out.println("Element: " + num + " has complement: " + complement + " at index: " + map.get(complement));
            }
        }
    }
}
