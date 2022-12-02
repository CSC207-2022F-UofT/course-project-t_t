package pages;

import entities.User;

import java.util.ArrayList;

public class FriendsListPage extends PageAction{
    @Override
    public void run(PageCache pageCache) {

        User curr_user = pageCache.getCurrentUser();

        ArrayList<User> fl = curr_user.getFriends();

        for (User user : fl) {
            String curr = user.getUsername();
            System.out.println(curr);
        }
    }
}