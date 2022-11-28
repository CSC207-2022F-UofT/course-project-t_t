package entities;

import java.util.ArrayList;
import entities.User;

public class FriendsList{
    ArrayList<User> friends;
    ArrayList<User> blocked;

//    public FriendsList(String username, String password) {
//        super(username, password);
//    }
    public FriendsList(ArrayList<User> friends, ArrayList<User> blocked) {
        this.friends = friends;
        this.blocked = blocked;
    }

    public ArrayList<User> getFriends() {
//        return studentValue.getFriends();
        return this.friends;

    }

    public ArrayList<User> getBlocked() {
        return this.blocked;
    }

//    public void setFriends(User studentValue, ArrayList<User> friends) {
//        studentValue.setFriends(friends);
//    }
//
//    public void setBlocked(User studentValue, ArrayList<User> blocked) {
//        studentValue.setBlocked(blocked);
//    }

}