package useCases;

import entities.Timetable;

import java.util.ArrayList;

public class CourseModifier {
    /**
     * Checks if the length of a given course code is 6.
     *
     * @param courseCode1 course code of the course.
     *
     * @return True if the length of courseCode1 equals to 6. False otherwise.
     */
    public boolean checkCourseCodeLength(String courseCode1) {
        // check if the length of the course code is exactly 6
        return courseCode1.length() == 6;
    }

    /**
     * Checks if the first 3 characters of a given course code are alphabetic.
     *
     * @param courseCode2 course code of the course.
     *
     * @return True if the first 3 characters are alphabetic. False otherwise.
     */
    public boolean checkCourseCodeAlpha(String courseCode2) {
        // check if the first 3 chars of the course code are alphabets
        if (courseCode2.length() == 0) {
            return false;
        } else {
            return courseCode2.substring(0, 3).matches("[a-zA-Z]+");
        }
    }

    /**
     * Checks if the last 3 characters of a given course code are numeric.
     *
     * @param courseCode3 course code of the course.
     *
     * @return True if the last 3 characters are numeric. False otherwise.
     */
    public boolean checkCourseCodeNum(String courseCode3) {
        // check if the last 3 chars of the course code are natural nums
        if (courseCode3.length() == 0) {
            return false;
        } else {
            return courseCode3.substring(3, 6).matches("[0-9]+");
        }
    }

    /**
     * Checks if the length of a given section code is 8.
     *
     * @param sectionCode1 section code of the course.
     *
     * @return True if the length of sectionCode1 equals to 8. False otherwise.
     */
    public boolean checkSectionCodeLength(String sectionCode1) {
        // check if the length of the section code is exactly 8
        return sectionCode1.length() == 8;
    }

    /**
     * Checks if the first 3 characters of a given section code are alphabetic.
     *
     * @param sectionCode2 section code of the course.
     *
     * @return True if the first 3 characters are alphabetic. False otherwise.
     */
    public boolean checkSectionCodeAlpha(String sectionCode2) {
        // check if the first 3 chars of the section code are alphabets
        if (sectionCode2.length() == 0) {
            return false;
        } else {
            return sectionCode2.substring(0, 3).matches("[a-zA-Z]+");
        }
    }

    /**
     * Checks if the last 4 characters of a given section code are numeric.
     *
     * @param sectionCode3 section code of the course.
     *
     * @return True if the last 4 characters are numeric. False otherwise.
     */
    public boolean checkSectionCodeNum(String sectionCode3) {
        // check if the last 4 chars of the course code are natural nums
        if (sectionCode3.length() == 0) {
            return false;
        } else {
            return sectionCode3.substring(4, 8).matches("[0-9]+");
        }
    }

    /**
     * Checks if the first 2 characters of a given location are alphabetic.
     *
     * @param location location of the course.
     *
     * @return True if the first 2 characters are alphabetic. False otherwise.
     */
    public boolean checkLocation(String location) {
        if (location.length() == 0) {
            return false;
        } else {
            return location.substring(0, 2).matches("[a-zA-z]+");
        }
    }

    /**
     * Checks if a given day is valid.
     *
     * @param day day that the course is being held.
     *
     * @return True if the given day is in one of the seven days of the week. False otherwise.
     */
    public boolean checkDay(String day) {
        ArrayList<String> days = new ArrayList<>();
        days.add("MON");
        days.add("TUE");
        days.add("WED");
        days.add("THU");
        days.add("FRI");
        days.add("SAT");
        days.add("SUN");

        return days.contains(day.toUpperCase());
    }

    /**
     * Checks if a given time is valid.
     *
     * @param time time that the course is being held.
     *
     * @return True if the given time is in between 0 and 24. False otherwise.
     */
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

    /**
     * Checks if the start time of a course is before the end time.
     *
     * @param startTime start time of the course.
     *
     * @param endTime end time of the course.
     *
     * @return True if the start time is before the end time. False otherwise.
     */
    public boolean checkStartEndTime(String startTime, String endTime) {
        return Integer.parseInt(startTime) < Integer.parseInt(endTime);
    }

    /**
     * Checks if a given course exists in a given timetable.
     *
     * @param timetable timetable of the user.
     *
     * @param courseCode4 course code of the course.
     *
     * @return True if the course exists in the timetable. False otherwise.
     */
    public boolean checkCourseExists(Timetable timetable, String courseCode4) {
        return timetable.getCourses().contains(timetable.getCourse(courseCode4));
    }
}
