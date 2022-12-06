package entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Location location;
    private Timetable timetable;
    private FriendsList friendsList;

    public User(){}

    public User(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        this.username = username;
        this.password = password;
        this.friendsList = new FriendsList(friends, blocked);
    }

    public User(String username, String password, ArrayList<User> friends,
                ArrayList<User> blocked, Location location, Timetable timetable) {
        this.username = username;
        this.password = password;
        this.friendsList = new FriendsList(friends, blocked);
        this.location = location;
        this.timetable = timetable;
    }


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



    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) {
        this.password = password;
    }




    public ArrayList<User> getFriends() {
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


    public void addFriend(User u) {
        this.friendsList.friends.add(u);
    }

    public void addBlocked(User u) {
        this.friendsList.blocked.add(u);
    }
}
