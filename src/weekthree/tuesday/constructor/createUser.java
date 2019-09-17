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
        System.out.println("Please input a new pabssword: ");
        password = sc.nextLine();
        System.out.println("Please enter your age:");
        String line = sc.nextLine();
        byte age = 0;
        if (line != null || !line.equals("")){
            age = Byte.parseByte(line);
        }
        System.out.println("Please enter your forename");
        String fn = sc.nextLine();
        System.out.println("Please enter your surname");
        String sn = sc.nextLine();
        System.out.println("Please input your phonenumber: ");
        phonenumber = Long.parseLong(sc.nextLine());
        System.out.println("Please input your gender (m/f) :");
        if(sc.nextLine().equalsIgnoreCase("m")){
            gender = true;
        }else{
            gender = false;
        }
        if (fn.equals("") && sn.equals("") && age == 0){
            User u = new User(username, password, phonenumber, gender);
        }
        else{
            User u = new User(username, password, age, fn, sn, phonenumber, gender);
        }



    }
}
