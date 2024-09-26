package SecondDay;
import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String model;
    private String type;
    private double ratePerKm;
    private boolean available;

    public Vehicle(String vehicleNumber, String model, String type, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.type = type;
        this.ratePerKm = ratePerKm;
        this.available = true;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        if (available) {
            available = false;
            System.out.println(type + " with vehicle number " + vehicleNumber + " has been rented.");
        } else {
            System.out.println(type + " with vehicle number " + vehicleNumber + " is not available.");
        }
    }

    public void returnVehicle() {
        if (!available) {
            available = true;
            System.out.println(type + " with vehicle number " + vehicleNumber + " has been returned.");
        } else {
            System.out.println(type + " with vehicle number " + vehicleNumber + " was not rented.");
        }
    }

    public double calculateRent(double kilometers) {
        return kilometers * ratePerKm;
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Model: " + model + ", Type: " + type + ", Rate per Km: " + ratePerKm + ", Available: " + (available ? "Yes" : "No"));
    }
}

class Scooty extends Vehicle {
    public Scooty(String vehicleNumber, String model) {
        super(vehicleNumber, model, "Scooty", 10);
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String model) {
        super(vehicleNumber, model, "Bike", 20);
    }
}

class Car extends Vehicle {
    private String variant; 

    public Car(String vehicleNumber, String model, String variant, double ratePerKm) {
        super(vehicleNumber, model, "Car", ratePerKm);
        this.variant = variant;
    }

    @Override
    public double calculateRent(double kilometers) {
        double baseRate = super.getRatePerKm();
        double variantRate;
        switch (variant.toLowerCase()) {
            case "petrol":
                variantRate = 1.0;
                break;
            case "diesel":
                variantRate = 1.2;
                break;
            case "ev":
                variantRate = 1.5;
                break;
            default:
                variantRate = 1.0;
                break;
        }

        return kilometers * baseRate * variantRate;
    }

    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo();
        System.out.println("Variant: " + variant);
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, String model) {
        super(vehicleNumber, model, "Truck", 600);
    }
}

class Member {
    private String name;
    private int id;
    private String contactNumber;
    private String rentedVehicle;

    public Member(String name, int id, String contactNumber) {
        this.name = name;
        this.id = id;
        this.contactNumber = contactNumber;
        this.rentedVehicle = "";
    }

    public int getId() {
        return id;
    }

    public String getRentedVehicle() {
        return rentedVehicle;
    }

    public void setRentedVehicle(String rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }

    public void display() {
        System.out.println("Name: " + name + ", ID: " + id + ", Contact: " + contactNumber + ", Rented Vehicle: " + (rentedVehicle.isEmpty() ? "None" : rentedVehicle));
    }
}
class RentalManagement {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }
    public void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available in the system.");
        } else {
            System.out.println("All Vehicles:");
            for (Vehicle vehicle : vehicles) {
                vehicle.displayVehicleInfo();
            }
        }
    }
    public void displayAvailableVehicles() {
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                vehicle.displayVehicleInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available vehicles at the moment.");
        }
    }
    public void rentVehicle(String vehicleType, String vehicleNumber, Member member) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(vehicleType) && vehicle.getVehicleNumber().equals(vehicleNumber) && vehicle.isAvailable()) {
                vehicle.rent();
                member.setRentedVehicle(vehicle.getType());
                return;
            }
        }
        System.out.println("Vehicle not found or already rented.");
    }
    public void returnVehicle(String vehicleNumber, double kilometers) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber) && !vehicle.isAvailable()) {
                vehicle.returnVehicle();
                double rent = vehicle.calculateRent(kilometers);
                System.out.println("Total rent for " + kilometers + " km: " + rent);
                return;
            }
        }
        System.out.println("Vehicle not found or not rented.");
    }
    public void addMember(String name, int id, String contactNumber) {
        members.add(new Member(name, id, contactNumber));
        System.out.println("Member added successfully.");
    }
    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members in the system.");
        } else {
            System.out.println("Members:");
            for (Member member : members) {
                member.display();
            }
        }
    }
    public Member getMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        RentalManagement rentalManagement = new RentalManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;
        rentalManagement.addVehicle(new Scooty("1", "Honda Activa"));
        rentalManagement.addVehicle(new Bike("2", "Royal Enfield"));
        rentalManagement.addVehicle(new Car("3", "Hyundai Verna", "petrol", 100));
        rentalManagement.addVehicle(new Car("4", "Maruti Swift", "diesel", 400));
        rentalManagement.addVehicle(new Car("5", "Toyota Fortuner", "ev", 500));
        rentalManagement.addVehicle(new Truck("6", "Tata Truck"));

        do {
            System.out.println("\nVehicle Rental Management System");
            System.out.println("1. Add Member");
            System.out.println("2. Display Members");
            System.out.println("3. Display All Vehicles");
            System.out.println("4. Display Available Vehicles");
            System.out.println("5. Rent a Vehicle");
            System.out.println("6. Return a Vehicle");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    rentalManagement.addMember(name, id, contactNumber);
                    break;
                case 2:
                    rentalManagement.displayMembers();
                    break;
                case 3:
                    rentalManagement.displayAllVehicles();
                    break;
                case 4:
                    rentalManagement.displayAvailableVehicles();
                    break;
                case 5:
                    System.out.print("Enter vehicle type (Scooty/Bike/Car/Truck): ");
                    String vehicleType = scanner.nextLine();
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); 
                    Member member = rentalManagement.getMemberById(memberId);
                    if (member != null) {
                        rentalManagement.rentVehicle(vehicleType, vehicleNumber, member);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter vehicle number: ");
                    String returnVehicleNumber = scanner.nextLine();
                    System.out.print("Enter kilometers traveled: ");
                    double kilometers = scanner.nextDouble();
                    rentalManagement.returnVehicle(returnVehicleNumber, kilometers);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}