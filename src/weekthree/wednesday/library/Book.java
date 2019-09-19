package weekthree.wednesday.library;

public class Book {
    public int bookID;
    public String bookTitle;
    public String bookAuthor;
    public String bookYear;
    public boolean isReserved;

    public Book(int bookID, String bookTitle, String bookAuthor, String bookYear, boolean isReserved) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.isReserved = isReserved;
    }


}
