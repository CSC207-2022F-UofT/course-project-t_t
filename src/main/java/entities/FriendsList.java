package entities;

import java.util.ArrayList;

public class FriendsList extends User{
    ArrayList<User> friends;
    ArrayList<User> blocked;

    public FriendsList(String name) {
        super(name);
    }

    public ArrayList<User> getFriends(User studentValue) {
        return studentValue.friends;
    }

    public ArrayList<User> getBlocked(User studentValue) {
        return studentValue.blocked;
    }

    public void setFriends(User studentValue, ArrayList<User> friends) {
        studentValue.friends = friends;
    }

    public void setBlocked(User studentValue, ArrayList<User> blocked) {
        studentValue.blocked = blocked;
    }

}