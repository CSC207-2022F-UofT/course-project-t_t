//import entities.*;
//import org.junit.Before;
//import org.junit.Test;
//import useCases.FreeIntervalComparer;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class FreeIntervalComparerTest {
//
//    ArrayList<Timetable> dummyTimetables;
//
//    @Before
//    public void setUp() {
//        dummyTimetables = getDummyTimetables();
//    }
//
//    @Test(timeout = 50)
//    public void testFindFreeIntervals() {
//
//        runTestCase(2180, 2240, "[[0, 2160), [2240, 3720), [3840, 6660), [6720, 2147483647)]");
//        runTestCase(3180, 5240, "[[0, 2160), [2240, 3180), [5240, 6660), [6720, 2147483647)]");
//        runTestCase(2000, 5000, "[[0, 2000), [5240, 6660), [6720, 2147483647)]");
//        runTestCase(10001, 10004, "[[0, 2000), [5240, 6660), [6720, 10001), [10004, 2147483647)]");
//        runTestCase(1, 12345, "[[0, 1), [12345, 2147483647)]");
//    }
//
//    public void runTestCase(int intervalStart, int intervalEnd, String expected) {
//        addIntervalTest(intervalStart, intervalEnd);
//        ArrayList<Interval> output = getTestOutput();
//        assertEquals(expected, output.toString());
//    }
//
//    private ArrayList<Interval> getTestOutput() {
//        return FreeIntervalComparer.findFreeIntervals(dummyTimetables);
//    }
//
//    private void addIntervalTest(int start, int end) {
//        dummyTimetables.get(0).getCourses().get(0).getLectures().add(
//                new Lecture(
//                        new Interval(start, end), new Location("BA 1234")
//                )
//        );
//    }
//    private static ArrayList<Timetable> getDummyTimetables() {
//        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();
//
//        dummyLectures1.add(
//                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
//        );
//        dummyLectures1.add(
//                new Lecture(new Interval(6660, 6720), new Location("BA 2222"))
//        );
//
//        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();
//
//        dummyLectures2.add(
//                new Lecture(new Interval(2160, 2220), new Location("BA 2222"))
//        );
//        dummyLectures2.add(
//                new Lecture(new Interval(3720, 3840), new Location("BA 2222"))
//        );
//
//
//        ArrayList<Course> dummyCourses1 = new ArrayList<>();
//
//        dummyCourses1.add(
//                new Course("KIM101", "LEC 0101", dummyLectures1)
//        );
//        dummyCourses1.add(
//                new Course("JJJ265", "LEC 0101", dummyLectures2)
//        );
//
//        ArrayList<Course> dummyCourses2 = new ArrayList<>();
//
//        dummyCourses2.add(
//                new Course("KIM101", "LEC 0101", dummyLectures1)
//        );
//        dummyCourses2.add(
//                new Course("JJJ265", "LEC 0101", dummyLectures2)
//        );
//
//        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
//        Timetable dummyTimetable2 = new Timetable(dummyCourses2);
//
//        ArrayList<Timetable> timetables = new ArrayList<>();
//        timetables.add(dummyTimetable1);
//        timetables.add(dummyTimetable2);
//
//        return timetables;
//    }
//}
