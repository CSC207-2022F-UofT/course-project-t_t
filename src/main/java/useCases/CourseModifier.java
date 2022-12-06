package useCases;


import entities.Course;
import entities.Interval;
import entities.Lecture;
import entities.Timetable;

import java.util.ArrayList;

public class CourseModifier {
    public boolean checkCourseCodeLength(String courseCode1) {
        // check if the length of the course code is exactly 6
        return courseCode1.length() == 6;
    }

    public boolean checkCourseCodeAlpha(String courseCode2) {
        // check if the first 3 chars of the course code are alphabets
        if (courseCode2.length() == 0) {
            return false;
        } else {
            return courseCode2.substring(0, 3).matches("[a-zA-Z]+");
        }
    }

    public boolean checkCourseCodeNum(String courseCode3) {
        // check if the last 3 chars of the course code are natural nums
        if (courseCode3.length() == 0) {
            return false;
        } else {
            return courseCode3.substring(3, 6).matches("[0-9]+");
        }
    }

    public boolean checkSectionCodeLength(String sectionCode1) {
        // check if the length of the section code is exactly 8
        return sectionCode1.length() == 8;
    }

    public boolean checkSectionCodeAlpha(String sectionCode2) {
        // check if the first 3 chars of the section code are alphabets
        if (sectionCode2.length() == 0) {
            return false;
        } else {
            return sectionCode2.substring(0, 3).matches("[a-zA-Z]+");
        }
    }

    public boolean checkSectionCodeNum(String sectionCode3) {
        // check if the last 4 chars of the course code are natural nums
        if (sectionCode3.length() == 0) {
            return false;
        } else {
            return sectionCode3.substring(4, 8).matches("[0-9]+");
        }
    }

    public boolean checkLocation(String location) {
        if (location.length() == 0) {
            return false;
        } else {
            return location.substring(0, 2).matches("[a-zA-z]+");
        }
    }

    public boolean checkDay(String day) {
        ArrayList<String> days = new ArrayList<>();
        days.add("MON");
        days.add("TUE");
        days.add("WED");
        days.add("THU");
        days.add("FRI");
        days.add("SAT");
        days.add("SUN");

        return days.contains(day);
    }

    public boolean checkTime(String time) {
        ArrayList<String> times = new ArrayList<>();

        if (time.matches("[0-9]+")) {
            for (int i = 0; i < 25; i++) {
                times.add(Integer.toString(i));
            }

            if (times.contains(time)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean checkStartEndTime(String startTime, String endTime) {
        return Integer.parseInt(startTime) < Integer.parseInt(endTime);
    }

    public boolean checkCourseExists(Timetable timetable, String courseCode4) {
        return timetable.getCourses().contains(timetable.getCourse(courseCode4));
    }
}
