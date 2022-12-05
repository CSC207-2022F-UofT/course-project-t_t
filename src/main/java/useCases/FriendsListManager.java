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
        if (student1.getBlocked().contains(student2)) {
            System.out.println("This user is blocked.");
        }
        if (student2.getBlocked().contains(student1)) {
            System.out.println("You do not have permission to add this user.");
        }
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


    public static void blockFriends(User student1, User student2) {
        if (student1.getFriends().contains(student2)) {
            removeFriends(student1, student2);
        }
        if (!student1.getBlocked().contains(student2)) {
            ArrayList<User> blocked = student1.getBlocked();
            blocked.add(student2);
            student1.setBlocked(blocked);
        }
    }

    public static void unblockFriends(User student1, User student2) {
        if (student1.getBlocked().contains(student2)) {
            ArrayList<User> blocked = student1.getBlocked();
            blocked.remove(student2);
            student1.setBlocked(blocked);
        }
    }


    public static User getFriend(User student1, String username) {
        ArrayList<User> friends = student1.getFriends();
        for (User friend : friends) {
            if (Objects.equals(friend.getUsername(), username)) {
                return friend;
            }
        }
        return student1;
    }

    public static User getBlocked(User student1, String username) {
        ArrayList<User> blocked = student1.getBlocked();
        for (User user : blocked) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return student1;
    }

    public boolean checkUsername(ArrayList<User> db1, String username1) {
        for (User user : db1) {
            if (username1.equals(user.getUsername())) {
                return true;
            }
        }
        return false;

//    public ArrayList<String> sortFriendList(User student1) {
//        ArrayList<User> friends = student1.getFriends();
//        ArrayList<String> friendNames = new ArrayList<>();
//        for (User friend : friends) {
//            for (int i = 0; i < friends.size(); i++) {
//                friendNames.add(friend.getName());
//            }
//        }
//        Collections.sort(friendNames);
//        return friendNames;

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
}
