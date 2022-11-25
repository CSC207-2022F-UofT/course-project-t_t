package pages;

import database.Database;
import entities.User;
import useCases.SignIn;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInPage extends Page{
    public SignIn signIn;
    public SignInPage(Router router, PageState pageState) {
        super(router, pageState, "Sign In Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Sign In page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        // show home page if username and password matches
        while (true) {
            System.out.println("Enter your username:");

            String username = in.next();

            System.out.println("Enter your password:");

            String password = in.next();

            // change lines 36 & 41 according to the format of Database (i.e. change db.get(0))
            // use usecases to check the correctness of the username & password in lines 36 & 41
            if (!username.equals(db.get(0).getUsername())) {
                System.out.println("User not found. Try again.");
                continue;
            }

            if (!password.equals(db.get(0).getPassword())) {
                System.out.println("Password does not match. Try again.");
                continue;
            }

            System.out.printf("Signing in as %s.\n", username);
            this.pageState.setCurrentUser(new User(username, password));

            return router.getHomePage();
        }
    }
}
