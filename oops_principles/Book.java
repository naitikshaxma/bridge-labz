import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showLibraryBooks() {
        System.out.println("Library: " + name);
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(" - " + b);
            }
        }
        System.out.println("-----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");

        Library cityLibrary = new Library("City Library");
        Library collegeLibrary = new Library("College Library");

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);
        collegeLibrary.addBook(b2);
        collegeLibrary.addBook(b3);

        cityLibrary.showLibraryBooks();
        collegeLibrary.showLibraryBooks();
    }
}
