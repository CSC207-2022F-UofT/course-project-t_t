package entities;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private Location location;
    private Timetable timetable;
    private Relations relations;
    protected ArrayList<String> friends;
    protected ArrayList<String> blocked;
    public User(){}
    public User(String username, String password, ArrayList<String> friends,
                ArrayList<String> blocked, Location location, Timetable timetable) {
        this.username = username;
        this.password = password;
        this.relations = new Relations(friends, blocked);
        this.location = location;
        this.timetable = timetable;
    }
    public User(String username, String password, ArrayList<String> friends, ArrayList<String> blocked) {
        this.username = username;
        this.password = password;
        this.location = new Location("temp");
        this.relations = new Relations(friends, blocked);
        this.timetable = new Timetable();
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<String> getFriends() {
        return this.relations.friends;
    }
    public ArrayList<String> getBlocked() {return this.relations.blocked;}
    public Location getLocation(){return this.location;}
    public Timetable getTimetable() {return timetable;}
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFriends(ArrayList<String> friends) {
        this.relations.friends = friends;
    }
    public void setBlocked(ArrayList<String> blocked) {
        this.relations.blocked = blocked;
    }
    public void setLocation(Location location) {this.location = location;}
    public void setTimetable(Timetable timetable) {this.timetable = timetable;}
    public void addFriend(String u) {
        this.relations.friends.add(u);
    }
    public void addBlocked(String u) {
        this.relations.blocked.add(u);
    }
}
