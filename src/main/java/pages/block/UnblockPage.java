package pages.block;

import Gateway.DatabaseGateway;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UnblockPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
//        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        User curr_user = pageSession.getCurrentUser();
        ArrayList<User> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter username of user to unblock OR enter Exit to go back:");

            String friend = in.next();

            if (Objects.equals(friend, "Exit")){
                break;
            }

            if (Objects.equals(friend, "exit")){
                break;
            }

            if (FriendsListManager.getBlocked(curr_user, friend) == curr_user) {
                System.out.println("User not found. Try again.");
                continue;
            }

//            System.out.printf("Unblocking %s.\n", friend);
//            User curr_friend = FriendsListManager.getFriend(curr_user, friend);
            System.out.printf("Unlocking %s.\n", friend);
            User curr_friend = FriendsListManager.getBlocked(curr_user, friend);
            FriendsListManager.unblockFriends(curr_user, curr_friend);
            break;
        }
    }
}