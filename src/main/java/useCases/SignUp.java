package useCases;

import entities.User;

import java.util.ArrayList;

public class SignUp {
    /**
     * Iterates over the list of existing users and
     * checks if the given new username is equal to any of the existing usernames.
     *
     * @param db3 arraylist of the users in the database.
     *
     * @param newUsername1 new username of the user.
     *
     * @return True if the new username is unique. False otherwise.
     */
    public boolean checkNewUsername(ArrayList<User> db3, String newUsername1) {
        for (User user : db3) {
            // return false if the username already exists
            if (newUsername1.equals(user.getUsername())) {
                return false;
            }
        }
        // check all the usernames in the database and if none of the usernames equal newUsername,
        // return true
        return true;
    }
}
