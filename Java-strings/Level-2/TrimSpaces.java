import java.util.Scanner;

public class TrimSpaces {
    public static int[] trimSpaces(String text) {
        int start = 0, end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String substring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        int[] bounds = trimSpaces(text);
        String trimmed = substring(text, bounds[0], bounds[1]);
        String builtInTrimmed = text.trim();

        System.out.println(compareStrings(trimmed, builtInTrimmed));
    }
}
