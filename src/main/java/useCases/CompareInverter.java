package useCases;

import entities.Course;
import entities.Lecture;

import java.util.ArrayList;

import static useCases.FreeSlotInverter.dayHelper;

public class CompareInverter {
    public static void timetableToIndex(ArrayList<Course> courses, String[][] schedule) {
        // Given the input courses, converts each interval into the corresponding
        // index in the format of day and time.

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