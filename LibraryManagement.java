
import java.util.*;

class Book {
    int id;
    String title, author;
    boolean isIssued;
    
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();
    
    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }
    
    void removeBook(int id) {
        books.removeIf(book -> book.id == id);
        System.out.println("Book removed successfully!");
    }
    
    void issueBook(int id) {
        for (Book book : books) {
            if (book.id == id && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or already issued!");
    }
    
    void returnBook(int id) {
        for (Book book : books) {
            if (book.id == id && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid book ID!");
    }
    
    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to Remove: ");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    library.viewBooks();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
