/*
The initialise class is used to populate
data required throughout this program.
This class is only necessary for the testing
of this application, actual banking apps would
make use of databases to store the data which
the other classes would pull from.
 */
package weekthree.thursday.mobilebanking;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Initialise {

    // seed data function used to fill the users arraylist with data - for testing
    public ArrayList<User> seedData() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("robby1110", "Password1", "Robert", "Watkin", new ArrayList()));
        users.add(new User("Amanda Rae", "amxnda", "Amanda", "Rae", new ArrayList()));
        users.add(new User("potatoman", "shoeLace", "Robert", "Watkin", new ArrayList()));
        users.add(new User("afganDan", "radge", "Robert", "Watkin", new ArrayList()));

        return users;
    }
}
