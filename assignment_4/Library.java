package assignment_4;

import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    private String libraryAddress;

    ArrayList<Book> books = new ArrayList<>(); 

    public Library (String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public void addBook(Book book) {
        books.add(book); 
    }

    public static void printOpeningHours () {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress () {
        System.out.println(libraryAddress);
    }

    public void borrowBook (String title) {
        boolean bookFound = false;

        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
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
