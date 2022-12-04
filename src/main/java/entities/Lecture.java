package entities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;

public class Lecture implements Jsonable {
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

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("location", this.location);
        json.put("interval", this.interval);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) throws IOException {
        try {
            writable.write(this.toJson());
        } catch (Exception ignored) {

        }
    }

}
