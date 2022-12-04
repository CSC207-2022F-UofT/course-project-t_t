package useCases;

import entities.Course;
import entities.Lecture;
import entities.Timetable;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static useCases.freeSlotInverter.dayHelper;

public class compareInverter {

    public static void timetableToIndex(ArrayList<Course> courses, String[][] schedule) {

        for (Course myCourse : courses) {
            ArrayList<Lecture> myLectures = myCourse.getLectures();
            String courseName = myCourse.getCourseCode();

            for (Lecture lecture : myLectures) {
                int startTime = lecture.getInterval().getStart();
                int endTime = lecture.getInterval().getEnd();

                while (startTime < endTime) {
                    int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                    schedule[startIndex][dayHelper(startTime) + 1] = courseName;
                    startTime += 60;
                }
            }
        }
    }
}