import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu
 * maybe delete if we have time
 * prevent the user from adding a duplicate?
 *
 * @author 13DTC
 * @version (a version number or a date)
 */
public class Books
{
    // instance variables
    private HashMap<Integer, Book> booksMap;        // declaring the hashmap
    private int currBookId;                 // store the current id of book being added
    private Book currBook;                  // store the instance of the current book

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        booksMap = new HashMap<Integer, Book>();        // initialise hashmap
        
        // Creating Books
        Book b1 = new Book(1, "Pet Semetary", "Stephen King", 76);
        Book b2 = new Book(2, "1984", "George Orwell", 66);
        Book b3 = new Book(3, "The subtle knife", "Phillip Pullman", 42);
        Book b4 = new Book(4, "The subtle art of not giving a F*ck", "Mark Mason", 99);
        
        // Add Books to collection
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);
        
        this.currBookId = 4;    // initialise the book id
        
        //this.menu();
    }
    
    /**
     * Set bookId
     * @param int amount to increment book id by
     */
    public void setBookId(int incrementor) {
        this.currBookId = this.currBookId + incrementor;
    }
    
    /**
     * Adds a book to the map
     */
    public void addBook(String name, String author, int quantity, String imgFileName) {
        booksMap.put(currBookId, new Book(currBookId, name, author, quantity, imgFileName));
    }
    
    /**
     * Finds a book based on name
     * sets the current book instance if found
     * @return boolean false if not found     * 
     */
    public boolean findBook(String name) {
        /*int bookId = UI.askInt("Id: ");     // Finds book on ID - change to title
        UI.println(booksMap.get(bookId).getName()); // prints out book name
        booksMap.get(bookId).displayBook();     // shows book cover on canvas
        */
       // Seach for book
       for (int bookId : booksMap.keySet()) {
           if (booksMap.get(bookId).getName().equals(name)) {
               currBook = booksMap.get(bookId);
               return true;
            }
        }
        return false;
    }
    
    /**
     * Getter for the current book instance
     */
    public Book getBook(){
        return this.currBook;
    }
    
    /**
     * Prints detail of all books
     */
    public void printAll() {
        // Traversing Map
        for (int bookId : booksMap.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(booksMap.get(bookId).getName() + " "
                     + booksMap.get(bookId).getAuthor() + " "
                     + booksMap.get(bookId).getQuantity());
        }
    }
    
    /**
     * Menu to print and call appropriate methods
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                //addBook();
            } else if (choice.equalsIgnoreCase("F")) {
                //findBook();
            } else if (choice.equalsIgnoreCase("P")) {
                printAll();
            } else if (choice.equalsIgnoreCase("Q")) {
                UI.println("Goodbye!");
                UI.quit();
            } else {
                UI.println("That is not a choice you knucklehead!");
            }
        } while (!choice.equalsIgnoreCase("Q"));
    }
}







