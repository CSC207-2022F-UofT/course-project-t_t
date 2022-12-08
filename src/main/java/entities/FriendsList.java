package entities;

import java.util.ArrayList;

import entities.User;

public class FriendsList {
    ArrayList<User> friends;
    ArrayList<User> blocked;

    public FriendsList(ArrayList<User> friends, ArrayList<User> blocked) {
        this.friends = friends;
        this.blocked = blocked;
    }

    public FriendsList() {
        this.friends = new ArrayList<User>();
        this.blocked = new ArrayList<User>();
    }

    public ArrayList<User> getFriends() {
        return this.friends;

    }

    public ArrayList<User> getBlocked() {
        return this.blocked;
    }

}