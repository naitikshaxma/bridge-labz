public class NumberCheckerQ3 {

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

    public static void main(String[] args) {
        int num = 12345;

        System.out.println("Digit count: " + countDigits(num));
        int[] digits = getDigits(num);

        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
    }
}
