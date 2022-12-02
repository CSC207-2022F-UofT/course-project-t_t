package pages;

import entities.User;

import java.util.ArrayList;

public class BlockedListPage extends PageAction {
    @Override
    public void run(PageCache pageCache) {

        User curr_user = pageCache.getCurrentUser();

        ArrayList<User> bl = curr_user.getBlocked();

        for (User user : bl) {
            String curr = user.getUsername();
            System.out.println(curr);
        }
    }
}