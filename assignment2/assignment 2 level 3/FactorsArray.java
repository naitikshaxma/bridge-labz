import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int size = 10, index = 0;
        int[] factors = new int[size];

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == size) { // resize
                    size *= 2;
                    int[] temp = new int[size];
                    for (int j = 0; j < factors.length; j++) temp[j] = factors[j];
                    factors = temp;
                }
                factors[index++] = i;
            }
        }

        System.out.print("Factors: ");
        for (int i = 0; i < index; i++) System.out.print(factors[i] + " ");
    }
}
