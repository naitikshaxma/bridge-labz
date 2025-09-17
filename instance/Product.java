public class Product {
    static double discount = 5.0;

    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public double calculateTotalPrice() {
        return (price * quantity) * (1 - discount / 100);
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 800, 2, 101);
        Product p2 = new Product("Headphones", 50, 4, 102);

        if (p1 instanceof Product) p1.displayDetails();
        if (p2 instanceof Product) p2.displayDetails();

        Product.updateDiscount(10);

        System.out.println("Total Price p1: " + p1.calculateTotalPrice());
        System.out.println("Total Price p2: " + p2.calculateTotalPrice());
    }
}
