package weekone.friday.animals;

public class Cat {
    private String name;
    private String size;
    private int age;
    private boolean isPlaying;

    public Cat(String name, String size, int age, boolean isPlaying) {
        this.name = name;
        this.size = size;
        this.age = age;
        this.isPlaying = isPlaying;
    }

    public void meow(){
        if (this.size.equalsIgnoreCase("small")){
            System.out.println("mew");
        } else if (this.size.equalsIgnoreCase("medium")) {
            System.out.println("meow");
        } else if (this.size.equalsIgnoreCase("large")){
            System.out.println("MEOOWWWW!!!");
        }
    }

    public void play(){
        if(!isPlaying){
            isPlaying = true;
            System.out.println(this.name + " is now playing");
        }
        else{
            System.out.println(this.name + " is already playing");
        }
    }

    public void stopPlaying(){
        if(isPlaying){
            isPlaying = false;
            System.out.println(this.name + " has stopped playing");
        }
        else{
            System.out.println(this.name + " is not playing anyway");
        }
    }
}
