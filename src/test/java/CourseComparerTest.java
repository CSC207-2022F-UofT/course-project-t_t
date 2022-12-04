import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.CourseComparer;
import useCases.FreeIntervalComparer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CourseComparerTest {

    Timetable dummyTimetable1;
    Timetable dummyTimetable2;

    @Before
    public void setUp() {
        ArrayList<Timetable> dummyTimetables = getDummyTimetables();
        dummyTimetable1 = dummyTimetables.get(0);
        dummyTimetable2 = dummyTimetables.get(1);
    }

    @Test(timeout = 50)
    public void testFindCommonCourses() {

        ArrayList<Course> output = getTestOutput();
        String expected = """
                [KIM101-LEC 0101:
                    {[2160, 2220), BA 2222}
                    {[6660, 6720), BA 2222}
                , JJJ265-LEC 0101:
                    {[2160, 2220), BA 2222}
                    {[3720, 3840), BA 2222}
                ]""";
        assertEquals(expected, output.toString());
    }

    private ArrayList<Course> getTestOutput() {
        return CourseComparer.findCommonCourses(dummyTimetable1, dummyTimetable2);
    }
    private static ArrayList<Timetable> getDummyTimetables() {
        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();

        dummyLectures1.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures1.add(
                new Lecture(new Interval(6660, 6720), new Location("BA 2222"))
        );

        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();

        dummyLectures2.add(
                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
        );
        dummyLectures2.add(
                new Lecture(new Interval(3720, 3840), new Location("BA 2222"))
        );


        ArrayList<Course> dummyCourses1 = new ArrayList<>();

        dummyCourses1.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses1.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        ArrayList<Course> dummyCourses2 = new ArrayList<>();

        dummyCourses2.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses2.add(
                new Course("JJJ265", "LEC 0101", dummyLectures2)
        );

        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
        Timetable dummyTimetable2 = new Timetable(dummyCourses2);

        ArrayList<Timetable> timetables = new ArrayList<>();
        timetables.add(dummyTimetable1);
        timetables.add(dummyTimetable2);

        return timetables;
    }
}
