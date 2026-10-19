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

    public String getTitel(){
        return titel;}
    public String getAutor(){
        return autor;
    }
    public double getPreis(){
        return preis;
    }
    public int getPages(){
        return pages;
    }


    @Override
    public String toString(){
        return titel + " ( "+autor + " , "+ preis+" Euro, "+pages + " Seiten ) ";
    }
}
