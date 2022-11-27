package entities;

import java.util.ArrayList;
public class User {

    private String username;
    private String password;
    private String email;
    private Timetable timetable;
    private ArrayList<User> friendsList;
    private ArrayList<User> blockedList;
    private Location location;

    public User(String username, String password, String email,
                Timetable timetable, ArrayList<User> friendsList, ArrayList<User> blockedList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.timetable = timetable;
        this.friendsList = friendsList;
        this.blockedList = blockedList;
        this.location = new Location("temp");
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Location getLocation(){return this.location;}

    public Timetable getTimetable() {return timetable;}

    public void setTimetable(Timetable timetable) {this.timetable = timetable;}

    public void setLocation(Location location) {this.location = location;}
}
