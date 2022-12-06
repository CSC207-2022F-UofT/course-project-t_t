package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;

public class SignUp {
    public boolean checkNewUsername(String newUsername1) {
        // check all the usernames in the database and if none of the usernames equal newUsername,
        // return true
        return !DatabaseGateway.contains(newUsername1);
    }

}
