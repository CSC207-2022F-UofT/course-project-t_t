package useCases;


import entities.Course;
import entities.Timetable;

import java.util.ArrayList;

public class CourseModifier {
    public boolean checkCourseCodeLength(String courseCode1) {
        // check if the length of the course code is exactly 6
        if (courseCode1.length() != 6) {
            return false;
        }
        return true;
    }

    public boolean checkCourseCodeAlpha(String courseCode2) {
        // check if the first 3 chars of the course code are alphabets
        if (!courseCode2.substring(0, 3).matches("[a-zA-Z]+")) {
            return false;
        }
        return true;
    }

    public boolean checkCourseCodeNum(String courseCode3) {
        // check if the last 3 chars of the course code are natural nums
        if (!courseCode3.substring(3, 6).matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public boolean checkSectionCodeLength(String sectionCode1) {
        // check if the length of the section code is exactly 8
        if (sectionCode1.length() != 8) {
            return false;
        }
        return true;
    }

    public boolean checkSectionCodeAlpha(String sectionCode2) {
        // check if the first 3 chars of the section code are alphabets
        if (!sectionCode2.substring(0, 3).matches("[a-zA-Z]+")) {
            return false;
        }
        return true;
    }

    public boolean checkSectionCodeNum(String sectionCode3) {
        // check if the last 4 chars of the course code are natural nums
        if (!sectionCode3.substring(4, 8).matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public boolean checkLocation(String location) {
        if (location.substring(0, 2).matches("[a-zA-z]+")) {
            return true;
        }
        return false;
    }

    public boolean checkDay(String day) {
        ArrayList<String> days = new ArrayList<>();
        days.add("Mon");
        days.add("Tue");
        days.add("Wed");
        days.add("Thu");
        days.add("Fri");
        days.add("Sat");
        days.add("Sun");

        if (days.contains(day)) {
            return true;
        }
        return false;
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
        if (Integer.parseInt(startTime) < Integer.parseInt(endTime)) {
            return true;
        }
        return false;
    }

    public boolean checkCourseExists(Timetable timetable, String courseCode4) {
        if (timetable.getCourses().contains(timetable.getCourse(courseCode4))) {
            return true;
        }
        return false;
    }
}
