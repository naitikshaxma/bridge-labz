import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void generateException() {
        String text = "abc";
        Integer.parseInt(text);
    }

    public static void demonstrateException() {
        String text = "abc";
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        }
    }

    public static void main(String[] args) {
        generateException();
        demonstrateException();
    }
}
