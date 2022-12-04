
package entities;

import java.util.ArrayList;

public class Timetable {

    ArrayList<Course> courses;

    public Timetable() {
        this.courses = new ArrayList<Course>();
    }

    public Timetable(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() { return this.courses; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Course course : courses) {
            str.append(course.toString()).append("\n");
        }
        return str.toString();
    }

}

