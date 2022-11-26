package entities;

import java.util.ArrayList;

public class User {
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public User(String name) {
        this.name = name;
    }

    protected ArrayList<User> friends;
    protected ArrayList<User> blocked;

    public ArrayList<User> getFriends() {
        return friends;
    }
    public ArrayList<User> getBlocked() {
        return blocked;
    }
    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
    public void setBlocked(ArrayList<User> blocked) {
        this.blocked = blocked;
    }
}
