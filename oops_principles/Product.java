import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        if (products.isEmpty()) {
            System.out.println("  No products in this order.");
        } else {
            System.out.println("  Products:");
            for (Product p : products) System.out.println("   - " + p);
            System.out.println("  Total: $" + calculateTotal());
        }
        System.out.println();
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Order placeOrder(int orderId) {
        Order o = new Order(orderId, this);
        orders.add(o);
        return o;
    }

    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + ":");
        if (orders.isEmpty()) {
            System.out.println("  No orders found.");
        } else {
            for (Order o : orders) o.showOrderDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Product p1 = new Product("Laptop", 1200.0);
        Product p2 = new Product("Headphones", 150.0);
        Product p3 = new Product("Smartphone", 800.0);

        Order o1 = c1.placeOrder(101);
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = c1.placeOrder(102);
        o2.addProduct(p3);

        Order o3 = c2.placeOrder(201);
        o3.addProduct(p2);
        o3.addProduct(p3);

        c1.showCustomerOrders();
        c2.showCustomerOrders();
    }
}
