import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class LibraryExample {
    
    static class Book {
        int bookId;
        String title, author;
        boolean isAvailable;

        public Book(Scanner sc) {
            System.out.println("Input format: '<bookId> <author> <title>'");
            bookId = sc.nextInt();
            author = sc.next();
            title = sc.next();
            isAvailable = true;  // Set book as available when created
        }

        public void displayBookInfo() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Available: " + isAvailable);
            System.out.println("\n");
        }

        public boolean borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }
            return false;
        }

        public void returnBook() {
            isAvailable = true;
        }
    }

    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

       public void removeBook(int bookId) {
    boolean removed = books.removeIf(book -> book.bookId == bookId);
    
    if (removed) {
        System.out.println("Book with ID " + bookId + " removed.");
    } else {
        System.out.println("Book not found!");
    }
}

        public void listAvailableBooks() {
            for (Book book : books) {
                if (book.isAvailable)
                    book.displayBookInfo();
            }
        }
    }

    static class Student {
        int studentId;
        String name;
        ArrayList<Book> borrowedBooks = new ArrayList<>();

        public Student(Scanner sc) {
            System.out.println("Input format: '<studentId> <name>'");
            studentId = sc.nextInt();
            name = sc.next();
        }

        public void borrowBook(Book book) {
            if (book.isAvailable && borrowedBooks.size() < 3) {  
                borrowedBooks.add(book);
                book.borrowBook();
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("The book is not available or borrowing limit reached!");
            }
        }

        public void returnBook(Book book) {
            if (borrowedBooks.contains(book)) {
                book.returnBook();
                borrowedBooks.remove(book);
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("The book was not borrowed!");
            }
        }

        
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    
    Library library = new Library();

    
    System.out.println("Adding books to library...");
    library.addBook(new Book(sc));
    library.addBook(new Book(sc));

    
    System.out.println("Available books in the library:");
    library.listAvailableBooks();

    
    System.out.println("Enter the name and ID of the student who wants to borrow a book:");
    Student borrower = new Student(sc);

    
    System.out.println("Enter the Book ID to borrow:");
    int bookIdToBorrow = sc.nextInt();

    
    Book bookToBorrow = null;
    for (Book book : library.books) {
        if (book.bookId == bookIdToBorrow) {
            bookToBorrow = book;
            break;
        }
    }

    if (bookToBorrow != null) {
        borrower.borrowBook(bookToBorrow);
        System.out.println("\n conform borrowing:");
        System.out.println(" Name of the student: " + borrower.name);
        System.out.println("assigned book: " + bookToBorrow.title + " by " + bookToBorrow.author);
    } else {
        System.out.println("Book with ID " + bookIdToBorrow + " not found.");
    }

    
    System.out.println("\nAvailable books after borrowing:");
    library.listAvailableBooks();

    
    System.out.println("\nEnter the Book ID to return:");
    int bookIdToReturn = sc.nextInt();

    
    Book bookToReturn = null;
    for (Book book : borrower.borrowedBooks) {
        if (book.bookId == bookIdToReturn) {
            bookToReturn = book;
            break;
        }
    }

    if (bookToReturn != null) {
        borrower.returnBook(bookToReturn);
        System.out.println("\n Return Confirmation:");
        System.out.println("Borrower Name: " + borrower.name);
        System.out.println("Book Returned: " + bookToReturn.title + " by " + bookToReturn.author);
    } else {
        System.out.println("You didn't borrow a book with ID " + bookIdToReturn);
    }

    
    System.out.println("\nAvailable books after return:");
    library.listAvailableBooks();

    sc.close();
}

}

