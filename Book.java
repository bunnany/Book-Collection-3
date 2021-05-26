import ecs100.*;

/**
 * Support class of Book
 * A Book contains an id, name, author, quantity, image
 *
 * @author 13DTC_3
 * @version May 2021
 */
public class Book
{
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "book.png";

    /**
     * Constructor for objects of class Book
     */
    public Book(int id, String nm, String auth, int qty, String img)
    {
        // initialise instance variables
        this.id = id;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.image = img;
    }

    /**
     * Constructor overloading
     * Set default image to obj
     */
    public Book(int id, String nm, String author, int qty) {
        this(id, nm, author, qty, DEFAULT_IMAGE);
    }
    
    /**
     * Getter for id
     *
     * @return  int the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for Name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter for Author
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * Getter for Quantity
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * Display our image on our GUI
     */
    public void displayBook() {
        double locX = 100;
        double locY = 100;
        final double WIDTH = 100;
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
}







