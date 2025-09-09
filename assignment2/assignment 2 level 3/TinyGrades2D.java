import java.util.Scanner;

public class TinyGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // 0:Phy, 1:Chem, 2:Math
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            for (int s = 0; s < 3; s++) {
                System.out.print("Student " + (i+1) + " mark " + (s+1) + " (0-100): ");
                double m = sc.nextDouble();
                while (m < 0 || m > 100) {
                    System.out.print("  0-100 only: ");
                    m = sc.nextDouble();
                }
                marks[i][s] = m;
            }
            double avg = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grade[i] = (avg >= 80) ? "A" : (avg >= 70) ? "B" : (avg >= 60) ? "C" : (avg >= 50) ? "D" : (avg >= 40) ? "E" : "R";
        }

        System.out.println("Results:");
        System.out.println("Student  Phy  Chem  Math  Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("S%-7d %-5.1f %-5.1f %-5.1f %-5s%n",
                    i+1, marks[i][0], marks[i][1], marks[i][2], grade[i]);
        }

        sc.close();
    }
}
