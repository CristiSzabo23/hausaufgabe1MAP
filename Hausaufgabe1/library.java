import java.util.ArrayList;
import java.util.List;
public class library {
    private List<Book> allBooks;
    public library(){
        this.allBooks=new ArrayList<>();
    }
    public void addBook(Book book){
        this.allBooks.add(book);
    }

    public List<Book> getBooksbyAuthor(String author){
        List<Book> result=new ArrayList<>();
        for(int i=0;i<allBooks.size();i++){
            Book book=allBooks.get(i);
            if(book.getAutor().equals(author)){
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
}
public List<Book> getBooksWithinPriceLimit(List<Book> books, double maxPrice) {
    List<Book> result = new ArrayList<>();
    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        if (book.getPreis() <= maxPrice) {
            result.add(book);
        }
    }
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