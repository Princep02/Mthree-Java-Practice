// Java Parameterized Constructors: Detailed Examples and Use Cases

class Book {
    private String title;
    private String author;
    private int pageCount;
    private String isbn;
    private boolean isHardcover;

    // Parameterized constructor with all attributes
    public Book(String title, String author, int pageCount, String isbn, boolean isHardcover) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.isHardcover = isHardcover;
    }

    // Parameterized constructor with essential attributes
    public Book(String title, String author, String isbn) {
        this(title, author, 0, isbn, false); // Calls the full constructor with default values
    }

    // Parameterized constructor for a book without known ISBN
    public Book(String title, String author, int pageCount) {
        this(title, author, pageCount, "Unknown", false);
    }

    // Copy constructor
    public Book(Book otherBook) {
        this(otherBook.title, otherBook.author, otherBook.pageCount, otherBook.isbn, otherBook.isHardcover);
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", pageCount=" + pageCount +
               ", isbn='" + isbn + '\'' +
               ", isHardcover=" + isHardcover +
               '}';
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;

    // Parameterized constructor for creating a new account
    public BankAccount(String accountHolder, String accountType, double initialDeposit) {
        this.accountNumber = generateAccountNumber();
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = initialDeposit;
    }

    // Parameterized constructor for loading an existing account
    public BankAccount(String accountNumber, String accountHolder, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
    }

    private String generateAccountNumber() {
        // Simulating account number generation
        return "ACC" + Math.round(Math.random() * 1000000);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
               "accountNumber='" + accountNumber + '\'' +
               ", accountHolder='" + accountHolder + '\'' +
               ", balance=" + balance +
               ", accountType='" + accountType + '\'' +
               '}';
    }
}

public class ParameterizedConstructorExamples{
    public static void main(String[] args) {
        // Book examples
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, "9780743273565", true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789");
        Book book3 = new Book("1984", "George Orwell", 328);
        Book book4 = new Book(book1); // Using copy constructor

        System.out.println("Book Examples:");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);

        // BankAccount examples
        BankAccount account1 = new BankAccount("John Doe", "Savings", 1000.0);
        BankAccount account2 = new BankAccount("ACC123456", "Jane Smith", 5000.0, "Checking");

        System.out.println("\nBank Account Examples:");
        System.out.println(account1);
        System.out.println(account2);
    }
}