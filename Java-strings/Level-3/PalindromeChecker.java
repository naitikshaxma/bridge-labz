import java.util.Scanner;

public class PalindromeChecker {
    public static boolean checkPalindromeLogic1(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkPalindromeLogic2(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return checkPalindromeLogic2(text, start + 1, end - 1);
    }

    public static boolean checkPalindromeLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        int j = 0;
        for (int i = original.length - 1; i >= 0; i--) {
            reversed[j++] = original[i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        System.out.println(checkPalindromeLogic1(text));
        System.out.println(checkPalindromeLogic2(text, 0, text.length() - 1));
        System.out.println(checkPalindromeLogic3(text));
    }
}
