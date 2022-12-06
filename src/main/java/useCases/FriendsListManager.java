package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Manages operations on friendslist of users.
 */
public class FriendsListManager {
//    static SignIn signIn = new SignIn();
//    static FriendsListChecker friendsListChecker = new FriendsListChecker();
    public static void addFriends(User student1, User student2) {
        if (student1.getBlocked().contains(student2)) {
            System.out.println("This user is blocked.");
        }
        if (student2.getBlocked().contains(student1)) {
            System.out.println("You do not have permission to add this user.");
        }
        if ((!student1.getFriends().contains(student2)) & (!student1.getBlocked().contains(student2)) &
                (!student2.getBlocked().contains(student1))) {
            if (DatabaseGateway.contains(student2.getUsername())) {
                ArrayList<User> friends = student1.getFriends();
                friends.add(student2);
                student1.setFriends(friends);
                System.out.println("ASD");
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

    public boolean checkUsername(String username1) {
            return DatabaseGateway.getUser(username1) != null;
        }
}
