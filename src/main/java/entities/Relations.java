package entities;

import java.util.ArrayList;

public class Relations {
    ArrayList<String> friends;
    ArrayList<String> blocked;

    public Relations(ArrayList<String> friends, ArrayList<String> blocked) {
        this.friends = friends;
        this.blocked = blocked;
    }

    public Relations() {
        this.friends = new ArrayList<String>();
        this.blocked = new ArrayList<String>();
    }

    public ArrayList<String> getFriends() {return this.friends;}

    public ArrayList<String> getBlocked() {
        return this.blocked;
    }

    public void addFriend(String u) {
        this.friends.add(u);
    }
}