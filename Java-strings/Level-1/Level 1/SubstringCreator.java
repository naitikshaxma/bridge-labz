import java.util.Scanner;

public class SubstringCreator {
    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareSubstrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.next();
        System.out.print("Start index: ");
        int start = scan.nextInt();
        System.out.print("End index: ");
        int end = scan.nextInt();

        String customSub = createSubstring(text, start, end);
        String builtInSub = text.substring(start, end);

        boolean same = compareSubstrings(customSub, builtInSub);
        System.out.println(same);
    }
}
