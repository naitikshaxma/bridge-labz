public class NumberCheckerQ2 {

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

    static boolean isDuck(int num) {
        String s = String.valueOf(num);
        return s.contains("0") && s.charAt(0) != '0';
    }

    static boolean isArmstrong(int num) {
        int[] digits = getDigits(num);
        int n = digits.length;
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, n);
        return sum == num;
    }

    static int[] largestTwo(int[] digits) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
