package pages;

import entities.User;

public class PageCache {
    private User currentUser = null;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    protected boolean checkLoggedIn(){
        return this.getCurrentUser() == null;
    }

}
