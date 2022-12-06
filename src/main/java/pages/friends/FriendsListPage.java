package pages.friends;

import entities.User;
import pages.PageAction;
import pages.PageSession;

import java.util.ArrayList;

public class FriendsListPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {

        User curr_user = pageSession.getCurrentUser();

        ArrayList<String> fl = curr_user.getFriends();

        for (String user : fl) {
            System.out.println(user);
        }
    }
}