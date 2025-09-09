import java.util.Scanner;

public class ShortestLongest {
    public static String[] splitText(String text) {
        int wordCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }
        wordCount++;

        String[] words = new String[wordCount];
        int start = 0;
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = text.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = text.substring(start);

        return words;
    }

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

    public static String[][] createWordArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordArray) {
        int shortest = Integer.MAX_VALUE;
        int longest = Integer.MIN_VALUE;

        for (String[] row : wordArray) {
            int len = Integer.parseInt(row[1]);
            if (len < shortest) shortest = len;
            if (len > longest) longest = len;
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();

        String[] words = splitText(text);
        String[][] wordArray = createWordArray(words);
        int[] result = findShortestLongest(wordArray);

        System.out.println("Shortest: " + result[0]);
        System.out.println("Longest: " + result[1]);
    }
}
