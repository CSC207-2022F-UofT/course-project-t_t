package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Manages operations on friendslist of users.
 */
public class RelationsManager {
    public static void addFriends(User student1, User student2) {
        //If they are blocked
        if (student1.getBlocked().contains(student2.getUsername())) {
            System.out.println("This user is blocked.");
            return;
        }
        //If you are blocked
        if (student2.getBlocked().contains(student1.getUsername())) {
            System.out.println("You do not have permission to add this user.");
            return;
        }
        //If They are not already your friend
        if ((!student1.getFriends().contains(student2.getUsername()))) {
            //If they exist on the database
            if (DatabaseGateway.contains(student2.getUsername())) {
                ArrayList<String> friends = student1.getFriends();
                friends.add(student2.getUsername());
                student1.setFriends(friends);
                DatabaseGateway.update(student1);
            }
        }
    }

    public static void removeFriends(User student1, User student2) {
        //If you have them added
        if (student1.getFriends().contains(student2.getUsername())) {
            ArrayList<String> friends = student1.getFriends();
            friends.remove(student2.getUsername());
            student1.setFriends(friends);
            DatabaseGateway.update(student1);
        }
    }


    public static void blockUser(User student1, User student2) {
        //If they were your friend
        if (student1.getFriends().contains(student2.getUsername())) {
            removeFriends(student1, student2);
        }
        //If they are not already blocked
        if (!student1.getBlocked().contains(student2.getUsername())) {
            ArrayList<String> blocked = student1.getBlocked();
            blocked.add(student2.getUsername());
            student1.setBlocked(blocked);
        }
        DatabaseGateway.update(student1);
    }

    public static void unblockUser(User student1, User student2) {
        //If they are blocked
        if (student1.getBlocked().contains(student2.getUsername())) {
            ArrayList<String> blocked = student1.getBlocked();
            blocked.remove(student2.getUsername());
            student1.setBlocked(blocked);
            DatabaseGateway.update(student1);
        }
    }


    public static User getFriend(User student1, String username) {
        ArrayList<String> friends = student1.getFriends();
        for (String friend : friends) {
            if (Objects.equals(friend, username)) {
                return DatabaseGateway.getUser(friend);
            }
        }
        return student1;
    }

    public static User getBlocked(User student1, String username) {
        ArrayList<String> blocked = student1.getBlocked();
        for (String user : blocked) {
            if (Objects.equals(user, username)) {
                return DatabaseGateway.getUser(username);
            }
        }
        return student1;
    }

    public boolean checkUsername(String username1) {
            return DatabaseGateway.getUser(username1) != null;
        }
}
