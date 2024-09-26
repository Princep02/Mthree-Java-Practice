public // Abstract class and interface examples

// Example 1: Shape hierarchy
abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    // Abstract method
    public abstract double calculateArea();

    // Concrete method
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Example 2: Vehicle interface and implementations
interface Vehicle {
    void start();
    void stop();
    int getFuelLevel();
}

abstract class AbstractVehicle implements Vehicle {
    protected int fuelLevel;

    public AbstractVehicle(int initialFuel) {
        this.fuelLevel = initialFuel;
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    // Abstract method specific to AbstractVehicle
    public abstract void refuel(int amount);
}

class Car extends AbstractVehicle {
    public Car(int initialFuel) {
        super(initialFuel);
    }

    @Override
    public void start() {
        System.out.println("Car engine started");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stopped");
    }

    @Override
    public void refuel(int amount) {
        fuelLevel += amount;
        System.out.println("Car refueled. New fuel level: " + fuelLevel);
    }
}

class Bicycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bicycle started moving");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle stopped moving");
    }

    @Override
    public int getFuelLevel() {
        return 100; // Bicycles don't use fuel, so always return 100%
    }
}

// Example 3: Payment processing
interface PaymentProcessor {
    boolean processPayment(double amount);
    void refundPayment(double amount);
}

abstract class OnlinePaymentProcessor implements PaymentProcessor {
    protected String merchantId;

    public OnlinePaymentProcessor(String merchantId) {
        this.merchantId = merchantId;
    }

    // Abstract method specific to OnlinePaymentProcessor
    public abstract boolean verifyMerchant();
}

class CreditCardProcessor extends OnlinePaymentProcessor {
    public CreditCardProcessor(String merchantId) {
        super(merchantId);
    }

    @Override
    public boolean processPayment(double amount) {
        if (verifyMerchant()) {
            System.out.println("Processing credit card payment of $" + amount);
            return true;
        }
        return false;
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding credit card payment of $" + amount);
    }

    @Override
    public boolean verifyMerchant() {
        // Simulate merchant verification
        return merchantId.startsWith("CC");
    }
}

class PayPalProcessor extends OnlinePaymentProcessor {
    public PayPalProcessor(String merchantId) {
        super(merchantId);
    }

    @Override
    public boolean processPayment(double amount) {
        if (verifyMerchant()) {
            System.out.println("Processing PayPal payment of $" + amount);
            return true;
        }
        return false;
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding PayPal payment of $" + amount);
    }

    @Override
    public boolean verifyMerchant() {
        // Simulate merchant verification
        return merchantId.startsWith("PP");
    }
}

public class AbstractandInterfaceExamples {
    public static void main(String[] args) {
        // Example 1: Shape hierarchy
        System.out.println("Example 1: Shape Hierarchy");
        Shape circle = new Circle("Red", 5);
        Shape rectangle = new Rectangle("Blue", 4, 6);

        System.out.println("Circle:");
        circle.displayColor();
        System.out.println("Area: " + circle.calculateArea());

        System.out.println("\nRectangle:");
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.calculateArea());

        // Example 2: Vehicle interface and implementations
        System.out.println("\nExample 2: Vehicle Interface");
        Vehicle car = new Car(50);
        Vehicle bicycle = new Bicycle();

        car.start();
        System.out.println("Car fuel level: " + car.getFuelLevel());
        ((Car) car).refuel(20);
        car.stop();

        bicycle.start();
        System.out.println("Bicycle 'fuel' level: " + bicycle.getFuelLevel());
        bicycle.stop();

        // Example 3: Payment processing
        System.out.println("\nExample 3: Payment Processing");
        PaymentProcessor creditCard = new CreditCardProcessor("CC123");
        PaymentProcessor payPal = new PayPalProcessor("PP456");

        creditCard.processPayment(100.50);
        creditCard.refundPayment(20.00);

        payPal.processPayment(75.25);
        payPal.refundPayment(75.25);
    }
} {
    
}
