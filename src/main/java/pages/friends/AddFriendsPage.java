package pages.friends;

import Gateway.DatabaseGateway;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.RelationsManager;

import java.util.Objects;
import java.util.Scanner;

public class AddFriendsPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        RelationsManager relationsManager = new RelationsManager();

        Scanner in = new Scanner(System.in);

        User curr_user = pageSession.getCurrentUser();

        while (true) {
            System.out.println("Enter your friend's username OR enter Exit to go back:");

            String friend = in.next();

            if (Objects.equals(friend, "Exit")){
                break;
            }

            if (Objects.equals(friend, "exit")){
                break;
            }

            if (!relationsManager.checkUsername(friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Adding %s.\n", friend);
            User curr_friend = DatabaseGateway.getUser(friend);

            RelationsManager.addFriends(curr_user, curr_friend);
            break;
        }
    }
}

