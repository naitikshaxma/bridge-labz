import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        double yards = feet / 3.0;
        double miles = yards / 1760.0;

        System.out.println("The distance " + feet + " feet is " + yards + " yards and " + miles + " miles");
    }
}
