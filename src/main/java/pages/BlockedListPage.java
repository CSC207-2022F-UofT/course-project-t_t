package pages;

import entities.User;
import entities.FriendsList;

import java.util.ArrayList;

public class BlockedListPage extends Page{
    public BlockedListPage(PageState pageState) {
        super(pageState, "Blocked List");
    }
    @Override
    public void run() {

        User curr_user = this.pageState.getCurrentUser();

        ArrayList<User> bl = curr_user.getBlocked();

        for (User user : bl) {
            String curr = user.getUsername();
            System.out.println(curr);
        }
    }
}