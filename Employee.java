package firstday;
public class Employee {
    // Employee attributes
    private String name;
    private int age;
    private String city;
    private int salary;
    private String company;
    private String designation;
    private String department;
    private String email;
    private long phone;

    // Method to print employee details
    public void printEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Salary: $" + salary);
        System.out.println("Company: " + company);
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone);
        System.out.println("----------------------------------");
    }

    // Method to set employee details
    public void setEmployeeDetails(String name, int age, String city, int salary, String company, String designation, String department, String email, long phone) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
        this.company = company;
        this.designation = designation;
        this.department = department;
        this.email = email;
        this.phone = phone;
        printEmployeeDetails();  // Print details once set
    }

    // Main method to create multiple Employee objects
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.setEmployeeDetails("Alice Johnson", 32, "Chicago", 110000, "DEF Corp", "Senior Developer", "IT Department", "alice.johnson@def.com", 1122334455L);

        Employee emp2 = new Employee();
        emp2.setEmployeeDetails("Michael Brown", 26, "Houston", 85000, "GHI Inc", "Marketing Specialist", "Marketing", "michael.brown@ghi.com", 2233445566L);

        Employee emp3 = new Employee();
        emp3.setEmployeeDetails("Sarah Miller", 35, "Boston", 120000, "JKL Solutions", "Project Manager", "Project Management", "sarah.miller@jkl.com", 3344556677L);

        Employee emp4 = new Employee();
        emp4.setEmployeeDetails("David Wilson", 29, "San Francisco", 95000, "MNO Enterprises", "Data Scientist", "Data Analytics", "david.wilson@mno.com", 4455667788L);

        Employee emp5 = new Employee();
        emp5.setEmployeeDetails("Emma Davis", 40, "Seattle", 130000, "PQR Industries", "Chief Technical Officer", "Technology", "emma.davis@pqr.com", 5566778899L);
    }
}
