package DaySix;
import java.util.Scanner;
public class Print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num of times:");
        int n = sc.nextInt();
        String message = "C401 MThree SD Chohort";
        printMessage(message, n);
        sc.close();
    }
    public static void printMessage(String message, int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(message);
        printMessage(message, n - 1);
    }
}
