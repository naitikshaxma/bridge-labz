import java.util.Scanner;

public class VowelConsonantDisplay {
    public static String checkChar(char c) {
        char lower = Character.toLowerCase(c);
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            return "Vowel";
        }
        if (lower >= 'a' && lower <= 'z') {
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyzeText(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            result[i][0] = String.valueOf(c);
            result[i][1] = checkChar(c);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        String[][] analysis = analyzeText(text);
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        for (String[] row : analysis) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }
}
