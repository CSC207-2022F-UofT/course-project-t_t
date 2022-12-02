package pages;

import entities.User;

public class PageSession {
    private User currentUser = null;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean checkLoggedIn(){
        return this.getCurrentUser() == null;
    }

}
