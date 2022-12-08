package pages.block;

import entities.User;
import pages.PageAction;
import pages.PageSession;

import java.util.ArrayList;

public class BlockedListPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {

        User curr_user = pageSession.getCurrentUser();

        ArrayList<String> bl = curr_user.getBlocked();

        for (String user : bl) {
            System.out.println(user);
        }
    }
}