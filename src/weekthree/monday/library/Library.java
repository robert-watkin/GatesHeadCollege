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

        members[0] = new Member(1,"Dean","Lewis", (byte) 31);
        members[1] = new Member(2,"Steve","Beckwith", (byte) 55);
        members[2] = new Member(3,"Lisa", "Crow", (byte) 39);
        members[3] = new Member(4,"Robert", "Watkin", (byte) 37);
        members[4] = new Member(5, "Amanda", "Rae", (byte) 25);

        loans[0] = new Loan(2,4);
        loans[1] = new Loan(5,2);

        menu();
    }

    private void menu(){
        System.out.println("Welcome to Roberts library");
        System.out.println("Please select an option from the list below");
        System.out.println("1 - Search for a book now");
        System.out.println("2 - Check if a book is available");
        System.out.println("3 - Search for books by an author");
        byte choice = Byte.parseByte(sc.nextLine());
        handleChoice(choice);
    }

    private void handleChoice(byte choice) {
        switch (choice){
            case 1:
                searchBook();
                break;
            case 2:
                checkBook();
                break;
            case 3:
                searchAuthor();
                break;
            default:
                System.out.println("Invalid input provided, please try again");
                menu();
        }
    }

    private void searchAuthor() {
    }

    private void checkBook() {
    }

    private void searchBook() {
        System.out.println("What is the name of the book you would like to search for?");
        String title = sc.nextLine();

        for(int i = 0; i < books.length; i++){
            if (books[i].bookTitle.equalsIgnoreCase(title)){
                System.out.println("We stock that book in the library");
                System.out.println("Return to the main menu to check if it is available");
                menu();
            }
            else if(i == books.length - 1){
                System.out.println("Sorry we do not currently stock");
                System.out.println();
                menu();
            }
        }
    }
}
