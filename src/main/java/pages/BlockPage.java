package pages;

import database.Database;
import entities.User;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class BlockPage extends Page{
    public BlockPage(Router router, PageState pageState) {
        super(router, pageState, "Block Page");
    }

    @Override
    public Page run() {
        FriendsListManager friendsListManager = new FriendsListManager();
        System.out.println("This is the Block User page.");

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();
        User curr_user = this.pageState.getCurrentUser();

        while (true) {
            System.out.println("Enter username of user to block:");

            String friend = in.next();

            if (!friendsListManager.checkUsername(db, friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Blocking %s.\n", friend);
            User curr_friend = Database.getUser(friend);
            FriendsListManager.blockFriends(curr_user, curr_friend);

            return router.getManageBlockedPage();
        }
    }
}