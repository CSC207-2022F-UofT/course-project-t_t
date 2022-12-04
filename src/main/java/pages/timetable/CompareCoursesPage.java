package pages.timetable;

import database.Database;
import entities.*;
import pages.PageAction;
import pages.PageSession;
import useCases.CourseComparer;

import java.util.ArrayList;

public class CompareCoursesPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
        assert pageSession.checkLoggedIn();

        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();
        Timetable dummyTimetable1 = dummyTimetables.get(0);
        Timetable dummyTimetable2 = dummyTimetables.get(1);

        ArrayList<Course> sharedCourses = CourseComparer.findCommonCourses(dummyTimetable1, dummyTimetable2);

        System.out.println("Your timetable:");
        System.out.println(dummyTimetable1.toString());
        System.out.println("Compared timetable:");
        System.out.println(dummyTimetable2.toString());
        System.out.println("Shared courses:");
        System.out.println(sharedCourses);
    }
}
