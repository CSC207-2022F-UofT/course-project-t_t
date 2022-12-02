package entities;

import java.util.ArrayList;

import entities.User;

public class FriendsList{
    ArrayList<User> friends;
    ArrayList<User> blocked;

    public FriendsList() {

    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public FriendsList(ArrayList<User> friends, ArrayList<User> blocked) {
        this.friends = friends;
        this.blocked = blocked;
    }

    public ArrayList<User> getFriends() {
        return this.friends;

    }

    public ArrayList<User> getBlocked() {
        return this.blocked;
    }

}