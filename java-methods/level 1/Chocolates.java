import java.util.Scanner;

public class Chocolates {
    public static int[] divideChocolates(int chocolates, int children) {
        int eachChild = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{eachChild, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Chocolate Distribution 🍫 ===");
        System.out.print("Enter total number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = divideChocolates(chocolates, children);

        System.out.println("\nEach child will get " + result[0] + " chocolates.");
        System.out.println("Leftover chocolates: " + result[1]);
    }
}

