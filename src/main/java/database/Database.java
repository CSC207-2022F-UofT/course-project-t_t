package database;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private static final ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        db.add(new User( "Kim", "cydfk123", new ArrayList<>(), new ArrayList<>()));
        return db;
    }

    public static void addUser(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        db.add(new User(username, password, friends, blocked));
    }

    public static User getUser(String username) {
        for (User user : db) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

}