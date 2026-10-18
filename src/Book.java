public class Book {
    private String titel;
    private String autor;
    private double preis;
    private int pages;

    public Book(String titel,String autor,double preis,int pages){
        this.titel=titel;
        this.autor=autor;
        this.preis=preis;
        this.pages=pages;
    }

    @Override
    public String toString(){
        return titel + " ( "+autor + " , "+ preis+" Euro, "+pages + " Seiten ) ";
    }
}
