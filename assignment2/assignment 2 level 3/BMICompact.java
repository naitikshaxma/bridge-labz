import java.util.Scanner;

public class BMICompact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] w = new double[n];
        double[] h = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + " weight(kg): ");
            w[i] = sc.nextDouble();
            System.out.print("Person " + (i + 1) + " height(m): ");
            h[i] = sc.nextDouble();
            bmi[i] = w[i] / (h[i] * h[i]);
            status[i] = bmi[i] <= 18.4 ? "Underweight"
                    : bmi[i] <= 24.9 ? "Normal"
                    : bmi[i] <= 39.9 ? "Overweight" : "Obese";
        }


        System.out.println("\nResults:");
        System.out.printf("%-6s %-8s %-8s %-12s%n", "P", "Weight", "Height", "BMI (Status)");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6s %-8.2f %-8.2f %-12.2f (%s)%n",
                    "P" + (i + 1), w[i], h[i], bmi[i], status[i]);
        }

        sc.close();
    }
}