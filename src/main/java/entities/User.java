package entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Location location;
    private Timetable timetable;
    private FriendsList friendsList;
    protected ArrayList<User> friends;
    protected ArrayList<User> blocked;
    public User(){}
    public User(String username, String password, ArrayList<User> friends,
                ArrayList<User> blocked, Location location, Timetable timetable) {
        this.username = username;
        this.password = password;
        this.friendsList = new FriendsList(friends, blocked);
        this.location = location;
        this.timetable = timetable;
    }
    public User(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        this.username = username;
        this.password = password;
        this.location = new Location("temp");
        this.friendsList = new FriendsList(friends, blocked);
        this.timetable = new Timetable();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<User> getFriends() {
        return this.friendsList.friends;
    }
    public ArrayList<User> getBlocked() {return this.friendsList.blocked;}
    public Location getLocation(){return this.location;}
    public Timetable getTimetable() {return timetable;}
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFriends(ArrayList<User> friends) {
        this.friendsList.friends = friends;
    }
    public void setBlocked(ArrayList<User> blocked) {
        this.friendsList.blocked = blocked;
    }
    public void setLocation(Location location) {this.location = location;}
    public void setTimetable(Timetable timetable) {this.timetable = timetable;}
    public void addFriend(User u) {
        this.friendsList.friends.add(u);
    }
    public void addBlocked(User u) {
        this.friendsList.blocked.add(u);
    }
}
