package weektwo.monday.switchstatements;

public class SwitchStatement {
    public static void main(String[] args) {
        int age = 1;

        switch (age){
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
                break;
        }

        // logical comparisons can not be done in switch statements
        // below is the equivelent if statement to switch statement

        if (age <= 3){
            System.out.println("less than or equal to three");
        }

        switch (age){
            case 0:
            case 1:
            case 2:
            case 3:
                System.out.println("less than or equal to three");
                break;
        }
    }
}
