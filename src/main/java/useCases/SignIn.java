package useCases;

import entities.User;

import java.util.ArrayList;

public class SignIn {
    /**
     * Iterates over the list of existing users and
     * checks if the given username matches any of the usernames in the database.
     *
     * @param db1 arraylist of the users in the database.
     *
     * @param username1 username given by the user.
     *
     * @return True if the given username is in the database. False otherwise.
     */
    public boolean checkUsername(ArrayList<User> db1, String username1) {
        for (User user : db1) {
            if (username1.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Uses a loop to find the index of the user with the given username in the database and if the user is found,
     * the method checks if the given password matches the password of the user with the given username.
     *
     * @param db2 arraylist of the users in the database.
     *
     * @param username2 username given by the user.
     *
     * @param password1 password given by the user.
     *
     * @return True if the given username exists in the database and the password matches
     * the password of the user with the given username. False otherwise.
     */
    public boolean checkPassword(ArrayList<User> db2, String username2, String password1) {
        int x = -1;

        for (int j = 0; j < db2.size(); j++) {
            if (username2.equals(db2.get(j).getUsername())) {
                x = j;
            }
        }

        if (x == -1) {
            return false;
        } else {
            if (password1.equals(db2.get(x).getPassword())) {
                return true;
            }
        }

        return false;
    }
}
