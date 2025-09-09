import java.util.Scanner;

public class UniqueCharacters {
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

    public static char[] findUniqueChars(String text) {
        int len = findLength(text);
        char[] unique = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < index; j++) {
                if (unique[j] == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index++] = c;
            }
        }

        char[] result = new char[index];
        System.arraycopy(unique, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        char[] unique = findUniqueChars(text);
        System.out.println(new String(unique));
    }
}
