package pages.user;

import Gateway.DatabaseGateway;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.SignIn;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
        SignIn signIn = new SignIn();

        Scanner in = new Scanner(System.in);


        // show home page if username and password matches
        while (true) {
            System.out.println("Enter your username:");

            String username = in.next();
            System.out.println(username);

            System.out.println("Enter your password:");

            String password = in.next();
            ArrayList<String> friends = new ArrayList<>();
            ArrayList<String> blocked = new ArrayList<>();

            if (!signIn.checkUsername(username)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            if (!signIn.checkPassword(username, password)) {
                System.out.println("Password does not match. Try again.");
                continue;
            }

            System.out.printf("Signing in as %s.\n", username);
            pageSession.setCurrentUser(new User(username, password, friends, blocked));
            break;
        }
    }
}
