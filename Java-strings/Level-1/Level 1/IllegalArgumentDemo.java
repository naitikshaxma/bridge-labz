import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException() {
        String text = "hello";
        text.substring(5, 3);
    }

    public static void demonstrateException() {
        String text = "hello";
        try {
            text.substring(5, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException");
        }
    }

    public static void main(String[] args) {
        generateException();
        demonstrateException();
    }
}
