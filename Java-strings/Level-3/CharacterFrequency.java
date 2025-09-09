import java.util.Scanner;

public class CharacterFrequency {
    public static char[][] getFrequency(String text) {
        int[] freq = new int[256];
        int len = text.length();

        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        char[][] result = new char[256][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = (char)i;
                result[index][1] = (char)(freq[i] + '0');
                index++;
            }
        }

        char[][] finalResult = new char[index][2];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
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
