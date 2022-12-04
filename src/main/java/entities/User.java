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

    public void setTimetable(Timetable timetable) {this.timetable = timetable;}

    public void setLocation(Location location) {this.location = location;}

    public Location getLocation(){return this.location;}

    public Timetable getTimetable() {return timetable;}


    private Location location;
    private Timetable timetable;
    private Course course;

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.location = new Location("temp");
        this.friendsList = new FriendsList();
        this.timetable = new Timetable();
    }

//    protected ArrayList<User> friends;
    private FriendsList friendsList;
//    protected ArrayList<User> blocked;

    public ArrayList<User> getFriends() {
//        System.out.println(friendsList.friends);
//        # --> Source of Error (friends has not been initialized)
        return this.friendsList.friends;
    }
    public ArrayList<User> getBlocked() {
        return this.friendsList.blocked;
    }
    public void setFriends(ArrayList<User> friends) {
        this.friendsList.friends = friends;
    }
    public void setBlocked(ArrayList<User> blocked) {
        this.friendsList.blocked = blocked;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public User(String name) {
        this.name = name;
    }

    protected ArrayList<User> friends;
    protected ArrayList<User> blocked;

//    public ArrayList<User> getFriends() {
//        return friends;
//    }
//    public ArrayList<User> getBlocked() {
//        return blocked;
//    }
//    public void setFriends(ArrayList<User> friends) {
//        this.friends = friends;
//    }
//    public void setBlocked(ArrayList<User> blocked) {
//        this.blocked = blocked;
//    }
}
