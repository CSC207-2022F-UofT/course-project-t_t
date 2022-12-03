package entities;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Course implements Jsonable {
    String courseCode;
    String sectionCode;
    ArrayList<Lecture> lectures;

    public Course(String courseCode, String sectionCode, ArrayList<Lecture> lectures){
        this.courseCode = courseCode;
        this.sectionCode = sectionCode;
        this.lectures = lectures;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public ArrayList<Lecture> getLectures(){
        return this.lectures;
    }

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("lectures", this.lectures);
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
