package weekone.friday.animals;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateAnimals {

    ArrayList<Dog> dogs = new ArrayList<>();
    ArrayList<Cat> cats = new ArrayList<>();

    public static void main(String[] args) {
        CreateAnimals anim = new CreateAnimals();
        anim.getAnimalType();
    }
    /*
    -----------------------------------------------------------
    Data        Variable        Assignment  Value           Terminator
    Type        Name            Operator
    -----------------------------------------------------------
    Scanner     myScanner       =           new Scanner()   ;
     */
    Scanner myScanner = new Scanner(System.in);

    private void getAnimalType(){
        System.out.println("What animal would you like to create?");
        String animal = myScanner.nextLine();
        animal = animal.toLowerCase();

        switch(animal.toLowerCase()){
            case "dog":
                createDog();
                break;
            case "cat":
                createCat();
                break;
            case "hamster":
                createHamster();
                break;
            case "fish":
                createFish();
                break;
            default:
                System.out.println(animal + "is not a type of animal we can currently create, please try again.");
        }


    }

    private void createFish() {

    }

    private void createHamster() {
    }

    private void createDog(){
        String name;
        String size;
        int age;
        String breed;

        System.out.println("What do you wish to name your dog? : ");
        name = myScanner.next();
        System.out.println("What size is your " + name + "? (small, medium, large): ");

        while (true) {
            size = myScanner.next();
            if (size.equalsIgnoreCase("small") ||
                size.equalsIgnoreCase("medium") ||
                size.equalsIgnoreCase("large")) {
                break;
            }else{
                System.out.println("Please enter either small, medium or large");
            }
        }

        System.out.println("How old is " + name + "? :");
        while (true){
            try{
                age = Integer.parseInt(myScanner.next());
                break;
            }catch(Exception e){
                System.out.println("Please enter a valid whole number!");
            }
        }
        System.out.println("What breed of dog is " + name + "? : ");
        breed = myScanner.next();

        Dog d = new Dog(name,size,age,breed);
    }

    private void createCat(){
        String name;
        String size;
        int age;

        System.out.println("What do you wish to name your cat? : ");
        name = myScanner.next();
        System.out.println("What size is " + name + "? (small, medium, large): ");

        while (true) {
            size = myScanner.next();
            if (size.equalsIgnoreCase("small") ||
                size.equalsIgnoreCase("medium") ||
                size.equalsIgnoreCase("large")) {
                break;
            }else{
                System.out.println("Please enter either small, medium or large");
            }
        }

        System.out.println("How old is " + name + "? :");
        while (true){
            try{
                age = Integer.parseInt(myScanner.next());
                break;
            }catch(Exception e){
                System.out.println("Please enter a valid whole number!");
            }
        }

        Cat c = new Cat(name, size, age, false);

        c.meow();
        c.play();
        c.stopPlaying();
        c.stopPlaying();
    }
}
