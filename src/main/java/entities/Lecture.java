package entities;

public class Lecture {
    Interval interval;
    Location location;

    public Lecture(Interval interval, Location location){
        this.interval = interval;
        this.location = location;
    }
    public Interval getInterval(){
        return this.interval;
    }

    public Location getLocation(){
        return this.location;
    }
}
