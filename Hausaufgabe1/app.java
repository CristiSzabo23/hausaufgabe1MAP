import java.util.ArrayList;
import java.util.List;

public class app {

    public void run() {
        Library library = new Library();

        Book b1 = new Book("Clean Code", "Robert Martin", 45, 464);
        Book b2 = new Book("1984", "George Orwell", 18, 328);
        Book b3 = new Book("Animal Farm", "George Orwell", 12, 112);
        Book b4 = new Book("Java Basics", "Max Müller", 35, 520);
        Book b5 = new Book("The Hobbit", "J. R. R. Tolkien", 28, 310);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        List<Book> allBooks = new ArrayList<>();
        allBooks.add(b1);
        allBooks.add(b2);
        allBooks.add(b3);
        allBooks.add(b4);
        allBooks.add(b5);

        System.out.println("Autor: George Orwell");
        List<Book> orwellBooks = library.getBooksbyAuthor("George Orwell");
        for (int i = 0; i < orwellBooks.size(); i++) {
            System.out.println(" | " + orwellBooks.get(i).getTitel());
        }

        System.out.println("\nDurchschnittliche Seitenanzahl:");
        List<Book> testMedia = new ArrayList<>();
        testMedia.add(b1);
        testMedia.add(b2);
        testMedia.add(b3);
        System.out.println(library.getAveragePageCount(testMedia));