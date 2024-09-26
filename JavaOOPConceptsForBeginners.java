// Java OOP Concepts for Beginners - Comprehensive Guide

// This program demonstrates Object-Oriented Programming (OOP) concepts in Java
// in an order suitable for beginners to understand. Each concept is explained
// with comments and multiple examples.

// 1. Classes and Objects
// A class is a blueprint for creating objects. It defines attributes (fields) 
// and behaviors (methods) that the objects of the class will have.

class Car {
    // Fields (attributes)
    String brand;
    String model;
    int year;
    
    // Constructor: special method to initialize objects
    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // Method (behavior)
    void displayInfo() {
        System.out.println("Car: " + year + " " + brand + " " + model);
    }
}

// 2. Encapsulation
// Encapsulation is the bundling of data and the methods that operate on that data within a single unit (class).
// It restricts direct access to some of an object's components, which is a means of preventing accidental 
// interference and misuse of the methods and data.

class BankAccount {
    // Private fields - can only be accessed within this class
    private String accountNumber;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Public methods to access and modify the private fields
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

// 3. Inheritance
// Inheritance is a mechanism where a new class is derived from an existing class.
// The new class (subclass) inherits fields and methods from the existing class (superclass).

// Superclass
class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
    }
    
    void eat() {
        System.out.println(name + " is eating.");
    }
}

// Subclass
class Dog extends Animal {
    Dog(String name) {
        super(name); // Call the superclass constructor
    }
    
    void bark() {
        System.out.println(name + " is barking.");
    }
}

// 4. Polymorphism
// Polymorphism allows objects of different classes to be treated as objects of a common superclass.
// It can be achieved through method overriding and method overloading.

// Method Overriding: providing a specific implementation of a method in the subclass 
// that is already defined in the superclass.
class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    
    // Override the eat() method
    @Override
    void eat() {
        System.out.println(name + " is eating fish.");
    }
    
    void meow() {
        System.out.println(name + " is meowing.");
    }
}

// 5. Abstraction
// Abstraction is the process of hiding the implementation details and showing only the functionality to the user.
// It can be achieved through abstract classes and interfaces.

// Abstract class
abstract class Shape {
    abstract double calculateArea();
    
    void display() {
        System.out.println("This is a shape.");
    }
}

class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// 6. Interfaces
// An interface is a completely abstract class that contains only abstract methods.
// It can be used to achieve multiple inheritance in Java.

interface Drawable {
    void draw();
}

class Rectangle extends Shape implements Drawable {
    double length;
    double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double calculateArea() {
        return length * width;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Main class to demonstrate all concepts
public class JavaOOPConceptsForBeginners {
    public static void main(String[] args) {
        // 1. Classes and Objects
        System.out.println("1. Classes and Objects:");
        Car myCar = new Car("Toyota", "Corolla", 2022);
        myCar.displayInfo();
        
        // 2. Encapsulation
        System.out.println("\n2. Encapsulation:");
        BankAccount account = new BankAccount("123456", 1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Account balance: $" + account.getBalance());
        
        // 3. Inheritance
        System.out.println("\n3. Inheritance:");
        Dog myDog = new Dog("Buddy");
        myDog.eat();
        myDog.bark();
        
        // 4. Polymorphism
        System.out.println("\n4. Polymorphism:");
        Animal myAnimal = new Cat("Whiskers");
        myAnimal.eat(); // This will call the overridden method in Cat
        
        // 5. Abstraction
        System.out.println("\n5. Abstraction:");
        Shape myCircle = new Circle(5);
        System.out.println("Circle area: " + myCircle.calculateArea());
        
        // 6. Interfaces
        System.out.println("\n6. Interfaces:");
        Rectangle myRectangle = new Rectangle(4, 5);
        myRectangle.draw();
        System.out.println("Rectangle area: " + myRectangle.calculateArea());
    }
}