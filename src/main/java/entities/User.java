package entities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class User implements Jsonable {

    private String username;
    private String password;
    private String email;
    private FriendsList friendsList;
    private Location location;
    private Timetable timetable;
    public User() {

    }
    public User(String username, String password, String email, String location,
                Timetable timetable, FriendsList friendsList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.timetable = timetable;
        this.friendsList = new FriendsList(friendsList.getFriends(), friendsList.getBlocked());
        this.location = new Location(location);
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

    public String getLocation(){return this.location.getName();}

    public Timetable getTimetable() {return timetable;}

    public void setTimetable(Timetable timetable) {this.timetable = timetable;}

    public void setLocation(String location) {this.location = new Location(location);}

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("username", this.username);
        json.put("password", this.password);
        json.put("email", this.email);
        json.put("friendsList", this.friendsList);
        json.put("location", this.location);
        json.put("timetable", this.timetable);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try {
            writable.write(this.toJson());
        } catch (Exception ignored) {
            System.out.println("Oh no!");
        }
    }
}
