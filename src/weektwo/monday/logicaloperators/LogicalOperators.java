package weektwo.monday.logicaloperators;

public class LogicalOperators {
    public static void main(String[] args) {
        /*
        ==      Equal To
        !=      Not Equal To
        &&      AND
        ||      OR
        !       NOT
        <       Less Than
        >       Greater Than
        <=      Less Than Or Equal To
        >=      Greater Than or Equal To
         */

        System.out.println(3==3);   // output true
        System.out.println(3!=3);   // output false
        System.out.println((3==3) && (3==2)); // output false
        System.out.println((3==3) || (3==2)); // output true
        System.out.println(!true);  // output false
        System.out.println(3<4);    // output true
        System.out.println(3>4);    // output false



        if ((3 < 4 && 3 > 2) || (3+3) != 6){
            System.out.println("Logical operation was true");
        }
    }
}
