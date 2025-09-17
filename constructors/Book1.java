\\Library Book System: Create a Book class with attributes title, author, price, and availability. Implement a method to borrow a book.
public class Book1 {
    String title;
    String author;
    double price;
    boolean available;

    public Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }
}
