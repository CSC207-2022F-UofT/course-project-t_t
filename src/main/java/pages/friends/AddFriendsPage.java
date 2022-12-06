package pages.friends;

import Gateway.DatabaseGateway;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class AddFriendsPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = DatabaseGateway.getDatabase();
        User curr_user = pageSession.getCurrentUser();

        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();

            if (!friendsListManager.checkUsername(db, friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Adding %s.\n", friend);
            User curr_friend = DatabaseGateway.getUser(friend);

            FriendsListManager.addFriends(curr_user, curr_friend);
            break;
        }
    }
}

