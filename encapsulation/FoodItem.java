import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Restrict direct modification of order details
    protected void setPrice(double price) {
        this.price = price;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + " | Price: " + price + " | Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountRate;

    public VegItem(String name, double price, int qty, double discountRate) {
        super(name, price, qty);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * discountRate);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg discount: " + (discountRate * 100) + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge;
    private double discountRate;

    public NonVegItem(String name, double price, int qty, double extraCharge, double discountRate) {
        super(name, price, qty);
        this.extraCharge = extraCharge;
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraCharge) * getQuantity();
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * discountRate);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg discount: " + (discountRate * 100) + "%";
    }
}

public class Main {
    public static void processOrder(List<FoodItem> order) {
        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            double finalPrice = total;

            if (item instanceof Discountable d) {
                finalPrice = d.applyDiscount(total);
                System.out.println(d.getDiscountDetails());
            }

            System.out.println("Total Price: " + total);
            System.out.println("Final Price after discount: " + finalPrice);
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 150, 2, 0.1));
        order.add(new NonVegItem("Chicken Biryani", 200, 1, 50, 0.05));

        processOrder(order);
    }
}
