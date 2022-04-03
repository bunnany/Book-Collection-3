import ecs100.*;
/**
 * Class to handle the GUI functionality
 *
 * @author 13DTC
 * @version (a version number or a date)
 */
public class GUI
{
    private Books bk;   // declare books instance
    private Book book;  // instance of book
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        bk = new Books();
        UI.initialise();
        UI.addButton("All", bk::printAll);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Adds a book to collection
     */
    public void addBook() {
        final int MAX_QUANTITY = 99;
        final int INCREMENT = 1;
        int quantity = -1;
        
        // Ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        
        // check boundaries for the number of books added to stock
        do {
            quantity = UI.askInt("Quantity: ");
            if ((quantity > 0) && (quantity < MAX_QUANTITY)) {
                UI.println("Added");
            } else if (quantity > MAX_QUANTITY){
                UI.println("Must be less than 100");
            } else if (quantity < 0) {
                UI.println("Must be greater than 0");
            } else {
                UI.println("Must be a number!");
            }
        } while (0 > quantity || quantity > MAX_QUANTITY);
        
        // add a book image for display in the GUI
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // Increment the book ID count and add to hashmap
        bk.setBookId(INCREMENT);
        bk.addBook(name, author, quantity, imgFileName);
    }
    
    /**
     * Finds book based on name
     * Prints out the qty if it finds it
     */
    public void findBook() {
        String bookName = UI.askString("Name of book: ");
        if (bk.findBook(bookName.toLowerCase())) {
            UI.println("Found book!");
            book = bk.getBook();
            UI.println("Qty: " + book.getQuantity());
        } else {
            UI.println("That book does not exist!");
        }
    }
}






