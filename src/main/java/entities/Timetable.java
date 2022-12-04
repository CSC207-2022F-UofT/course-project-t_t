
package entities;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Timetable implements Jsonable {

    public Timetable() {}

    ArrayList<Course> courses;

    public Timetable(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() { return this.courses; }

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("courses", this.courses);
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

