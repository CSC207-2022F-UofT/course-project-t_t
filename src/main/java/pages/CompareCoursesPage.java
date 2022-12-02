package pages;

import database.Database;
import entities.*;
import useCases.CourseComparer;

import java.util.ArrayList;

public class CompareCoursesPage extends Page{
    public CompareCoursesPage(Router router, PageState pageState) {
        super(router, pageState, "Compare Courses Page");
    }

    @Override
    public Page run() {
        assert super.checkLoggedIn();

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

        return router.getTimetablePage();
    }
}
