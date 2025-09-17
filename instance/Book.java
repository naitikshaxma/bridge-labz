public class Book {
    static String libraryName = "OpenAI Central Library";
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "John Doe", "ISBN001");
        Book b2 = new Book("Python Guide", "Jane Smith", "ISBN002");

        Book.displayLibraryName();

        if (b1 instanceof Book) b1.displayDetails();
        if (b2 instanceof Book) b2.displayDetails();
    }
}
