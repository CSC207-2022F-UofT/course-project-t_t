package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class SignIn {
    /**
     * Iterates over the list of existing users and
     * checks if the given username matches any of the usernames in the database.
     *
     *
     * @param username1 username given by the user.
     *
     * @return True if the given username is in the database. False otherwise.
     */
    public boolean checkUsername(String username1) {
        return DatabaseGateway.contains(username1);
    }
    
    /**
     * Uses a loop to find the index of the user with the given username in the database and if the user is found,
     * the method checks if the given password matches the password of the user with the given username.
     *
     *
     * @param username2 username given by the user.
     *
     * @param password1 password given by the user.
     *
     * @return True if the given username exists in the database and the password matches
     * the password of the user with the given username. False otherwise.
     */
    public boolean checkPassword(String username2, String password1) {
        return Objects.equals(DatabaseGateway.getUser(username2).getPassword(), password1);



    }

}
