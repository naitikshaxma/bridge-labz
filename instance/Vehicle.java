public class Vehicle {
    static double registrationFee = 500.0;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "REG001");
        Vehicle v2 = new Vehicle("Bob", "Bike", "REG002");

        if (v1 instanceof Vehicle) v1.displayDetails();
        if (v2 instanceof Vehicle) v2.displayDetails();

        Vehicle.updateRegistrationFee(600);
        System.out.println("Updated Fee: " + Vehicle.registrationFee);
    }
}
