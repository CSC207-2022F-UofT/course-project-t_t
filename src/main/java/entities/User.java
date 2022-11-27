package entities;

import entities.Timetable;
import entities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class User {

    private String name;
    private String password;
    private String email;
    private Timetable timetable;
    private ArrayList<User> friendsList;
    private ArrayList<User> blockedList;

    public User(String name, String password, String email,
                Timetable timetable, ArrayList<User> friendsList, ArrayList<User> blockedList) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.timetable = timetable;
        this.friendsList = friendsList;
        this.blockedList = blockedList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(ArrayList<User> friends) {
        this.friendsList = friends;
    }

    public ArrayList<User> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(ArrayList<User> blockedList) {
        this.blockedList = blockedList;
    }
}
