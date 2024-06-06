package assignment4;

public class Library {
    static String openingHours = "Libraries are open daily from 9am to 5pm.";
    String address;
    Book[] bookCollection;
    int numberOfBooks;

    public Library(String libraryaddress) {
        address = libraryaddress;
        bookCollection = new Book[10000];
        numberOfBooks = 0;
    }

    public void addBook(Book book) {
        bookCollection[numberOfBooks++] = book;
    }

    public static void printOpeningHours() {
        System.out.println(openingHours);
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void borrowBook(String bookTitle) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (bookCollection[i].title.equals(bookTitle)) {
                if (bookCollection[i].isBorrowed()) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    bookCollection[i].borrowed();
                    System.out.println("You successfully borrowed " + bookCollection[i].title);
                }
                return;
            }
        }

        System.out.println("Sorry, this book is not in our catalog.");
    }

    public void printAvailableBooks() {
        if (numberOfBooks == 0) {
            System.out.println("No book in catalog");
        } else {
            for (int i = 0; i < numberOfBooks; i++) {
                if (!bookCollection[i].isBorrowed()) {
                    System.out.println(bookCollection[i].title);
                }
            }
        }
    }

    public void returnBook(String bookTitle) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (bookCollection[i].title.equals(bookTitle)) {
                if (bookCollection[i].isBorrowed()) {
                    bookCollection[i].returned();
                    System.out.println("You successfully returned " + bookCollection[i].title);
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }

        System.out.println("Sorry, this book is not in our catalog.");
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
