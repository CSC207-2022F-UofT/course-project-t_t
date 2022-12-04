package pages.friends;

import database.Database;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RemoveFriendsPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        User curr_user = pageSession.getCurrentUser();
        ArrayList<User> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter your friend's username OR enter Exit to go back:");

            String friend = in.next();

            if (Objects.equals(friend, "Exit")){
                break;
            }

            if (Objects.equals(friend, "exit")){
                break;
            }

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

