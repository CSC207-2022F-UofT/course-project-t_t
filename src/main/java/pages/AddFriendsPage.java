package pages;

import database.Database;
import entities.User;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class AddFriendsPage extends Page{
    public AddFriendsPage(Router router, PageState pageState) {
        super(router, pageState, "Add Friends Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Add Friends page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();
        User curr_user = this.pageState.getCurrentUser();

        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();

            if (!friend.equals(db.get(0).getName())) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Adding %s.\n", friend);
            User curr_friend = db.get(0);
            FriendsListManager.addFriends(curr_user, curr_friend);

            return router.getFriendsListPage();
        }
    }
}

