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
