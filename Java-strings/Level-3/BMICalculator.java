import java.util.Scanner;

public class BMICalculator {
    public static void calculateBMIAndStatus(double[][] data, String[][] result) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1] / 100.0;
            double bmi = weight / (height * height);

            String status;
            if (bmi < 18.4) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 39.9) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(bmi);
            result[i][1] = status;
        }
    }

    public static void displayResult(String[][] data) {
        System.out.printf("%-10s %-10s %-10s%n", "Height", "Weight", "Status");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s%n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] personData = new double[10][2];
        String[][] results = new String[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            personData[i][0] = scan.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            personData[i][1] = scan.nextDouble();
        }

        calculateBMIAndStatus(personData, results);
        displayResult(results);
    }
}
