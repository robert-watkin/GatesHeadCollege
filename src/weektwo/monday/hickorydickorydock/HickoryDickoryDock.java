package weektwo.monday.hickorydickorydock;

public class HickoryDickoryDock {

    // variable declaration
    String time;
    String changingLyricMain;
    String finalLyricChange;
    // end of variable declaration

    public static void main(String[] args) {
        HickoryDickoryDock song = new HickoryDickoryDock();

        // for loop loops the duration of the song - 1
        for (int x = 1; x <= 8; x++){
            song.setTimeAndLyric(x);
            song.verse();
        }
       // song.finalVerse(); // prints the final verse of the song
    }

    private void setTimeAndLyric(int x){

        // switch statement determines the lyrics of upcoming verses in the song based on the verse number
        switch (x){
            case 1:
                time = "one";
                changingLyricMain = "The mouse went down";
                finalLyricChange = "The clock struck ";
                break;
            case 2:
                time = "two";
                break;
            case 3:
                time = "three";
                changingLyricMain = "The jerry free";
                break;
            case 4:
                time = "four";
                changingLyricMain = "He hit the floor";
                break;
            case 5:
                time = "five";
                changingLyricMain = "The mouse could die";
                break;
            case 6:
                time = "six";
                changingLyricMain = "The mouse he split";
                break;
            case 7:
                time = "seven,";
                changingLyricMain = "eight, nine, ten & eleven";
                break;
            case 8:
                finalLyricChange = "As Twelve Bell rang, ";
                changingLyricMain = "The mouse he sprang";
                time = "";
                break;
            default:
                System.out.println("number out of bounds");
        }
    }

    // verse loops
    private void verse(){
        System.out.println("Hickory Dickory Dock");
        System.out.println("The mouse ran up the clock");
        System.out.println(finalLyricChange + time);
        System.out.println(changingLyricMain);
        System.out.println("Hickory Dickory Dock!");
        System.out.println();
    }
}
