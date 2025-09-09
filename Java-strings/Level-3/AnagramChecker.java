import java.util.Scanner;

public class AnagramChecker {
    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) return false;

        int[] freq = new int[256];
        for (char c : text1.toCharArray()) {
            freq[c]++;
        }
        for (char c : text2.toCharArray()) {
            freq[c]--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = scan.nextLine();
        System.out.print("Enter second text: ");
        String text2 = scan.nextLine();

        System.out.println(areAnagrams(text1, text2));
    }
}
