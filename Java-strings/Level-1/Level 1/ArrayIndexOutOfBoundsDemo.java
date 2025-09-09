import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException() {
        String[] names = {"Alice", "Bob"};
        // This will throw ArrayIndexOutOfBoundsException
        System.out.println("Accessing index 5: " + names[5]);
    }

    public static void demonstrateException() {
        String[] names = {"Alice", "Bob"};
        try {
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Accessing index 5: " + names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateException();
        demonstrateException();
    }
}
