package database;
import entities.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Database {
    private static final ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        db.add(new User( "Kim", "cydfk123"));
        return db;
    }

    public static void addUser(String username, String password) {
        db.add(new User(username, password));
    }
}