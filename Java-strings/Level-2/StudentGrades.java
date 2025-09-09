import java.util.Scanner;

public class StudentGrades {
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int)(Math.random() * 90) + 10;
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return stats;
    }

    public static char[] calculateGrade(double[] percentages) {
        char[] grades = new char[percentages.length];
        for (int i = 0; i < percentages.length; i++) {
            if (percentages[i] >= 80) grades[i] = 'A';
            else if (percentages[i] >= 70) grades[i] = 'B';
            else if (percentages[i] >= 60) grades[i] = 'C';
            else if (percentages[i] >= 50) grades[i] = 'D';
            else if (percentages[i] >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] stats, char[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                          "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10.2f %-10.2f %-10c%n",
                              "S" + (i+1),
                              scores[i][0],
                              scores[i][1],
                              scores[i][2],
                              stats[i][0],
                              stats[i][1],
                              grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = scan.nextInt();

        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        char[] grades = calculateGrade(new double[n]);

        for (int i = 0; i < n; i++) {
            grades[i] = calculateGrade(new double[]{stats[i][2]})[0];
        }

        displayScorecard(scores, stats, grades);
    }
}
