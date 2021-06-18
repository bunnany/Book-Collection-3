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
        } while (0 > quantity || quantity > MAX_QUANTITY);
        
        // add a book image for display in the GUI
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // Increment the book ID count and add to hashmap
        bk.setBookId(INCREMENT);
        bk.addBook(name, author, quantity, imgFileName);
    }
}






