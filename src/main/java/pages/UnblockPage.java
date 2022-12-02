package pages;

import database.Database;
import entities.User;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class UnblockPage extends Page {
    public UnblockPage(PageState pageState) {
        super(pageState, "Unblock Friends");
    }

    @Override
    public void run() {
//        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        User curr_user = this.pageState.getCurrentUser();
        ArrayList<User> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter username of user to unblock:");

            String friend = in.next();

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