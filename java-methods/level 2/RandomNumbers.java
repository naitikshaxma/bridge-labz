import java.util.Random;

public class RandomNumbers {


    public static int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + rand.nextInt(9000); 
        }
        return arr;
    }


    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;

        for (int num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
            sum += num;
        }

        double avg = (double) sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);

        System.out.print("Generated numbers: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        double[] result = findAverageMinMax(arr);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", result[0], result[1], result[2]);
    }
}
