import java.util.Scanner;

public class RockPaperScissors {
    public static String computerChoice() {
        int choice = (int)(Math.random() * 3);
        return choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors";
    }

    public static String determineWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper"))) {
            return "User Wins";
        }
        return "Computer Wins";
    }

    public static String[][] getStats(int userWins, int compWins, int draws) {
        double userPercent = (double)userWins / (userWins + compWins + draws) * 100;
        double compPercent = (double)compWins / (userWins + compWins + draws) * 100;
        return new String[][]{
            {"User Wins", String.valueOf(userWins), String.format("%.2f", userPercent)},
            {"Computer Wins", String.valueOf(compWins), String.format("%.2f", compPercent)},
            {"Draws", String.valueOf(draws), "0.00"}
        };
    }

    public static void displayResults(String[][] stats) {
        System.out.printf("%-15s %-10s %-10s%n", "Result", "Count", "Percentage");
        for (String[] row : stats) {
            System.out.printf("%-15s %-10s %-10s%n", row[0], row[1], row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Number of games: ");
        int games = scan.nextInt();

        int userWins = 0, compWins = 0, draws = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Your move (rock/paper/scissors): ");
            String user = scan.next().toLowerCase();
            String comp = computerChoice();
            String result = determineWinner(user, comp);

            System.out.println("Computer: " + comp + ", Result: " + result);
            if (result.equals("User Wins")) userWins++;
            else if (result.equals("Computer Wins")) compWins++;
            else draws++;
        }

        String[][] stats = getStats(userWins, compWins, draws);
        displayResults(stats);
    }
}
