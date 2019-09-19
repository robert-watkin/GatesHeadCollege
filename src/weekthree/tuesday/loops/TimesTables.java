package weekthree.tuesday.loops;
import java.util.Scanner;

public class TimesTables {
    public static void main(String[] args) {
        TimesTables tbl = new TimesTables();
        tbl.getValues();
    }

    private void getValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which times table do you want?");
        int table = Integer.parseInt(sc.nextLine());
        System.out.println("What is the maximum multiplication you want?");
        int max = Integer.parseInt(sc.nextLine());
        System.out.println("What is the start number for your table?");
        int start = Integer.parseInt(sc.nextLine());
        generateTable(table, max, start);
    }


    private void generateTable(int table, int max, int start){

        for (int x = start; x <= max; x++){
            System.out.println(x + " * " + table + " = " + (x*table));
        }



        // while loop - will not actually hit the max value specified
        /*
        while (start <= max){
            System.out.println(start + " * " + table + " = " + (start*table));
            start++;
        }
         */

        // do while loop

        do {
            System.out.println(start + " * " + table + " = " + (start*table));
            start++;
        } while(start <= max);
    }
}
