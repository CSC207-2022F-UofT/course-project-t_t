package pages;

import entities.User;
import entities.FriendsList;

import java.util.ArrayList;

public class FriendsListPage extends Page{
    public FriendsListPage(Router router, PageState pageState) {
        super(router, pageState, "Friends List Page");
    }
    @Override
    public Page run() {
        System.out.println("This is a Friends List page.");

        User curr_user = this.pageState.getCurrentUser();

        ArrayList<User> fl = FriendsList.getFriends(curr_user);

        for (User user : fl) {
            String curr = user.getName();
            System.out.println(curr);
        }

        return router.getManageFriendsPage();
    }
}