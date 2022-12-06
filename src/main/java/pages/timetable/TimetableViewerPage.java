package pages.timetable;

import entities.Course;
import entities.Timetable;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import presenter.CompareVisualizer;

import java.util.ArrayList;

public class TimetableViewerPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        User currentUser = pageSession.getCurrentUser();
        Timetable timetable = currentUser.getTimetable();
        ArrayList<Course> courses = timetable.getCourses();

        CompareVisualizer.compareWindow(courses);

    }
}
