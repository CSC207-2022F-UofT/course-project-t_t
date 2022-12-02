package pages;

import database.Database;
import entities.User;
import useCases.SignIn;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInPage extends Page{
    public SignInPage(PageState pageState) {
        super(pageState, "Sign In");
    }

    @Override
    public void run() {
        SignIn signIn = new SignIn();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        // show home page if username and password matches
        while (true) {
            System.out.println("Enter your username:");

            String username = in.next();

            System.out.println("Enter your password:");

            String password = in.next();
            ArrayList<User> friends = new ArrayList<>();
            ArrayList<User> blocked = new ArrayList<>();

            if (!signIn.checkUsername(db, username)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            if (!signIn.checkPassword(db, username, password)) {
                System.out.println("Password does not match. Try again.");
                continue;
            }

            System.out.printf("Signing in as %s.\n", username);
            this.pageState.setCurrentUser(new User(username, password, friends, blocked));
            break;
        }
    }
}
