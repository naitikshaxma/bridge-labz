import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI
    static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100; // convert cm → m
        return weight / (heightM * heightM);
    }

    // Method to determine BMI status
    static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][3]; // weight, height, BMI
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            double weight = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            double height = sc.nextDouble();

            double bmi = calculateBMI(weight, height);
            persons[i][0] = weight;
            persons[i][1] = height;
            persons[i][2] = bmi;

            status[i] = getBMIStatus(bmi);
        }

        System.out.println("\nWeight | Height | BMI | Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f kg | %.2f cm | %.2f | %s\n",
                    persons[i][0], persons[i][1], persons[i][2], status[i]);
        }
    }
}
