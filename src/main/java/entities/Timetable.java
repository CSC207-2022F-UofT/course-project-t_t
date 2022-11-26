
package entities;

import java.util.ArrayList;

public class Timetable {

    ArrayList<Course> courses;

    public Timetable(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() { return this.courses; }

}

