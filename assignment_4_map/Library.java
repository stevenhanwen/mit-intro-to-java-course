package assignment_4_map;

import java.util.HashMap;

public class Library {

    HashMap<String, Book> books = new HashMap<String, Book>();

    private String libraryAddress;

    // constructor
    public Library(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    // adds a book to the library in the hashmap
    public void addBook(String bookTitle) {

        // check if the same book is already in the hashmap
        if (books.containsKey(bookTitle)) {
            // book exists, just increase count.
            books.get(bookTitle).addBookCount();
            books.get(bookTitle).addMaxBookCount();
            return;
        }

        // book does not exist, create a new book and increase count.
        Book book = new Book(bookTitle);
        books.put(bookTitle, book);
        books.get(bookTitle).addMaxBookCount();

    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(libraryAddress);
    }

    // this method looks to see if the book is in the hashmap
    // if it is not borrowed yet, it will borrow it
    // if the book is not found, prints that the book is not in the catalog
    public void borrowBook(String title) {

        if (!books.containsKey(title)) {
            System.out.println("Can't borrown, book not found");
            return;
        }

        // grab the book object
        Book book = books.get(title);

        if (!book.isAvailable()) {
            System.out.println("Can't borrow, book not available");
            return;
        }

        book.substractBookCount();
        System.out.println("Borrowed successfully");
    }

    public void printAvailableBooks() {

        for (String title : books.keySet()) {
            if (books.get(title).getBookCount() > 0) {
                System.out.println(title);
            }
        }
    }

    public void returnBook(String title) {

        // check if book in the catalog exists
        if (!books.containsKey(title)) {
            System.out.println("Can't return, book not in catalog");
            return;
        }
        // grab the book object
        Book book = books.get(title);
        System.out.println("current count of " + title + " is: " + book.getBookCount());
        System.out.println("current max count of " + title + " is: " + book.getMaxBookCount());
        // check if current count equals max count
        // if so, can't return the book because the book has not been borrowed.
        // for example: add book "abc", then return "abc" without ever borrowing it.
        if (book.getBookCount() == book.getMaxBookCount()) {
            System.out.println("Can't return, there is already max # of this book");
            return;
        }

        // increase book count after returning.
        book.addBookCount();
        System.out.println("Successfully returned book!");
    }

    public static void main(String[] args) {

        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        // Add four books to the first library
        firstLibrary.addBook("The Da Vinci Code");
        firstLibrary.addBook("Le Petit Prince");
        firstLibrary.addBook("A Tale of Two Cities");
        firstLibrary.addBook("The Lord of the Rings");
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}
