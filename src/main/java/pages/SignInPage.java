package pages;

import database.Database;
import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInPage extends Page{
    public SignInPage(Router router, PageState pageState) {
        super(router, pageState, "Sign In Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Sign In page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        while (true) {
            System.out.println("Enter your username:");

            String username = in.next();

            if (!username.equals(db.get(0).getName())) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Signing in as %s.\n", username);
            this.pageState.setCurrentUser(new User(username));

            return router.getHomePage();
        }
    }
}
