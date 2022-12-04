package entities;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import entities.User;



public class FriendsList implements Jsonable {

    ArrayList<User> friends = new ArrayList<>();
    ArrayList<User> blocked = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public FriendsList() {}
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

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
//        json.put("username", this.username);
//        json.put("password", this.password);
//        json.put("email", this.email);
//        json.put("friendsList", this.friendsList);
//        json.put("location", this.location);
//        json.put("timetable", this.timetable);
        json.put("friendList", this.friends);
        json.put("blockedList", this.blocked);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try {
            writable.write(this.toJson());
        } catch (Exception ignored) {

        }
    }
}
