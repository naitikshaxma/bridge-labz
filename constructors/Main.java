class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + author);
    }
}

class EBook extends Book {
    int fileSizeMB;

    public void displayEBook() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", File Size: " + fileSizeMB + "MB, Author: " + getAuthor());
    }
}

public class Main {
    public static void main(String[] args) {
        Book b = new Book();
        b.ISBN = "111-222";
        b.title = "Java Basics";
        b.setAuthor("Alice");
        b.display();

        EBook e = new EBook();
        e.ISBN = "333-444";
        e.title = "Advanced Java";
        e.setAuthor("Bob");
        e.fileSizeMB = 45;
        e.displayEBook();
    }
}
