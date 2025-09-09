 import java.util.Scanner;

public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        text.charAt(0);
    }

    public static void demonstrateNullPointer() {
        String text = null;
        try {
            text.charAt(0);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }

    public static void main(String[] args) {
        generateException();
        demonstrateNullPointer();
    }
}
