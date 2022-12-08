package pages.block;

import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.RelationsManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UnblockPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        Scanner in = new Scanner(System.in);

        User curr_user = pageSession.getCurrentUser();
        ArrayList<String> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter username of user to unblock OR enter Exit to go back:");

            String friend = in.next();

            if (Objects.equals(friend, "Exit")){
                break;
            }

            if (Objects.equals(friend, "exit")){
                break;
            }

            //If input is myself?
            if (RelationsManager.getBlocked(curr_user, friend) == curr_user) {
                System.out.println("User not found. Try again.");
                continue;
            }
            System.out.printf("Unlocking %s.\n", friend);
            User curr_friend = RelationsManager.getBlocked(curr_user, friend);
            RelationsManager.unblockUser(curr_user, curr_friend);
            break;
        }
    }
}