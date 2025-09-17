import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate);
        this.policyNumber = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance policy: " + policyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate);
        this.policyNumber = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance policy: " + policyNumber;
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate);
        this.policyNumber = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 50;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance policy: " + policyNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("C101", 100, "CAR-12345"));
        fleet.add(new Bike("B202", 40, "BIKE-67890"));
        fleet.add(new Truck("T303", 200, "TRUCK-11223"));

        int days = 5;

        for (Vehicle v : fleet) {
            double rent = v.calculateRentalCost(days);
            double insurance = v instanceof Insurable ? ((Insurable) v).calculateInsurance() : 0;
            String insuranceInfo = v instanceof Insurable ? ((Insurable) v).getInsuranceDetails() : "No insurance";

            System.out.println(v.getType() + " [" + v.getVehicleNumber() + "]");
            System.out.println("  Rental for " + days + " days: " + rent);
            System.out.println("  Insurance: " + insurance);
            System.out.println("  " + insuranceInfo);
            System.out.println("---------------------------------");
        }
    }
}
