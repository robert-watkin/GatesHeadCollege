package weekthree.wednesday.library;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {
        Library lib = new Library();
        lib.initialise();
        lib.menu();
    }

    private void initialise(){
        books.add(new Book(1, "In search of lost time", "Marcel Prouset", "1913", false));
        books.add(new Book(2, "Ulysses", "James Joyce","1922", false));
        books.add(new Book(3, "Moby Dick", "Herman Melville","1851", false));
        books.add(new Book(4,"Pride and Prejudice", "Jane Austen", "1813", false));
        books.add(new Book(5,"The Canterbury Tales", "Geoffrey Chauer", "1387", false));

        members.add(new Member(1,"Dean","Lewis", (byte) 31));
        members.add(new Member(2,"Steve","Beckwith", (byte) 55));
        members.add(new Member(3,"Lisa", "Crow", (byte) 39));
        members.add(new Member(4,"Robert", "Watkin", (byte) 37));
        members.add(new Member(5, "Amanda", "Rae", (byte) 25));

        loans.add(new Loan(2,4, 16,9,2019));
        loans.add(new Loan(5,2,12,9,2019));

        menu();
    }

    private void menu(){
        System.out.println("-------------------------------");
        System.out.println("Welcome to Roberts library");
        System.out.println("Please select an option from the list below");
        System.out.println("1 - Search for a book now");
        System.out.println("2 - Check if a book is available");
        System.out.println("3 - Search for books by an author");
        System.out.println("-------------------------------");
        byte choice = Byte.parseByte(sc.nextLine());
        handleChoice(choice);

    }

    private void handleChoice(byte choice) {
        System.out.println();
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

    private void checkBook() {
        System.out.println("What is the title of the book you would like to check for?");
        String title = sc.nextLine();
        int counter = 1;

        for(Book b : books){
            if(b.bookTitle.equalsIgnoreCase(title)){
                for (Loan l : loans){
                    if (l.bookID == b.bookID){
                        System.out.println("Sorry that book is currently unavailable");
                        menu();
                    }
                    else if( counter == loans.size()){
                        System.out.println("This book is available");
                        menu();
                    }
                }
            }
        }
    }

    private void searchAuthor() {
        System.out.println("What is the bane if the author you would like to search for?");
        String author = sc.nextLine();
        int counter = 1;
        boolean hasBooks = false;

        for (Book b : books){
            if (b.bookAuthor.equalsIgnoreCase(author)){
                System.out.println(b.bookTitle + " by " + author);
                hasBooks = true;
            }
            else if (counter == books.size() && !hasBooks){
                System.out.println("Sorry, we do not currently stock any books by that author");
                System.out.println();
            }
            counter++;
        }
        System.out.println();
        menu();
    }

    private void searchBook(){
        System.out.println("What is the name of the book you would like to search for?");
        String title = sc.nextLine();
        int counter = 1;

        for(Book b : books){
            if(b.bookTitle.equalsIgnoreCase(title)){
                System.out.println("We stock that book in the library");
                System.out.println("Return to the main menu to check if it is available");
                menu();
            }
            else if(counter == books.size()){
                System.out.println("Sorry, we do not currently stock that book");
                System.out.println();
                menu();
            }
            counter++;
        }
    }
}
