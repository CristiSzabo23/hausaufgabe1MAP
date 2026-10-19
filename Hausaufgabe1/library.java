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

}
