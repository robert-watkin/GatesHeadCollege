package weekthree.monday.library;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    Book[] books = new Book[5];
    Member[] members = new Member[5];
    Loan[] loans = new Loan[2];

    private void initialise(){
        books[0] = new Book(1, "In search of lost time", "Marcel Prouset", "1913");
        books[1] = new Book(2, "Ulysses", "James Joyce","1922");
        books[2] = new Book(3, "Moby Dick", "Herman Melville","1851");
        books[3] = new Book(4,"Pride and Prejudice", "Jane Austen", "1813");
        books[4] = new Book(5,"The Canterbury Tales", "Geoffrey Chauer", "1387");

        members[0] = new Member(1,"Dean","Lewis");
        members[1] = new Member(2,"Steve","Beckwith");
        members[2] = new Member(3,"Lisa", "Crow");
        members[3] = new Member(4,"Robert", "Watkin");
        members[4] = new Member(5, "Amanda", "Rae");

        loans[0] = new Loan(2,4);
        loans[1] = new Loan(5,2);
    }
}
