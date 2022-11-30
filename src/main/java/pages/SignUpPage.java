package pages;

import database.Database;
import entities.User;
import useCases.SignUp;

import java.util.ArrayList;
import java.util.Scanner;

public class SignUpPage extends Page{
    public SignUpPage(Router router, PageState pageState) {
        super(router, pageState, "Sign Up Page");
    }

    @Override
    public Page run() {
        SignUp signUp = new SignUp();
        System.out.println("This is a Sign Up page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        // show sign in page if the new user is successfully signed up
        while (true) {
            System.out.println("Enter your new username:");

            String username = in.next();

            System.out.println("Enter your new password:");

            String password = in.next();
            ArrayList<User> friends = new ArrayList<>();
            ArrayList<User> blocked = new ArrayList<>();

            if (!signUp.checkNewUsername(db, username)) {
                System.out.println("Existing username. Try another username.");
                continue;
            }

            System.out.println("Re-enter your password:");

            String password2 = in.next();

            if (!password.equals(password2)) {
                System.out.println("This does not match the entered password. Try again.");
                continue;
            }

            Database.addUser(username, password, friends, blocked);

            System.out.printf("New account created for %s. \n", username);

            return router.getSignInPage();
        }
    }
}
