import java.util.*;

public class FriendsCheck {

    public static int youngest(int[] ages) {
        int min = ages[0];
        for (int age : ages) if (age < min) min = age;
        return min;
    }

    public static int tallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }

        int minAge = youngest(ages);
        int maxHeight = tallest(heights);

        for (int i = 0; i < 3; i++) {
            if (ages[i] == minAge) System.out.println("Youngest: " + names[i] + " (Age " + ages[i] + ")");
            if (heights[i] == maxHeight) System.out.println("Tallest: " + names[i] + " (Height " + heights[i] + ")");
        }
    }
}
