import java.util.Random;

public class FootballTeamHeights {

    static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) total += n;
        return total;
    }

    static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int n : arr) if (n < min) min = n;
        return min;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250
        }

        System.out.print("Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();

        System.out.println("Shortest: " + min(heights) + " cm");
        System.out.println("Tallest: " + max(heights) + " cm");
        System.out.println("Mean Height: " + mean(heights) + " cm");
    }
}
