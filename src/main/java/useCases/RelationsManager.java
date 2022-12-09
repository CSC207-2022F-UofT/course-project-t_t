package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Manages operations on friendslist of users.
 */
public class RelationsManager {
    /**
     * adds a friend to a user's list of friends.
     *
     * @param student1 the user that the student2 will be added to.
     * @param student2 the user that will be added to student1's friendslist.
     */
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

    /**
     * removes a friend from a user's list of friends.
     *
     * @param student1 the user that the student2 is getting removed from.
     * @param student2 the user that will be removed from student1's friendslist.
     */
    public static void removeFriends(User student1, User student2) {
        //If you have them added
        if (student1.getFriends().contains(student2.getUsername())) {
            ArrayList<String> friends = student1.getFriends();
            friends.remove(student2.getUsername());
            student1.setFriends(friends);
            DatabaseGateway.update(student1);
        }
    }

    /**
     * blocks a user from another user's account.
     *
     * @param student1 the current user
     * @param student2 the user that is getting blocked
     */
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

    /**
     * unblocks a user from another user's account.
     *
     * @param student1 the current user
     * @param student2 the user that is getting blocked
     */
    public static void unblockUser(User student1, User student2) {
        //If they are blocked
        if (student1.getBlocked().contains(student2.getUsername())) {
            ArrayList<String> blocked = student1.getBlocked();
            blocked.remove(student2.getUsername());
            student1.setBlocked(blocked);
            DatabaseGateway.update(student1);
        }
    }

    /**
     * gets a friend from a user's list of friends.
     *
     * @param student1 the current user
     * @param username the name of a user who is being searched from current user's friends list
     * @return
     * 1. If the user is not found in current user's friends list, return the current user.
     * 2. If the user is found in current user's friends list, return the corresponding user.
     */
    public static User getFriend(User student1, String username) {
        ArrayList<String> friends = student1.getFriends();
        for (String friend : friends) {
            if (Objects.equals(friend, username)) {
                return DatabaseGateway.getUser(friend);
            }
        }
        return student1;
    }

    /**
     *
     * @param student1 the current user
     * @param username the name of a user who is being searched from current user's blocked list
     * @return
     * 1. If the user is not found in current user's blocked list, return the current user
     * 2. If the user is found in current user's blocked list, return the corresponding user.
     */
    public static User getBlocked(User student1, String username) {
        ArrayList<String> blocked = student1.getBlocked();
        for (String user : blocked) {
            if (Objects.equals(user, username)) {
                return DatabaseGateway.getUser(username);
            }
        }
        return student1;
    }

    /**
     *
     * @param username1 the name of a user to be checked
     * @return if the user is found in the database of not
     */
    public boolean checkUsername(String username1) {
            return DatabaseGateway.getUser(username1) != null;
        }
}
