import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> allBooks;

    public Library() {
        this.allBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.allBooks.add(book);
    }

    public List<Book> getBooksbyAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (book.getAutor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public double getAveragePageCount(List<Book> books) {
        if (books == null || books.isEmpty()) return 0;

        double totalPages = 0;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            totalPages += book.getPages();
        }
        return totalPages / books.size();
    }

    public List<Book> getBooksWithinPriceLimit(List<Book> books, double maxPrice) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getPreis() <= maxPrice) {
                result.add(book);
            }
        }
        return result;
    }

    public Book getMostExpensiveBook(List<Book> books) {
        if (books == null || books.isEmpty())
            return null;
        Book mostExpensive = books.get(0);
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getPreis() > mostExpensive.getPreis()) {
                mostExpensive = book;
            }
        }
        return mostExpensive;
    }

    public List<Book> getBooksWithMinimumPages(List<Book> books, int minPages) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getPages() >= minPages) {
                result.add(book);
            }
        }
        return result;
    }

    public Book[] getTwoBooksWithinBudget(List<Book> books, double budget) {
        Book[] bestPair = new Book[2];
        double maxPriceFound = -1;
        int maxPagesFound = -1;

        for (int i = 0; i < books.size(); i++) {
            for (int j = i + 1; j < books.size(); j++) {
                Book book1 = books.get(i);
                Book book2 = books.get(j);

                double currentPrice = book1.getPreis() + book2.getPreis();
                int currentPages = book1.getPages() + book2.getPages();

                if (currentPrice <= budget) {

                    if (currentPrice > maxPriceFound || (currentPrice == maxPriceFound && currentPages > maxPagesFound)) {
                        maxPriceFound = currentPrice;
                        maxPagesFound = currentPages;
                        bestPair[0] = book1;
                        bestPair[1] = book2;
                    }
                }
            }
        }

        if (bestPair[0] == null) {
            return new Book[0];
        }
        return bestPair;
    }
}