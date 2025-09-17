public class Product {
    String productName;
    double price;
    static int totalProducts;

    public Product() {
        productName = "Unknown";
        price = 0.0;
        totalProducts++;
    }

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product: " + productName + ", Price: $" + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("Tablet", 300);
        Product p3 = new Product("Laptop", 1200);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts();
    }
}
