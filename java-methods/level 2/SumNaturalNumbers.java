import java.util.*;

public class SumNaturalNumbers {

    // Recursive method
    public static int recursiveSum(int n) {
        if (n == 0) return 0;
        return n + recursiveSum(n - 1);
    }

    // Formula method
    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        int sumRecursive = recursiveSum(n);
        int sumFormula = formulaSum(n);

        System.out.println("Recursive Sum = " + sumRecursive);
        System.out.println("Formula Sum = " + sumFormula);
        System.out.println("Both are equal? " + (sumRecursive == sumFormula));
    }
}
