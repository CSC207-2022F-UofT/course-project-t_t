package useCases;

import entities.Course;
import entities.Lecture;
import entities.Timetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseComparer {
    public static ArrayList<Course> findCommonCourses(Timetable timetable1, Timetable timetable2) {

        HashSet<String> timetable1Lectures = new HashSet<>();

        for (Course course : timetable1.getCourses()) {
            for (Lecture lecture : course.getLectures()) {
                timetable1Lectures.add(getLectureHash(course, lecture));
            }
        }

        ArrayList<Course> sharedCourses = new ArrayList<>();

        for (Course course : timetable2.getCourses()) {

            ArrayList<Lecture> sharedLectures = new ArrayList<>();
            for (Lecture lecture : course.getLectures()) {
                if (timetable1Lectures.contains(getLectureHash(course, lecture))) {
                    sharedLectures.add(lecture);
                }
            }
            if (!sharedLectures.isEmpty()) {
                sharedCourses.add( new Course(course.getCourseCode(), course.getSectionCode(), sharedLectures));
            }
        }
        return sharedCourses;
    }

    private static String getLectureHash(Course course, Lecture lecture){

        String delimiter = "__SPLIT__";

        return course.getCourseCode()
                + delimiter + course.getSectionCode()
                + delimiter + lecture.getInterval().toString()
                + delimiter + lecture.getLocation().toString();
    }
}
