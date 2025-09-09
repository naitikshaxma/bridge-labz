import java.util.*;

public class FactorsProgram {
    
    // Method to find factors of a number and return as array
    public static int[] findFactors(int num) {
        List<Integer> factorsList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factorsList.add(i);
            }
        }
        return factorsList.stream().mapToInt(i -> i).toArray();
    }

    // Method to find sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    // Method to find product of factors
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    // Method to find sum of squares of factors
    public static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += Math.pow(f, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquares(factors));
    }
}
