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

    public List<Book> getBooksbyAuthor(){
        List<Book> result=new ArrayList<>();
        for(i=0;i<allBooks.size();i++){
            Book book=allBooks.get(i);
            if(book.getAutor().equals(author)){
                result.add(book);
            }
        }
    }
}
