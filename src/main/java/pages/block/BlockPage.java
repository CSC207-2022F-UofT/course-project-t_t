package pages.block;

import database.Database;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BlockPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();
        User curr_user = pageSession.getCurrentUser();

        while (true) {
            System.out.println("Enter username of user to block OR enter Exit to go back:");

            String friend = in.next();

            if (Objects.equals(friend, "Exit")){
                break;
            }

            if (Objects.equals(friend, "exit")){
                break;
            }

            if (!friendsListManager.checkUsername(db, friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Blocking %s.\n", friend);
            User curr_friend = Database.getUser(friend);
            FriendsListManager.blockFriends(curr_user, curr_friend);
            break;
        }
    }
}