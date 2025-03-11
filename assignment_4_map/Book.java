package assignment_4_map;

public class Book {
    String title;
    boolean isAvailable;
    int bookCount = 0;

    // This is the maximum number of a particular book in the library.
    // This will prevent someone from returning too many of the same book.
    int maxBookCount = 0;

    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        title = bookTitle;
        bookCount = 1;
    }

    public int getMaxBookCount() {
        return maxBookCount;
    }

    public void addMaxBookCount() {
        maxBookCount++;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void addBookCount() {
        bookCount++;
    }

    public void substractBookCount() {
        bookCount--;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isAvailable() {
        if (bookCount > 0) {
            return true;
        }

        return false;
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return title;
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        example.addBookCount();
        System.out.println("Borrowed? (should be true): " + example.isAvailable());
        example.substractBookCount();
        System.out.println("Borrowed? (should be false): " + example.isAvailable());
        example.addBookCount();
        System.out.println("Borrowed? (should be true): " + example.isAvailable());
    }
}
