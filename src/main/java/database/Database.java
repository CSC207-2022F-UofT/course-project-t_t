package database;
import entities.*;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private static final ArrayList<User> db = new ArrayList<User>();

    public static ArrayList<User> getDatabase() {
        db.add(new User( "Kim", "cydfk123", new ArrayList<>(), new ArrayList<>()));
        db.add(new User("Soomi", "choi7439", new ArrayList<>(), new ArrayList<>()));
        return db;
    }

    public static void addUser(String username, String password, ArrayList<User> friends, ArrayList<User> blocked) {
        db.add(new User(username, password, friends, blocked));
    }

    public static User getUser(String username) {
        for (User user : db) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<Timetable> getDummyTimetablesTemp() {
        ArrayList<Lecture> dummyLectures1 = new ArrayList<>();

        dummyLectures1.add(
                new Lecture(new Interval(1, 2), new Location("BA 2222"))
        );
        dummyLectures1.add(
                new Lecture(new Interval(4, 5), new Location("BA 2222"))
        );

        ArrayList<Lecture> dummyLectures2 = new ArrayList<>();

        dummyLectures2.add(
                new Lecture(new Interval(3, 5), new Location("BA 2222"))
        );
        dummyLectures2.add(
                new Lecture(new Interval(4, 5), new Location("BA 2222"))
        );


        ArrayList<Course> dummyCourses1 = new ArrayList<>();

        dummyCourses1.add(
                new Course("KIM101", "LEC 0101", dummyLectures1)
        );
        dummyCourses1.add(
                new Course("JJJ265", "LEC 0101", dummyLectures1)
        );

        ArrayList<Course> dummyCourses2 = new ArrayList<>();

        dummyCourses2.add(
                new Course("KIM101", "LEC 0101", dummyLectures2)
        );
        dummyCourses2.add(
                new Course("JJJ265", "LEC 0101", dummyLectures1)
        );

        Timetable dummyTimetable1 = new Timetable(dummyCourses1);
        Timetable dummyTimetable2 = new Timetable(dummyCourses2);

        ArrayList<Timetable> timetables = new ArrayList<>();
        timetables.add(dummyTimetable1);
        timetables.add(dummyTimetable2);

        return timetables;
    }

}