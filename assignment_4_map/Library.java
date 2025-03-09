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

            // if the book count is greater than 0, just increase the bookCount.
            if (books.get(bookTitle).getBookCount() > 0) {
                books.get(bookTitle).addBookCount();
                books.get(bookTitle).addMaxBookCount();
                return;
            }
        }

        Book book = new Book(bookTitle);
        books.put(bookTitle, book);
        books.get(bookTitle).addBookCount();
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
        // initially set bookFound to false
        // when a book title is found, set to true. Note: the book may not be
        // borrowable.
        boolean bookFound = false;
        boolean bookCanBorrow = false;

        // check if the hashmap has the key (book title)
        if (books.containsKey(title)) {
            // found the book with the title
            bookFound = true;

            // check if the book is available to borrow
            if (books.get(title).isAvailable()) {
                // the book is found and can be borrowed.
                bookCanBorrow = true;
                System.out.println("You successfully borrowed: " + title);
                books.get(title).substractBookCount();
            }
        }

        if (!bookCanBorrow && bookFound) {
            System.out.println("Sorry, this book is already borrowed.");
            return;
        }

        // if the book is not found, print the book is not in the catalog
        if (!bookFound) {
            System.out.println("Sorry, this book is not in our catalog.");
            return;
        }

    }

    public void printAvailableBooks() {

        for (String title : books.keySet()) {
            if (books.get(title).getBookCount() > 0) {
                System.out.println(title);
            }
        }
    }

    public void returnBook(String title) {

        boolean bookFound = false;

        if (books.containsKey(title)) {
            // found the book with the title
            bookFound = true;
            if (books.get(title).getBookCount() <= books.get(title).getMaxBookCount()) {
                books.get(title).addBookCount();
            } else {
                System.out.println("You can't return this book, it is an extra one that is not in our system.");
            }
        }

        if (!bookFound) {
            System.out.println("You can't return this book. It is not in our system.");
        }
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
