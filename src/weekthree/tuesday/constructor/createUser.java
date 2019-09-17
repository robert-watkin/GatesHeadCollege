package weekthree.tuesday.constructor;
import java.util.Scanner;

public class createUser {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String username, password;
        Long phonenumber;
        boolean gender;

        System.out.println("Please input a username: ");
        username = sc.nextLine();
        System.out.println("Please input a new password: ");
        password = sc.nextLine();
        System.out.println("Please input your phonenumber: ");
        phonenumber = Long.parseLong(sc.nextLine());
        System.out.println("Please input your gender (m/f) :");
        if(sc.nextLine().equalsIgnoreCase("m")){
            gender = true;
        }else{
            gender = false;
        }
        User u = new User(username, password, phonenumber, gender);
    }
}
