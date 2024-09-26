package ThirdDay;
import java.util.Scanner;
public class CoffeeShop {
    // Enum definition for coffee sizes
    public enum CoffeeSize {
        SMALL(3.5, 8),
        MEDIUM(4.0, 12),
        LARGE(4.5, 16),
        EXTRA_LARGE(5.0, 20);

        private final double price;
        private final int ounces;

        // Constructor for the enum
        CoffeeSize(double price, int ounces) {
            this.price = price;
            this.ounces = ounces;
        }

        // Getter methods
        public double getPrice() {
            return price;
        }

        public int getOunces() {
            return ounces;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to our Coffee Shop!");
        System.out.println("Available sizes:");
        
        // Display all available coffee sizes
        for (CoffeeSize size : CoffeeSize.values()) {
            System.out.printf("%s (%d oz) - $%.2f%n", 
                              size.name(), 
                              size.getOunces(), 
                              size.getPrice());
        }

        System.out.print("Enter your choice (SMALL/MEDIUM/LARGE/EXTRA_LARGE): ");
        String userChoice = scanner.nextLine().toUpperCase();

        try {
            CoffeeSize selectedSize = CoffeeSize.valueOf(userChoice);
            System.out.printf("You've selected a %s coffee (%d oz).%n", 
                              selectedSize.name(), 
                              selectedSize.getOunces());
            System.out.printf("Price: $%.2f%n", selectedSize.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size selected. Please try again.");
        }

        scanner.close();
    }
}