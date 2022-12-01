package pages;

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


        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();

        dummyLectures1.add(
                new Lecture(new Interval(1, 2), new Location("BA 2222"))
        );
        dummyLectures1.add(
                new Lecture(new Interval(4, 5), new Location("BA 2222"))
        );

        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();

        dummyLectures2.add(
                new Lecture(new Interval(3, 5), new Location("BA 2222"))
        );
        dummyLectures2.add(
                new Lecture(new Interval(4, 5), new Location("BA 2222"))
        );


        ArrayList<Course> dummyCourses1 = new ArrayList<>();

        dummyCourses1.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses1.add(
                new Course("JJJ265", "LEC 0101", dummyLectures1)
        );

        ArrayList<Course> dummyCourses2 = new ArrayList<>();

        dummyCourses2.add(
                new Course("KIM101", "LEC 0101", dummyLectures2)
        );
        dummyCourses2.add(
                new Course("JJJ265", "LEC 0101", dummyLectures1)
        );

        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
        Timetable dummyTimetable2 = new Timetable(dummyCourses2);

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
