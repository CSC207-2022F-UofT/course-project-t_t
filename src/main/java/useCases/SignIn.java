package useCases;

import entities.User;

import java.util.ArrayList;

public class SignIn {
    // return true if the given username exists in the given database
    public boolean checkUsername(ArrayList<User> db1, String username1) {
        for (User user : db1) {
            if (username1.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    // return true if the given password of the existing username matches the password
    // in the database
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
