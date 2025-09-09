import java.util.Scanner;

public class TriangularPark {
    public static int calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        return (int)Math.ceil(distance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of triangle: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        int rounds = calculateRounds(a, b, c, 5000); // 5 km = 5000 m
        System.out.println("Athlete must complete " + rounds + " rounds.");
    }
}
