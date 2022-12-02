package pages;

import database.Database;
import entities.FriendsList;
import entities.User;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFriendsPage extends Page {
    public RemoveFriendsPage(Router router, PageState pageState) {
        super(router, pageState, "Remove Friends Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Remove Friends page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();

        User curr_user = this.pageState.getCurrentUser();
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

            return router.getManageFriendsPage();
        }
    }
}

