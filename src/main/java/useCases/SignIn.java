package useCases;

import Gateway.DatabaseGateway;
import entities.User;

import java.util.ArrayList;
import java.util.Objects;

public class SignIn {
    // return true if the given username exists in the given database
    public boolean checkUsername(String username1) {
        return DatabaseGateway.contains(username1);
    }

    // return true if the given password of the existing username matches the password
    // in the database
    public boolean checkPassword(String username2, String password1) {
        return Objects.equals(DatabaseGateway.getUser(username2).getPassword(), password1);
    }

}
