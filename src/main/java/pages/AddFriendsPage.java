package pages;

import database.Database;
import entities.User;
import useCases.FriendsListManager;
import useCases.SignIn;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AddFriendsPage extends Page{
    public AddFriendsPage(PageState pageState) {
        super(pageState, "Add Friends");
    }

    @Override
    public void run() {
        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();
        User curr_user = this.pageState.getCurrentUser();

        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();

            if (!friendsListManager.checkUsername(db, friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Adding %s.\n", friend);
            User curr_friend = Database.getUser(friend);

            FriendsListManager.addFriends(curr_user, curr_friend);
            break;
        }
    }
}

