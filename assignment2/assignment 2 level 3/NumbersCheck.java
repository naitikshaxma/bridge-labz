import java.util.Scanner;

public class NumbersCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            nums[i] = sc.nextInt();

            if (nums[i] > 0) {
                System.out.println(nums[i] + (nums[i] % 2 == 0 ? " is Positive and Even" : " is Positive and Odd"));
            } else if (nums[i] < 0) {
                System.out.println(nums[i] + " is Negative");
            } else {
                System.out.println("Number is Zero");
            }
        }

        if (nums[0] == nums[4])
            System.out.println("First and Last are Equal");
        else if (nums[0] > nums[4])
            System.out.println("First is Greater");
        else
            System.out.println("First is Less");
    }
}

