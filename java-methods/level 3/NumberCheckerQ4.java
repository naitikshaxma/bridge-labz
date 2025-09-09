import java.util.Arrays;

public class NumberCheckerQ4 {

    static int countDigits(int num) {
        return String.valueOf(Math.abs(num)).length();
    }

    static int[] getDigits(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    static boolean compareArrays(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        int[] rev = reverseArray(digits);
        return compareArrays(digits, rev);
    }

    static boolean isDuck(int num) {
        String s = String.valueOf(num);
        return s.contains("0") && s.charAt(0) != '0';
