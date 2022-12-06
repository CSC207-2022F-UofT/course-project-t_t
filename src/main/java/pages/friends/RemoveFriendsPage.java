package pages.friends;

import Gateway.DatabaseGateway;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFriendsPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = DatabaseGateway.getDatabase();

        User curr_user = pageSession.getCurrentUser();
        ArrayList<User> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();

            if (FriendsListManager.getFriend(curr_user, friend) == curr_user) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Removing %s.\n", friend);
            User curr_friend = FriendsListManager.getFriend(curr_user, friend);
            FriendsListManager.removeFriends(curr_user, curr_friend);
            break;
        }
    }
}

