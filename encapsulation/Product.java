abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double taxRate;
    private double discountRate;

    public Electronics(int id, String name, double price, double taxRate, double discountRate) {
        super(id, name, price);
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    public double calculateTax() {
        return getPrice() * taxRate;
    }

    public String getTaxDetails() {
        return "Tax Rate: " + taxRate * 100 + "%";
    }
}

class Clothing extends Product implements Taxable {
    private double taxRate;
    private double discountRate;

    public Clothing(int id, String name, double price, double taxRate, double discountRate) {
        super(id, name, price);
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    public double calculateTax() {
        return getPrice() * taxRate;
    }

    public String getTaxDetails() {
        return "Tax Rate: " + taxRate * 100 + "%";
    }
}

class Groceries extends Product {
    private double discountRate;

    public Groceries(int id, String name, double price, double discountRate) {
        super(id, name, price);
        this.discountRate = discountRate;
    }

    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(1, "Laptop", 800, 0.15, 0.10));
        products.add(new Clothing(2, "Shirt", 50, 0.05, 0.20));
        products.add(new Groceries(3, "Apples", 10, 0.05));

        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + " | Price: " + p.getPrice() + " | Tax: " + tax + " | Discount: " + discount + " | Final: " + finalPrice);
        }
    }
}
