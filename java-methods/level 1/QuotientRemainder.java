import java.util.Scanner;

public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int num, int divisor) {
        int q = num / divisor;
        int r = num % divisor;
        return new int[]{q, r};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int num = sc.nextInt();
        int divisor = sc.nextInt();
        int[] result = findRemainderAndQuotient(num, divisor);
        System.out.println("Quotient = " + result[0] + ", Remainder = " + result[1]);
    }
}
