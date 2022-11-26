package entities;

public class User {
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setTimetable(Timetable timetable) {this.timetable = timetable;}

    public void setLocation(Location location) {this.location = location;}

    public Location getLocation(){return this.location;}

    public Timetable getTimetable() {return timetable;}

    private String name;
    private Timetable timetable;

    private Location location;

    public User(String name) {
        this.name = name;
        this.location = new Location("Temporary place holder");
    }
}
