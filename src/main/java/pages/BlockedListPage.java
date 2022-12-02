package pages;

import entities.User;
import entities.FriendsList;

import java.util.ArrayList;

public class BlockedListPage extends Page{
    public BlockedListPage(Router router, PageState pageState) {
        super(router, pageState, "Blocked List Page");
    }
    @Override
    public Page run() {
        System.out.println("This is a Blocked List page.");

        User curr_user = this.pageState.getCurrentUser();

        ArrayList<User> bl = curr_user.getBlocked();

        for (User user : bl) {
            String curr = user.getUsername();
            System.out.println(curr);
        }

        return router.getFriendsPage();
    }
}