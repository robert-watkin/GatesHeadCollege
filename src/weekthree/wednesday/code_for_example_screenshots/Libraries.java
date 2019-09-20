package weekthree.wednesday.code_for_example_screenshots;
import java.util.Scanner;           // <====== Library for scanner imported

public class Libraries {
    Scanner sc = new Scanner(System.in); // Scanner object created

    public static void main(String[] args) {
        Libraries lib = new Libraries();
        String userInput = lib.sc.nextLine(); // Use of Scanner object
    }
}
