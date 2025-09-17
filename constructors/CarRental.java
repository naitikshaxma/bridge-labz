\\Car Rental System: Create a CarRental class with attributes customerName, carModel, and rentalDays. Add constructors to initialize the rental details and calculate total cost.
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;
    static double ratePerDay = 50.0;

    public CarRental() {
        customerName = "";
        carModel = "";
        rentalDays = 0;
        totalCost = 0.0;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = rentalDays * ratePerDay;
    }

    public void displayRental() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + totalCost);
    }
}
