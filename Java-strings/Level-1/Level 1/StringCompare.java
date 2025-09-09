import java.util.Scanner;

public class StringCompare {
    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scan.next();
        System.out.print("Enter second string: ");
        String str2 = scan.next();

        boolean customResult = compareStrings(str1, str2);
        boolean builtInResult = str1.equals(str2);

        System.out.println(customResult == builtInResult);
    }
}
