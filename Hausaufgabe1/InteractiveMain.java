import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteractiveMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book("Clean Code", "Robert Martin", 45, 464));
        allBooks.add(new Book("1984", "George Orwell", 18, 328));
        allBooks.add(new Book("Animal Farm", "George Orwell", 12, 112));
        allBooks.add(new Book("Java Basics", "Max Müller", 35, 520));
        allBooks.add(new Book("The Hobbit", "J. R. R. Tolkien", 28, 310));
        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 35, 523));

        for (int i = 0; i < allBooks.size(); i++) {
            library.addBook(allBooks.get(i));
        }

        System.out.println("\nEXERCISE 1");
        System.out.print("Author: ");
        String author = scanner.nextLine();
        List<Book> authorBooks = library.getBooksbyAuthor(author);
        printBooks(authorBooks);

        System.out.println("\nEXERCISE 2");
        System.out.println("ENTER THE BOOK TITLES (press Enter on empty line to stop): ");
        List<Book> selectedBooksForAvg = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            Book found = findBookByTitle(allBooks, line);
            if (found != null) {
                selectedBooksForAvg.add(found);
            } else {
                System.out.println("Cartea nu exista în sistem.");
            }
        }
        System.out.println("Average pages: " + library.getAveragePageCount(selectedBooksForAvg));

        System.out.println("\nEXERCISE 3");
        System.out.print("Maximaler Preis: ");
        int preis = scanner.nextInt();
        scanner.nextLine();
        List<Book> priceBooks = library.getBooksWithinPriceLimit(allBooks, preis);
        printBooks(priceBooks);

        System.out.println("\nEXERCISE 4");
        System.out.println("ENTER THE BOOK TITLES (press Enter on empty line to stop): ");
        List<Book> selectedBooksForExpensive = new ArrayList<>();
        while (true) {
            String line2 = scanner.nextLine();
            if (line2.isEmpty()) {
                break;
            }
            Book found = findBookByTitle(allBooks, line2);
            if (found != null) {
                selectedBooksForExpensive.add(found);
            }
        }

        Book mostExpensiveBook = library.getMostExpensiveBook(selectedBooksForExpensive);
        if (mostExpensiveBook != null) {
            System.out.println(mostExpensiveBook.getTitel() + " (" + mostExpensiveBook.getPreis() + " Euro)");
        } else {
            System.out.println("Nicio carte gasita.");
        }

        System.out.println("\nEXERCISE 5");
        System.out.print("Minimal Number of Pages: ");
        int minimumNrPages = scanner.nextInt();
        scanner.nextLine();
        List<Book> pagesBooks = library.getBooksWithMinimumPages(allBooks, minimumNrPages);
        printBooks(pagesBooks);

        System.out.println("\nEXERCISE 6");
        System.out.print("Budget: ");
        int budget = scanner.nextInt();
        scanner.nextLine();
        Book[] pair = library.getTwoBooksWithinBudget(allBooks, budget);
        if (pair.length == 2 && pair[0] != null) {
            System.out.println(pair[0].getTitel() + " + " + pair[1].getTitel());
            System.out.println("Gesamtpreis: " + (pair[0].getPreis() + pair[1].getPreis()) + " Euro");
        } else {
            System.out.println("Nu s-a gasit nicio pereche in acest buget.");
        }

        scanner.close();
    }

    private static void printBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Nu s-au gasit carti.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println(" | " + books.get(i).getTitel());
        }
    }

    private static Book findBookByTitle(List<Book> books, String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitel().equals(title)) {
                return books.get(i);
            }
        }
        return null;
    }
}