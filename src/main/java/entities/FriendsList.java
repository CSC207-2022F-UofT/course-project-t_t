package entities;

import java.util.ArrayList;

import entities.User;

public class FriendsList{
    ArrayList<User> friends = new ArrayList<>();
    ArrayList<User> blocked = new ArrayList<>();

    public FriendsList() {}
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

    public void setFriends(ArrayList<User> u) {
        this.friends = u;
    }

    public ArrayList<User> getBlocked() {
        return this.blocked;
    }

    public void setBlocked(ArrayList<User> u) {
        this.blocked = u;
    }
}