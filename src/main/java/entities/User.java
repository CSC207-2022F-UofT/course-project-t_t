package entities;

import java.util.ArrayList;

public class User {
    String username;
    String password;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    // TODO: add getters & setters for <friends>, <blocked>, and <timetable>

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
