package assignment_4;

import java.util.ArrayList;

public class Library {
    private String libraryAddress;

    ArrayList<Book> books = new ArrayList<>(); 

    // constructor
    public Library (String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    // adds a book to the library 
    public void addBook(Book book) {
        books.add(book); 
    }

    public static void printOpeningHours () {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress () {
        System.out.println(libraryAddress);
    }

    // this method looks to see if the book is in the library 
    // if it is not borrowed yet, it will borrow it
    // if the book is not found, prints that the book is not in the catalog
    public void borrowBook (String title) {
        // initially set bookFound to false
        boolean bookFound = false;

        // find if any books have the same title in the array list
        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                // if the book is found, set bookFound to true
                bookFound = true; 

                if (books.get(i).isBorrowed() == false) {
                    books.get(i).borrowed(); 
                    System.out.println("You successfully borrowed" + books.get(i).getTitle());

                } else if (books.get(i).isBorrowed() == true) {
                    System.out.println("Sorry, this book is already borrowed.");
                }

                break; 
            }
        } 

        // if the book is not found, print the book is not in the catalog
        if (!bookFound) {
            System.out.println("Sorry, this book is not in our catalog.");
        }

    }

    public static void printAvailableBooks() {

    }

    public static void main(String[] args) {

        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

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
        // System.out.println("Books available in the first library:");
        // firstLibrary.printAvailableBooks();
        // System.out.println();
        // System.out.println("Books available in the second library:");
        // secondLibrary.printAvailableBooks();
        // System.out.println();

        // Return The Lords of the Rings to the first library
        // System.out.println("Returning The Lord of the Rings:");
        // firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        // System.out.println("Books available in the first library:");
        // firstLibrary.printAvailableBooks();
    }
}
