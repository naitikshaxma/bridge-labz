import java.util.ArrayList;
import java.util.List;

abstract class Vehicle2 {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId +
                           " | Driver: " + driverName +
                           " | Rate per km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
        this.currentLocation = "Garage";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
        this.currentLocation = "Stand";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
        this.currentLocation = "Depot";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; // small base charge
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

public class Main {
    public static void calculateFares(List<Vehicle> rides, double distance) {
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            double fare = v.calculateFare(distance);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: " + fare);

            if (v instanceof GPS gps) {
                System.out.println("Current Location: " + gps.getCurrentLocation());
            }
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        Car car = new Car("C101", "Alice", 12);
        Bike bike = new Bike("B202", "Bob", 8);
        Auto auto = new Auto("A303", "Charlie", 10);

        car.updateLocation("Downtown");
        bike.updateLocation("Mall");
        auto.updateLocation("Station");

        rides.add(car);
        rides.add(bike);
        rides.add(auto);

        calculateFares(rides, 15);
    }
}
