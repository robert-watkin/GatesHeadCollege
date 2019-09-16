package weekthree.monday.library;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    Book[] books = new Book[5];
    Member[] members = new Member[5];
    Loan[] loans = new Loan[2];

    public static void main(String[] args) {
        Library lib = new Library();
        lib.initialise();
    }

    private void initialise(){
        books[0] = new Book(1, "In search of lost time", "Marcel Prouset", "1913", false);
        books[1] = new Book(2, "Ulysses", "James Joyce","1922", false);
        books[2] = new Book(3, "Moby Dick", "Herman Melville","1851", false);
        books[3] = new Book(4,"Pride and Prejudice", "Jane Austen", "1813", false);
        books[4] = new Book(5,"The Canterbury Tales", "Geoffrey Chauer", "1387", false);

        members[0] = new Member(1,"Dean","Lewis", (byte) 31);
        members[1] = new Member(2,"Steve","Beckwith", (byte) 55);
        members[2] = new Member(3,"Lisa", "Crow", (byte) 39);
        members[3] = new Member(4,"Robert", "Watkin", (byte) 37);
        members[4] = new Member(5, "Amanda", "Rae", (byte) 25);

        loans[0] = new Loan(2,4, 16,9,2019);
        loans[1] = new Loan(5,2,12,9,2019);

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

    private void searchAuthor() {
        System.out.println("What is the name of the author you would like to search for?");
        String authorName = sc.nextLine();

        for(int i = 0; i < books.length; i++){
            if (books[i].bookAuthor.equalsIgnoreCase(authorName)){
                System.out.println("Author : " + books[i].bookAuthor + ", Book Title : " + books[i].bookTitle);
                menu();
            }
            else if(i == books.length - 1){
                System.out.println("Sorry we do not currently stock books by " + authorName);
                System.out.println();
                menu();
            }
        }
    }

    private void checkBook() {
        System.out.println("What is the name of the book you would like to check availability for?");
        String title = sc.nextLine();
        int bookID = 0;
        boolean isReserved = false;
        Book cb = new Book(0,null,null,null,false);

        for(int i = 0; i < books.length; i++){
            if (books[i].bookTitle.equalsIgnoreCase(title)){
                bookID = books[i].bookID;
                isReserved = books[i].isReserved;
                cb = books[i];
                break;
            }
            else if(i == books.length - 1){
                System.out.println("There is no book with that title in stock");
                System.out.println();
                menu();
            }
        }

        for (int x = 0; x < loans.length; x++){
            if (loans[x].bookID == bookID && !isReserved){
                System.out.println("The book (ID : " + loans[x].bookID + ") is currently unavailable");
                System.out.println("The book was taken out on : " + loans[x].loanDate);
                System.out.println("The book should be available after : " + loans[x].dueDate + " which is on a " + loans[x].dayOfTheWeek);
                menu();
            }
            else if (loans[x].bookID == bookID && isReserved) {
                System.out.println("The book (ID : " + loans[x].bookID + ") is currently unavailable");
                System.out.println("The book was taken out on : " + loans[x].loanDate);
                System.out.println("The book will be returned by : " + loans[x].dueDate + " which is on a " + loans[x].dayOfTheWeek);
                System.out.println("The book is also currently reserved for another member at currently");
                menu();
            }
            else if(x == loans.length - 1 && !isReserved){
                System.out.println("The book (ID : " + bookID + ") is available to loan");
                reserveBook(cb);
            }
        }
    }

    private void reserveBook(Book cb) {
        System.out.println("If you would like to reserve the book press '1' ");
        System.out.println("or enter anything to return to menu");
        int option = Integer.parseInt(sc.nextLine());
        if (option == 1){
            System.out.println("What is your member ID");
            int id = Integer.parseInt(sc.nextLine());
            for (int x = 0; x < members.length; x++){
                if (id == members[x].memberID){
                    members[x].reservedBooks.add(cb);
                    cb.isReserved = true;
                    System.out.println(cb.bookTitle + ", has been succesfully reserved.");
                    menu();
                }
            }
        }else{
            menu();
        }
    }

    private void searchBook() {
        System.out.println("What is the name of the book you would like to search for?");
        String title = sc.nextLine();

        for(int i = 0; i < books.length; i++){
            if (books[i].bookTitle.equalsIgnoreCase(title)){
                System.out.println("We stock that book in the library");
                System.out.println("Return to the main menu to check if it is available using its ID " + books[i].bookID);
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
