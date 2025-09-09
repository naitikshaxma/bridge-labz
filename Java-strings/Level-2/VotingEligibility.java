import java.util.Scanner;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }

    public static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                result[i][0] = "Invalid";
                result[i][1] = "False";
            } else if (ages[i] >= 18) {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "True";
            } else {
                result[i][0] = String.valueOf(ages[i]);
                result[i][1] = "False";
            }
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-10s%n", "Age", "Can Vote?");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = scan.nextInt();

        int[] ages = generateAges(n);
        String[][] votingStatus = canVote(ages);
        displayTable(votingStatus);
    }
}
