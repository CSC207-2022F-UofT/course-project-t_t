package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;

/**
 * useCase that takes user's username and password to create a new user.
 */
public class SignUp {

    public static boolean checkNewUsername(String newUsername1) {
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
        // check all the usernames in the database and if none of the usernames equal newUsername,
        // return true
        return !DatabaseGateway.contains(newUsername1);
    }
}
