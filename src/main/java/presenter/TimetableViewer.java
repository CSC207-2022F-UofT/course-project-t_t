package presenter;

import entities.Course;
import entities.Timetable;

import java.util.ArrayList;
import java.util.Arrays;

public class TimetableViewer {
    public ArrayList<String> visualizeTimetable(Timetable timetable) {

        ArrayList<Course> courses = timetable.getCourses();
        ArrayList<String> schedule = new ArrayList<>();

        StringBuilder sch = new StringBuilder();

        for (Course cou : courses) {
            sch.append('\n' + '[' + cou.getCourseCode() + '\n');
            sch.append(cou.getSectionCode() + '\n');
            sch.append(+']');

            schedule.add(sch.toString());

        }

        System.out.println("Test");

        return schedule;







    }
}