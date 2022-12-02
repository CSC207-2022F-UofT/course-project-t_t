package presenter;

import entities.Course;
import entities.Timetable;

import java.util.ArrayList;

public class TimetableViewer {
    public ArrayList<String> visualizeTimetable(Timetable timetable) {

        ArrayList<Course> courses = timetable.getCourses();
        ArrayList<String> schedule = new ArrayList<String>();

        StringBuilder sch = new StringBuilder();

        for (Course cou: courses) {
            sch.append('\n' + '[' + cou.getCourseCode() + '\n' );
            sch.append(cou.getSectionCode() + '\n');
            sch.append( + ']');

        }
        return schedule;
    }
}