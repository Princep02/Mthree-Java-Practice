import java.util.*;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Member {
    int id;
    String name;
    String contactNumber;

    public Member(int id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name + ", Contact: " + contactNumber;
    }
}

class Transaction {
    String bookTitle;
    String memberName;
    String type; // "Issued" or "Returned"
    Date transactionDate;
    Date issueDate; // For the issue date
    Date returnDate; // For the return date

    public Transaction(String bookTitle, String memberName, String type, Date issueDate, Date returnDate) {
        this.bookTitle = bookTitle;
        this.memberName = memberName;
        this.type = type;
        this.transactionDate = new Date();
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        String issueDateStr = (issueDate != null) ? issueDate.toString() : "N/A";
        String returnDateStr = (returnDate != null) ? returnDate.toString() : "N/A";
        return "Transaction: " + type +
               " | Book: " + bookTitle +
               " | Member: " + memberName +
               " | Date: " + transactionDate +
               " | Issue Date: " + issueDateStr +
               " | Return Date: " + returnDateStr;
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void displayBooks() {
        System.out.println("\n--- List of Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String title, String memberName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.setIssued(true);
                transactions.add(new Transaction(title, memberName, "Issued", new Date(), null));
                System.out.println("Book issued: " + title + " to " + memberName);
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    public void returnBook(String title, String memberName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.setIssued(false);
                transactions.add(new Transaction(title, memberName, "Returned", null, new Date()));
                System.out.println("Book returned: " + title + " by " + memberName);
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void addMember(int id, String name, String contactNumber) {
        members.add(new Member(id, name, contactNumber));
        System.out.println("Member added: " + name);
    }

    public void displayMembers() {
        System.out.println("\n--- List of Members ---");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author.");
        }
    }

    public void displayTransactions() {
        System.out.println("\n--- Transaction Details ---");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class Librar{
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Member");
            System.out.println("6. Display Members");
            System.out.println("7. Search by Title");
            System.out.println("8. Search by Author");
            System.out.println("9. Display Transactions");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to issue: ");
                    title = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    library.issueBook(title, memberName);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    library.returnBook(title, memberName);
                    break;
                case 5:
                    System.out.print("Enter member ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    library.addMember(id, name, contactNumber);
                    break;
                case 6:
                    library.displayMembers();
                    break;
                case 7:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    library.searchByTitle(title);
                    break;
                case 8:
                    System.out.print("Enter author name to search: ");
                    author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 9:
                    library.displayTransactions();
                    break;
                case 10:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);

        scanner.close();
    }
}