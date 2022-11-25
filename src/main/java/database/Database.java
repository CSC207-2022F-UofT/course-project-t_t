package database;
import entities.User;

import java.util.ArrayList;

public class Database {

    public static ArrayList<User> getDatabase() {

        ArrayList<User> dummyDB = new ArrayList<>();
        dummyDB.add(new User( "Kim", "cydfk123"));
        return dummyDB;
    }

}