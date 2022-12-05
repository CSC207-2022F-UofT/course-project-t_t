package useCases;

import entities.Course;
import entities.Lecture;
import entities.Timetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * useCase responsible for finding common busy timeslots and common free timeslots from an ArrayList of User.
 */
public class CourseComparer {
    /**
     *
     * @param timetable1 A timetable.
     * @param timetable2 Another timetable.
     * @return An ArrayList of Courses contained in both timetable1 and timetable2.
     */
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

    /**
     *
     * @param course
     * @param lecture
     * @return
     */
    private static String getLectureHash(Course course, Lecture lecture){

        String delimiter = "__SPLIT__";

        return course.getCourseCode()
                + delimiter + course.getSectionCode()
                + delimiter + lecture.getInterval().toString()
                + delimiter + lecture.getLocation().toString();
    }
}
