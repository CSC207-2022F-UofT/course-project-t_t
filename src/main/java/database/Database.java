package database;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private static ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        db.add(new User( "Kim", "cydfk123"));
        return db;
    }

    public static void addUser(String username, String password) {
        db.add(new User(username, password));
    }

    public static User getUser(String username) {
        ArrayList<User> db = getDatabase();
        for (User user : db) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

//    public static User getFriend(User student1, String username) {
//        ArrayList<User> friends = student1.getFriends();
//        for (User friend : friends) {
//            if (Objects.equals(friend.getUsername(), username)) {
//                return friend;
//            }
//        }
//        return student1;
//    }
}