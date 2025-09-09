import java.util.Scanner;

public class StringLength {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = scan.next();

        int customLength = findLength(text);
        int builtInLength = text.length();

        System.out.println(customLength == builtInLength);
    }
}
