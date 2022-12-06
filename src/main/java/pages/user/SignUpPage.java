package pages.user;

import Database.Database;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.SignUp;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SignUpPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        SignUp signUp = new SignUp();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        // show sign in page if the new user is successfully signed up
        while (true) {
            System.out.println("Enter your new username:");

            String username = in.next();

            if (Objects.equals(username, "Exit") || Objects.equals(username, "exit")) {
                System.out.println("This username cannot be used. Try another username.");
                continue;
            }

            if (!signUp.checkNewUsername(db, username)) {
                System.out.println("Existing username. Try another username.");
                continue;
            }

            System.out.println("Enter your new password:");

            String password = in.next();
            ArrayList<User> friends = new ArrayList<>();
            ArrayList<User> blocked = new ArrayList<>();

            System.out.println("Re-enter your password:");

            String password2 = in.next();

            if (!password.equals(password2)) {
                System.out.println("This does not match the entered password. Try again.");
                continue;
            }

            // Database.getDatabase().add(new User(username, password, friends, blocked));
            // db.add(new User(username, password, friends, blocked));
            // Database.setDatabase(db);
            Database.addUser(username, password, friends, blocked);

            System.out.printf("New account created for %s. \n", username);
            break;
        }
    }
}
