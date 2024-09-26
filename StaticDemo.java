package firstday;
public class StaticDemo {
    // Static variable to keep track of the number of instances
    private static int totalInstances = 0;
    // Instance variable to store the unique number of each instance
    private int instanceID;
    // Constructor to increment the static count and assign instanceID
    public StaticDemo() {
        totalInstances++;
        instanceID = totalInstances;
    }
    // Method to display instance details
    public void displayInfo() {
        System.out.println("Instance ID: " + instanceID + "\nTotal Instances: " + totalInstances);
    }
    public static void main(String[] args) {
        StaticDemo obj1 = new StaticDemo();
        obj1.displayInfo();
        StaticDemo obj2 = new StaticDemo();
        obj2.displayInfo();
        StaticDemo obj3 = new StaticDemo();
        obj3.displayInfo();
    }
}
