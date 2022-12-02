package pages;

import entities.User;
import entities.FriendsList;

import java.util.ArrayList;

public class FriendsListPage extends Page{
    public FriendsListPage(PageState pageState) {
        super(pageState, "Friends List");
    }
    @Override
    public void run() {

        User curr_user = this.pageState.getCurrentUser();

        ArrayList<User> fl = curr_user.getFriends();

        for (User user : fl) {
            String curr = user.getUsername();
            System.out.println(curr);
        }
    }
}