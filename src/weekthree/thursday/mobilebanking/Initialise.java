package weekthree.thursday.mobilebanking;

import java.util.ArrayList;

public class Initialise {
    public Initialise(ArrayList<User> users){
        seedData(users);
    }

    private void seedData(ArrayList<User> users){
        users.add(new User("robby1110", "Password1", "Robert", "Watkin",  new ArrayList()));
        users.add(new User("Amanda Rae", "amxnda", "Robert", "Watkin",  new ArrayList()));
        users.add(new User("potatoman", "shoeLace", "Robert", "Watkin",  new ArrayList()));
        users.add(new User("afganDan", "radge", "Robert", "Watkin",  new ArrayList()));
    }
}
