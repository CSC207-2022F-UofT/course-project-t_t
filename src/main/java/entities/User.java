package entities;

public class User {

    private String username;
    private String password;
    private String email;
    private Timetable timetable;
    private FriendsList friendsList;
    private Location location;

    public User(String username, String password, String email, Location location,
                Timetable timetable, FriendsList friendsList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.timetable = timetable;
        this.friendsList = friendsList;
        this.location = location;
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

    public FriendsList getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(FriendsList friends) {
        this.friendsList = friends;
    }

    public Location getLocation(){return this.location;}

    public Timetable getTimetable() {return timetable;}

    public void setTimetable(Timetable timetable) {this.timetable = timetable;}

    public void setLocation(Location location) {this.location = location;}
}
