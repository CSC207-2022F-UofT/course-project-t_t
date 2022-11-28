package useCases;

import database.Database;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class FriendsListManager {
//    static SignIn signIn = new SignIn();
//    static FriendsListChecker friendsListChecker = new FriendsListChecker();
    static ArrayList<User> db = Database.getDatabase();
    public static void addFriends(User student1, User student2) {

        if (!student1.getFriends().contains(student2)) {
            if (Database.getDatabase().contains(student2)) {
                ArrayList<User> friends = student1.getFriends();
                friends.add(student2);
                student1.setFriends(friends);
            }
        }
    }

    public static void removeFriends(User student1, User student2) {
        if (student1.getFriends().contains(student2)) {
            ArrayList<User> friends = student1.getFriends();
            friends.remove(student2);
            student1.setFriends(friends);
        }
    }

    public void blockFriends(User student1, User student2) {
        if (student1.getFriends().contains(student2)) {
            removeFriends(student1, student2);
        }
        if (!student1.getBlocked().contains(student2)) {
            ArrayList<User> blocked = student1.getBlocked();
            blocked.add(student2);
            student1.setBlocked(blocked);
        }
    }

    public void unblockFriends(User student1, User student2) {
        if (student1.getBlocked().contains(student2)) {
            ArrayList<User> blocked = student1.getBlocked();
            blocked.remove(student2);
            student1.setBlocked(blocked);
        }
    }

//    public void starFriends(User student1, User student2) {
//        if (student1.getFriends().contains(student2)) {
//            ArrayList<User> starred = student1.getFriends();
//            starred.add(0, student2);
//            student1.setFriends(starred);
//        }
//    }
//
//    public void unstarFriends(User student1, User student2) {
//        if (student1.getFriends().contains(student2)) {
//            ArrayList<User> starred = student1.getFriends();
//            starred.remove(student2);
//            starred.add(student2);
//            student1.setFriends(starred);
//        }
//    }

    public static User getFriend(User student1, String username) {
        ArrayList<User> friends = student1.getFriends();
        for (User friend : friends) {
            if (Objects.equals(friend.getUsername(), username)) {
                return friend;
            }
        }
        return student1;
    }

    public boolean checkUsername(ArrayList<User> db1, String username1) {
        for (int i = 0; i < db1.size(); i++) {
            if (username1.equals(db1.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }
}
