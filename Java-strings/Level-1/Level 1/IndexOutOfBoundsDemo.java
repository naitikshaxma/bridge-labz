import java.util.Scanner;

public class IndexOutOfBoundsDemo {
    public static void generateException() {
        String text = "hello";
        text.charAt(10);
    }

    public static void demonstrateException() {
        String text = "hello";
        try {
            text.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
        }
    }

    public static void main(String[] args) {
        generateException();
        demonstrateException();
    }
}
