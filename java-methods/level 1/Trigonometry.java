import java.util.Scanner;

public class Trigonometry {
    public static double[] calculateTrig(double angle) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Trigonometric Calculator 📐 ===");
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        double[] result = calculateTrig(angle);

        System.out.println("\nFor angle " + angle + "°:");
        System.out.println("👉 sin(" + angle + ") = " + result[0]);
        System.out.println("👉 cos(" + angle + ") = " + result[1]);
        System.out.println("👉 tan(" + angle + ") = " + result[2]);
    }
}
