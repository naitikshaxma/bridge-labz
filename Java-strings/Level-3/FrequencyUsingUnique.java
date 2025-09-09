import java.util.Scanner;

public class FrequencyUsingUnique {
    public static char[] findUniqueChars(String text) {
        int len = text.length();
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

    public static char[][] getFrequency(String text) {
        char[] unique = findUniqueChars(text);
        char[][] result = new char[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == unique[i]) {
                    count++;
                }
            }
            result[i][0] = unique[i];
            result[i][1] = (char)(count + '0');
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        char[][] freq = getFrequency(text);
        for (char[] pair : freq) {
            System.out.println(pair[0] + " -> " + pair[1]);
        }
    }
}
