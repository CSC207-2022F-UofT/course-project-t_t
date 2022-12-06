package useCases;

import entities.User;

import java.util.ArrayList;

public class SignUp {
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
