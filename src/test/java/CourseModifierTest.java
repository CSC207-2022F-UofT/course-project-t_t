import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.CourseModifier;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CourseModifierTest {
    CourseModifier courseModifier;

    @Before
    public void setUp() {
        courseModifier = new CourseModifier();
    }

    @Test(timeout = 50)
    public void testCheckCourseCodeLength() {
        assertTrue(courseModifier.checkCourseCodeLength("STA237"));
        assertFalse(courseModifier.checkCourseCodeLength("STA2373"));
        assertFalse(courseModifier.checkCourseCodeLength("23"));
        assertFalse(courseModifier.checkCourseCodeLength("-"));
        assertFalse(courseModifier.checkCourseCodeLength(""));
    }

    @Test(timeout = 50)
    public void testCheckCourseCodeAlpha() {
        assertTrue(courseModifier.checkCourseCodeAlpha("STA237"));
        assertTrue(courseModifier.checkCourseCodeAlpha("sta237"));
        assertTrue(courseModifier.checkCourseCodeAlpha("STAS237"));
        assertFalse(courseModifier.checkCourseCodeAlpha("ST237"));
        assertTrue(courseModifier.checkCourseCodeAlpha("sta2"));
        assertFalse(courseModifier.checkCourseCodeAlpha(""));
    }

    @Test(timeout = 50)
    public void testCheckCourseCodeNum() {
        assertTrue(courseModifier.checkCourseCodeNum("STA237"));
        assertTrue(courseModifier.checkCourseCodeNum("sta237"));
        assertFalse(courseModifier.checkCourseCodeNum("STAS237"));
        assertTrue(courseModifier.checkCourseCodeNum("ST2237"));
        assertFalse(courseModifier.checkCourseCodeNum(""));
    }

    @Test(timeout = 50)
    public void testCheckSectionCodeLength() {
        assertTrue(courseModifier.checkSectionCodeLength("LEC 0101"));
        assertTrue(courseModifier.checkSectionCodeLength("lec 0101"));
        assertFalse(courseModifier.checkSectionCodeLength("LEC0101"));
        assertFalse(courseModifier.checkSectionCodeLength("-"));
        assertFalse(courseModifier.checkSectionCodeLength(""));
    }

    @Test(timeout = 50)
    public void testCheckSectionCodeAlpha() {
        assertTrue(courseModifier.checkSectionCodeAlpha("LEC 0101"));
        assertTrue(courseModifier.checkSectionCodeAlpha("lec 0101"));
        assertFalse(courseModifier.checkSectionCodeAlpha("0101 LEC"));
        assertTrue(courseModifier.checkSectionCodeAlpha("LEC0101"));
    }

    @Test(timeout = 50)
    public void testCheckSectionCodeNum() {
        assertTrue(courseModifier.checkSectionCodeNum("LEC 0101"));
        assertTrue(courseModifier.checkSectionCodeNum("lec 0101"));
        assertFalse(courseModifier.checkSectionCodeNum("LECtu101"));
        assertTrue(courseModifier.checkSectionCodeNum("LEC00101"));
    }

    @Test(timeout = 50)
    public void testCheckLocation() {
        assertTrue(courseModifier.checkLocation("BA 2222"));
        assertTrue(courseModifier.checkLocation("BA22222"));
        assertTrue(courseModifier.checkLocation("ba 2222"));
        assertTrue(courseModifier.checkLocation("baa2222"));
        assertFalse(courseModifier.checkLocation("2222"));
        assertFalse(courseModifier.checkLocation(""));
    }

    @Test(timeout = 50)
    public void testCheckDay() {
        assertTrue(courseModifier.checkDay("Mon"));
        assertTrue(courseModifier.checkDay("MON"));
        assertTrue(courseModifier.checkDay("mon"));
        assertFalse(courseModifier.checkDay("non"));
        assertFalse(courseModifier.checkDay("on"));
        assertTrue(courseModifier.checkDay("Mon"));
    }

    @Test(timeout = 50)
    public void testCheckTime() {
        assertTrue(courseModifier.checkTime("0"));
        assertTrue(courseModifier.checkTime("1"));
        assertTrue(courseModifier.checkTime("24"));
        assertFalse(courseModifier.checkTime("25"));
        assertFalse(courseModifier.checkTime("2.6"));
        assertFalse(courseModifier.checkTime("2.0"));
    }

    @Test(timeout = 50)
    public void testCheckStartEndTime() {
        assertTrue(courseModifier.checkStartEndTime("12", "14"));
        assertTrue(courseModifier.checkStartEndTime("0", "1"));
        assertFalse(courseModifier.checkStartEndTime("2", "1"));
    }

    @Test(timeout = 50)
    public void testCheckCourseExists() {
        Interval i1 = new Interval(2160, 2220);
        Location loca1 = new Location("BA 2222");
        Lecture l1 = new Lecture(i1, loca1);
        ArrayList<Lecture> lectures1 = new ArrayList<>();
        lectures1.add(l1);
        Course c1 = new Course("STA237", "LEC 0302", lectures1);
        ArrayList<Course> courses1 = new ArrayList<>();
        courses1.add(c1);
        Timetable t1 = new Timetable(courses1);

        assertTrue(courseModifier.checkCourseExists(t1, "STA237"));
        assertFalse(courseModifier.checkCourseExists(t1, "CSC207"));
    }
}
