import entities.*;

import java.util.ArrayList;
import java.util.Arrays;

import useCases.LocationSetter;

public class locationSetterTest {
    public static void main(String[] args){
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(4, 6);
        Interval interval3 = new Interval(5, 100);

        //

        Location location1 = new Location("room 1");
        Location location2 = new Location("room 2");

        Lecture lecture1 = new Lecture(interval1, location1);
        Lecture lecture2 = new Lecture(interval2, location2);
        Lecture lecture3 = new Lecture(interval3, location1);

        ArrayList<Lecture> lectures = new ArrayList<>(Arrays.asList(lecture1, lecture2, lecture3));

        Course mat237 = new Course("mat237", "100", lectures);

        ArrayList<Course> courses = new ArrayList<>(Arrays.asList(mat237));

        Timetable timetable = new Timetable(courses);

        User user = new User("jon");
        user.setTimetable(timetable);

        LocationSetter.automaticSetLocation(user);

        System.out.println(user.getLocation().getName());
    }
}
